

@searchEmployee @sprint13
Feature: Employee Search

	@smoke
  Scenario: Search Employee by Id
    And user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id
    And click search button
    Then user see employee informtion is displayed
    
	@regression
  Scenario: Search employee by name
    
    And user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee name and last name
    And click search button
    Then user see employee informtion is displayed