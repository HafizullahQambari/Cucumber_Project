
Feature: Add Employee

Background: 
Given user logged in into HRMS
And user navigate to add Employee Page
	
  Scenario: Add new Employee
   
    When user enters employees firstname and lastname
    And user clicks save button
    Then employee is added successfully

  Scenario: Add Employee without employee id
   
    When user enters employees first name and last name
    And user deletes employee id
    And user clicks save button
    Then employee is added successfully

  Scenario: AddEmployee and create Login Credentials

    When user enters employees first name and last name
    And user clicks on create login checkbox
    And user enters  login credentials
    And user clicks save button
    Then employee is added successfully
