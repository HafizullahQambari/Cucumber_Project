package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		jsClick(dash.pim);
		jsClick(dash.empList);
	}

	@When("user enters valid employee id {string}")
	public void user_enters_valid_employee_id(String empId) {
		sendText(viewEmp.empID, empId);
	}

	@When("click on search button")
	public void click_on_search_button() {
		jsClick(viewEmp.searchBtn);
	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
		boolean display=personalDetails.employeeId.isDisplayed();
		Assert.assertTrue(display);
	}

	@When("user enters valid employee {string} and {string}")
	public void user_enters_valid_employee_name_and_last_name() {
		sendText(viewEmp.empName, "RamP");
		sendText(viewEmp.empID,"12412");

	}
	
	@Then("verify table is displayed")
	public void verify_table_is_displayed() {
	  Assert.assertEquals(true, empList.isTableDisplayed());
	}
 
	@Then("get last name from table")
	public void get_last_name_from_table() {
	    System.out.println(empList.getLastnameFromTable());
	}
	
	@Then("validate last name from UI against database")
	public void validate_last_name_from_UI_against_database() {
	 Assert.assertEquals(DatabaseSteps.DbData, empList.getLastnameFromTable());
	}
}