Feature: Login into Hrms Application

	@smoke
  Scenario: Login with valid username and invalid password
    
    When user enter valid username and invalid password
    Then user should the see the error message invalid credentials
	@smoke
  Scenario: Login with valid username and without password
   
    When user enter valid username but empty password
    Then user should see Password cannot be empty

	@regression 
  Scenario: Login without username and valid password
   
    When user enter empty username but valid password
    Then user should see Username cannot be empty
 