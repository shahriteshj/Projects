@Def
Feature: scenario outline to test facebook login
Scenario: cucumber scenario

	Given OutlineI am on facebook login page
	When I enter Username as "<username>" 
	And Password as "<password>"
	Then Logins should fail
	|username|password|
	|username1|password1| 
	|username2|password2|


