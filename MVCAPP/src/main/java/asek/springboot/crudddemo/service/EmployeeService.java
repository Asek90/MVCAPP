package asek.springboot.crudddemo.service;

import java.util.List;

import asek.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

public Employee findById(int theId);
public void save(Employee theEmployee);
public void delete(int theId);
public List<Employee> findAll();

}
