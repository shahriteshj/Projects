package com.jp.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;

/*
 * http://localhost:8080/Spring300_MVC_JPA_Rest_Ng/hr/emps
 * http://localhost:8080/Spring300_MVC_JPA_Rest_Ng/hr/empDetails?empId=10
 */

@RestController
public class HomePageController {

	@Autowired
	@Qualifier("service")
	private ServiceEmployee empService;

	/*
	 * @RequestMapping("homePage.hr") public String getHomePage() {
	 * System.out.println("In getHomePage()."); return "HomePage"; }
	 */

	@RequestMapping(value = "/emps", 
			method = RequestMethod.GET, 
			headers = {"Accept=application/json","Access-Control-Allow-Origin=*",
					 "Access-Control-Allow-Headers=X-Requested-With, Content-Type, Accept, Origin, Authorization",
					    "Access-Control-Allow-Methods=GET, POST, PUT, DELETE, OPTIONS",
					    "Access-Control-Allow-Credentials=true" })
	public List<Employee> getEmpList() {
		System.out.println("In getEmpList().");
		List<Employee> empList = null;
		try {
			empList = empService.getEmpList();
			System.out.println(empList);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return empList;
	}

	@RequestMapping(value = "/empDetails", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json")
	public Employee getEmployeeDetails(@RequestParam("empId") int empId) {
		System.out.println("In getEmployeeDetails().");
		Employee emp = null;
		try {
			emp = empService.getEmpDetails(empId);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@RequestMapping(value = "/empDetails2/{empId}",
			method = RequestMethod.GET, 
			headers = "Accept=application/json")
	public Employee getEmployeeDetails2(@PathVariable("empId") int empId) {
		System.out.println("In getEmployeeDetails().");
		Employee emp = null;
		try {
			emp = empService.getEmpDetails(empId);
		} catch (HrException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@RequestMapping(value = "/empCreate",
			headers = "Accept=application/json",
			method = {RequestMethod.POST, RequestMethod.GET})
	public List<Employee> addEmployee(@RequestParam("emp") Employee emp) {
		List<Employee> empList = null;
		System.out.println("In addEmployee1().");
		try {
			empService.addNewEmployee(emp);
			empList = empService.getEmpList();
		} catch (HrException e) {
			e.printStackTrace();
		}

		return empList;
	}
	
	@RequestMapping(value = "/emps/{empId}", headers = "Accept=application/json", method = RequestMethod.DELETE)
	public List<Employee> deleteEmployee(@PathVariable int empId) {
		List<Employee> empList = null;

		try {
			empService.removeEmployee(empId);
			empList = empService.getEmpList();
		} catch (HrException e) {
			e.printStackTrace();
		}

		return empList;
	}

	/*
	 * @RequestMapping("registrationForm.hr") public String
	 * getRegistrationForm(Model model) {
	 * System.out.println("In getRegistrationForm()."); // Define command object
	 * Employee emp = new Employee(); model.addAttribute("command", emp);
	 * 
	 * return "EntryPage"; }
	 */

	/*
	 * @RequestMapping("submitRegistrationData.hr") public String
	 * submitRegistrationData(@ModelAttribute("command") Employee emp,
	 * BindingResult result, Model model) {
	 * 
	 * System.out.println("In submitRegistrationData().");
	 * System.out.println(emp);
	 * 
	 * Set<ConstraintViolation<Employee>> violations = validator.validate(emp);
	 * 
	 * for (ConstraintViolation<Employee> violation : violations) { String
	 * propertyPath = violation.getPropertyPath().toString(); String message =
	 * violation.getMessage(); // Add JSR-303 errors to BindingResult. This
	 * allows Spring to // display them in view via a FieldError FieldError
	 * error = new FieldError("command", propertyPath, "Invalid " + propertyPath
	 * + "(" + message + ")"); result.addError(error); } if (result.hasErrors())
	 * { model.addAttribute("msg", "Errors in entry. "); return "EntryPage"; }
	 * else { try { empService.addNewEmployee(emp); return "SaveSuccess"; }
	 * catch (HrException e) { model.addAttribute("msg", "Insert failed. " +
	 * e.getMessage()); return "EntryPage"; } } }
	 */

}
