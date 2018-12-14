package com.jp.complaint.controllers;

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

import com.jp.complaint.entities.Complaint;
import com.jp.complaint.exceptions.ComplaintException;
import com.jp.complaint.services.IComplaintService;

/**
 * @author Ritesh Complaint controller which will handle all requests from
 *         dispatcher ending with .compl
 */

@Controller
public class ComplaintController {

	private enum priority {
		High, Medium, Low
	};

	@Autowired
	@Qualifier("service")
	private IComplaintService complaintService;

	private Validator validator;

	// Validator binding for Spring form validation
	@InitBinder
	private void validatorBinder() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		System.out.println("Validator is set." + validator.hashCode());
	}

	/*
	 * Landing page to display Complaint registration form Bind complaint Object
	 */
	@RequestMapping("homePage.compl")
	public String getHomePage(Model model) {
		System.out.println("In getHomePage().");
		Complaint complaint = new Complaint();
		model.addAttribute("complaint", complaint);
		return "CustComplReqForm";
	}

	/*
	 * 
	 * Method to handle request for Complaint form submission Method expects
	 * complaint form binded by ModelAttribute
	 */
	@RequestMapping("submitComplaintData.compl")
	public String submitComplaintData(@ModelAttribute("complaint") Complaint complaint, BindingResult result,
			Model model) {

		System.out.println("In submitComplaintData().");
		Set<ConstraintViolation<Complaint>> violations = validator.validate(complaint);

		// Spring Form Validation
		for (ConstraintViolation<Complaint> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			// Add JSR-303 errors to BindingResult. This allows Spring to
			// display them in view via a FieldError
			FieldError error = new FieldError("complaint", propertyPath, message);

			result.addError(error);
		}

		if (result.hasErrors()) {
			model.addAttribute("msg", "Errors in entry. ");
			return "CustComplReqForm";
		} else {
			try {
				String category = complaint.getCategory();
				switch (category) {
				case "INTERNET_BANKING": {
					complaint.setPriority(priority.High.toString());
					break;
				}
				case "GENERAL_BANKING": {
					complaint.setPriority(priority.Medium.toString());
					break;
				}
				case "OTHERS": {
					complaint.setPriority(priority.Low.toString());
					break;
				}
				}
				complaint.setStatus("Open");
				System.out.println(complaint);
				Long complaintId = complaintService.addNewComplaint(complaint);
				model.addAttribute("complaintId", complaintId);
				return "ComplaintRegSuccess";
			} catch (ComplaintException e) {
				model.addAttribute("msg", "Insert failed. " + e.getMessage());
				return "CustComplReqForm";
			}
		}
	}

	// Landing Page to display Check Complaint Status form
	@RequestMapping("getComplaintStatus.compl")
	public String getCheckStatusPage() {
		System.out.println("In getCheckStatusPage().");
		return "ComplaintStatus";
	}

	// Call to display details of Complaint
	// @input: complaintId
	// @output: Complaint details
	@RequestMapping("getComplaintDetails.compl")
	public ModelAndView getComplaintDetails(@RequestParam("complaintId") Long complaintId) {
		System.out.println("In getComplaintDetails().");
		ModelAndView mAndV = new ModelAndView();

		try {
			if (complaintId != null) {
				Complaint complaint = complaintService.getComplaintDetails(complaintId);
				if (complaint != null) {
					mAndV.addObject("complaintDetails", complaint);
				} else {
					mAndV.addObject("msg", "Complaint with id: " + complaintId + " does not exist!");
				}
			}
			mAndV.setViewName("ComplaintStatus");
		} catch (ComplaintException e) {
			e.printStackTrace();
		}
		return mAndV;
	}

	@RequestMapping("complaintForm.compl")
	public String getComplaintForm(Model model) {
		System.out.println("In getComplaintForm().");
		// Define command object
		Complaint complaint = new Complaint();
		model.addAttribute("complaint", complaint);

		return "CustComplReqForm";
	}

}
