package springauth;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntuc.model.department;
import com.ntuc.model.employee;
import com.ntuc.repository.DepartmentRepository;
import com.ntuc.repository.EmployeeRepository;



@Controller
public class DepartmentController {
	@Autowired
	private DepartmentRepository depRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/departments")
	public String listDepartments(Model model) {
		List<department> listdepts = depRepo.findAll();
		model.addAttribute("listDepartments", listdepts);
		return "departments";
	}
	
	@GetMapping("/departments/new")
	public String showNewDeptForm(Model model) {
		
		List<employee> listemployees = empRepo.findAll();
		model.addAttribute("listEmployees",listemployees);
		model.addAttribute("department", new department());
		return "department_form";
	
	}
	
	@PostMapping("/departments/save")
	public String saveDepartment(department dep, HttpServletRequest request) {
		depRepo.save(dep);
		return "redirect:/departments";
	}
	
	@GetMapping("/departments/edit/{id}")
	public String DeparmentEditForm(@PathVariable("id")Integer id, Model model) {
		department dep = depRepo.findById(id).get();
		model.addAttribute("department", dep);
		List<employee> listemp = empRepo.findAll();
		model.addAttribute("listEmployeess", listemp);
		return "department_form";	
	}
	
	@GetMapping("/departments/delete{id}")
	public String DepartmentDeleteForm(@PathVariable("id") Integer id, Model model) {
		depRepo.deleteById(id);
		return "redirect:/departments";
	}
	
	
}

}
