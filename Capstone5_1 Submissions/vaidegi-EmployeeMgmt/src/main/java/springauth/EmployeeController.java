package springauth;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService Controller;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		String keyword = null;
		return listByPage(model,1, "name", "asc",keyword);
	}
	
	@GetMapping("/page/{pageNumber}")
	public String listByPage(Model model,@PathVariable("pageNumber") int currentPage,
			@Param("sortField") String sortField,
			@Param("sortDir") String sortDir,
			@Param("keyword") String keyword)	{
		Page<employee> page = controller.listAll(currentPage,sortField,sortDir,keyword);
		Long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		List<employee> listProducts = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.addAttribute("reverseSortDir",reverseSortDir);
		return "index";
	}
	@RestController
	@RequestMapping("/api/v1/")
	public class EmployeeController {

		@Autowired
		private EmployeeRepository employeeRepository;
		
		// get all employees
		@GetMapping("/employees")
		public List<Employee> getAllEmployees(){
			return employeeRepository.findAll();
		}		
		
		// create employee rest api
		@PostMapping("/employees")
		public Employee createEmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}
		
		// get employee by id rest api
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			return ResponseEntity.ok(employee);
		}
		
		// update employee rest api
		
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setEmailId(employeeDetails.getEmailId());
			
			Employee updatedEmployee = employeeRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
		
		// delete employee rest api
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			employeeRepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
		
	}
	
	
	
	