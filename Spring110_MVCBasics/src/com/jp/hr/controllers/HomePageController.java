package com.jp.hr.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;

/*
 * @Controller: A kind of @Component to declare SpringMVC controllers
 * @RequestMapping: To map a controlling method to URL
 * @RequestParam: To take single QueryString or FormData field value
 * 
 * Multi-action controllers.
 */


@Controller
public class HomePageController {

	@Autowired
	@Qualifier("service")
	private ServiceEmployee empService;
	
	@RequestMapping("homePage.hr")
	public String getHomePage(){
		System.out.println("In getHomePage().");
		return "HomePage";
	}
	
	@RequestMapping("getEmpList.hr")
	public ModelAndView getEmpList(){
		System.out.println("In getEmpList().");
		ModelAndView mAndV = new ModelAndView();
		try {
			ArrayList<Employee> empList = empService.getEmpList();
			mAndV.addObject("empList",empList);
			mAndV.setViewName("EmpList");
		} catch (HrException e) {
			e.printStackTrace();
		}		
		return mAndV;
	}
	
	@RequestMapping("empDetails.hr")
	public ModelAndView getEmployeeDetails(@RequestParam("empId") int empId){
		System.out.println("In getEmployeeDetails().");
		ModelAndView mAndV = new ModelAndView();
		
		try {
			Employee emp = empService.getEmpDetails(empId);
			mAndV.addObject("empDetails",emp);
			mAndV.setViewName("EmpDetails");
		} catch (HrException e) {
			e.printStackTrace();
		}
		return mAndV;
	}
	
	
}
