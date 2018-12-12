package com.jp.hr.controllers;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	@Qualifier("serviceProd")
	private ProductService prodService;
	
	private Validator validator;

	@InitBinder
	private void validatorBinder() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		System.out.println("Validator is set." + validator.hashCode());
	}
	
	@RequestMapping("getProdList.prdt")
	public ModelAndView getProdList() {
		System.out.println("In getProdList().");
		ModelAndView mAndV = new ModelAndView();
		try {
			ArrayList<Product> prodList = prodService.getProductList();
			mAndV.addObject("productList", prodList);
			mAndV.setViewName("ProductList");
		} catch (HrException e) {
			e.printStackTrace();
		}
		return mAndV;
	}

	@RequestMapping("prodDetails.prdt")
	public ModelAndView getProductDetails(@RequestParam("prodId") int prodId) {
		System.out.println("In getProductDetails().");
		ModelAndView mAndV = new ModelAndView();

		try {
			Product prod = prodService.getProductDetails(prodId);
			mAndV.addObject("prodDetails", prod);
			mAndV.setViewName("ProductDetails");
		} catch (HrException e) {
			e.printStackTrace();
		}
		return mAndV;
	}

/*	@RequestMapping("registrationForm.hr")
	public String getRegistrationForm(Model model) {
		System.out.println("In getRegistrationForm().");
		// Define command object
		Employee emp = new Employee();
		model.addAttribute("command", emp);

		return "EntryPage";
	}

	@RequestMapping("submitRegistrationData.hr")
	public String submitRegistrationData(@ModelAttribute("command") Employee emp, BindingResult result, Model model) {

		System.out.println("In submitRegistrationData().");
		System.out.println(emp);

		Set<ConstraintViolation<Employee>> violations = validator.validate(emp);

		for (ConstraintViolation<Employee> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			// Add JSR-303 errors to BindingResult. This allows Spring to
			// display them in view via a FieldError
			FieldError error = new FieldError("command", propertyPath, "Invalid " + propertyPath + "(" + message + ")");
			result.addError(error);
		}
		if (result.hasErrors()) {
			model.addAttribute("msg", "Errors in entry. ");
			return "EntryPage";
		} else {
			try {
				empService.addNewEmployee(emp);
				return "SaveSuccess";
			} catch (HrException e) {
				model.addAttribute("msg", "Insert failed. " + e.getMessage());
				return "EntryPage";
			}
		}
	}
	*/
}
