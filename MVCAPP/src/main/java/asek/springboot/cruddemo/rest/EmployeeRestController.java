package asek.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import asek.springboot.crudddemo.service.EmployeeService;
import asek.springboot.cruddemo.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();

		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";

	}

	@GetMapping("/formForAdd")
	public String formForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}

	@PostMapping("/formForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

		Employee theEmployee = employeeService.findById(theId);

		theModel.addAttribute("employee", theEmployee);

		return "employee-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId){
		employeeService.delete(theId);
		return "redirect:/employees/list";
	}
}