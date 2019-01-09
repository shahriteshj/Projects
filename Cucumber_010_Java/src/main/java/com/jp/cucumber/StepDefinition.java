package com.jp.cucumber;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;


public class StepDefinition {

	@Given("^sample feature file is ready$")
	public void givenStatement() {
		System.out.println("given statement executed successfully");
	}

	@When("^I run the feature file$")
	public void I_run_the_feature_file() {
		System.out.println("when statement executed successfully");
	}

	@Then("^run should be successful$")
	public void run_should_be_successful() {
		System.out.println("then statement executed successfully");
	}
}
