package com.jp.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	@RequestMapping("/")
	public String getHomePage(){
		System.out.println("In getHomePage().");
		return "/HomePage.jsp";
	}
	
	@RequestMapping("/homePage")
	public String getHomePage1(){
		System.out.println("In getHomePage().");
		return "/HomePage.jsp";
	}
	
}
