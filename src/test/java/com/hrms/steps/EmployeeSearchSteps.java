package com.hrms.steps;


import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EmployeeSearchSteps extends CommonMethods {
	@Given("user is navigated HRMS")
	public void user_is_navigated_HRMS() {
		setUp();  
	}

	@Given("user is logged with valid admin credentials")
	public void user_is_logged_with_valid_admin_credentials() {
	   sendText(login.username, ConfigsReader.getProperty("username"));
	   sendText(login.password, ConfigsReader.getProperty("password"));
	   click(login.loginBtn);
	}
	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		jsClick(dash.pim);
		jsClick(dash.empList);
	    
	}

	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
	   
	   sendText(empList.empId, "10100");
	}
	@When("click search button")
	public void click_search_button() {
		click(empList.searchBtn);  
	}
	@Then("user see employee informtion is displayed")
	public void user_see_employee_informtion_is_displayed() {
		
	boolean display= empList.getempID.isDisplayed();
	Assert.assertTrue(display);  
	}
	@When("user enters valid employee name and last name")
	public void user_enters_valid_employee_name_and_last_name() {
	   sendText(empList.empName, "Umit Akkaya");
	}


}
