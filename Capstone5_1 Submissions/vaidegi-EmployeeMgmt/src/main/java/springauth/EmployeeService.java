package springauth;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private ProductRepository repo;
	
//	
	private List<EmployeeVO> employees 
//		
//		if (keyword !=null) {
//			return repo.findAll(keyword);
//		}
//		return repo.findAll();
//	}
	
	public Page<employee> listAll(int pageNumber, String sortField, String sortDir, String keyword){
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
		Pageable pageable = PageRequest.of(pageNumber-1, 5,sort);
		if(keyword!=null) {
		return repo.findAll(keyword,pageable);
		}
		return repo.findAll(pageable);
			
	}
	
	public List<EmployeeVO> getEmployees() {
		System.out.println("EmployeeService.getEmployees() invoked " + employees );
		return employees;
	}
	
	public EmployeeVO getEmployee(int id) {
		System.out.println("EmployeeService.getEmployee(id) invoked " + id );
		return employees.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void addEmployee(EmployeeVO employee) {
		employees.add(employee);
		System.out.println("EmployeeService.addEmployee() invoked " + employee);
	}

	public void updateEmployee(EmployeeVO employee) {
		System.out.println("EmployeeService.updateEmployee() invoked " + employee);
		
	}

	public void deleteEmployee(int id) {
		System.out.println("EmployeeService.deleteEmployee() invoked " + id);
	}

	
}
