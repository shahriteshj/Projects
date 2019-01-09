@Abc
Feature: To test facebook login
Scenario: cucumber scenario

	Given I am on facebook login page
	When When I enter username as "TOM"
		And I enter password as "JERRY"
	Then Login should fail 



