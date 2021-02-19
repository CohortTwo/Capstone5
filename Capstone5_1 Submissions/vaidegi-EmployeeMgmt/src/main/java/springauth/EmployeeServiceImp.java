package springauth;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmployeeServiceImp implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
    public List < Employee > getAllEmployees() {
        return employeeRepository.findAll();
    
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Users users = userRepository.getUserByUsername(username);
		
		if (users == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyUserDetails(users);
	}

}
