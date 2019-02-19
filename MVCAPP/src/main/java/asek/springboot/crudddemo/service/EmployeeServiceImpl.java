package asek.springboot.crudddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asek.springboot.cruddemo.dao.EmployeeRepository;
import asek.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	@Autowired
	public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository) {
		employeeRepository=theEmployeeRepository;
	}
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee =null;
		if(result.isPresent()) {
			theEmployee =result.get();
		}else {
			throw new RuntimeException("Did not find employee with id " +theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void delete(int theId) {
		employeeRepository.deleteById(theId);
	}

}
