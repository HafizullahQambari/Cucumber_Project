#Author: Hafiz


Feature: Add Employee

  Background: 
    Given user logged in into HRMS
    And user navigate to add Employee Page

  Scenario: Add new Employee
    When user enters employees "John" and "Smith"
    And user clicks save button
    Then "John Smith" is added successfully

  Scenario: Add Employee without employee id
    When user enters employees firstName and lastName
    And user deletes employee id
    And user clicks save button
    Then Employee is added successfully

  Scenario: AddEmployee and create Login Credentials
    When user enters employees firstName and lastName
    And user clicks on create login checkbox
    And user enters  login credentials
    And user clicks save button
    Then Employee is added successfully

  @regression
  Scenario Outline: Adding multiple employees
    When user enter employees "<FirstName>","<MiddleName>" and "<LastName>"
    And user click save button
    Then "<FirstName>", "<MiddleName>", and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName |
      | Hafiz     | Q          | Qambari  |
      | jawid     | J          | Online   |
      | Saif      | Z          | zuman    |
      | haron     | H          | sakhi    |

  @regression
  Scenario: Adding multiple employees
    When user enters employee details and click on save then employee is added
      | FirstName | MiddleName | LastName |
      | shahram   | Abdul      | parsa    |
      | bahram    | Aziz       | parsa    |
@regression
   Scenario: Adding multiple employees from excel
   When user enters employee data from "EmployeeLoginCredentials" excel sheet then employee is added