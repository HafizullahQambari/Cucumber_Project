package com.hrms.steps;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user navigate to add Employee Page")
	public void user_navigate_to_add_Employee_Page() {
		dash.navigateToAddEmployee();
	}
	@Given("user logged in into HRMS")
	public void user_logged_in_into_HRMS() {
	    login.login();
	}

	@When("user enters employees firstname and lastname")
	public void user_enters_employees_firstname_and_lastname() {
	    
	    sendText(addEmp.firstName, "Nawid khan");
	    sendText(addEmp.lastName, "Landai");
	    
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	   addEmp.saveBtn.click();
	}

	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
	    System.out.println("Employee added successfully");
	}

	@When("user enters employees first name and last name")
	public void user_enters_employees_first_name_and_last_name() {
		dash.navigateToAddEmployee();
	    sendText(addEmp.firstName, "saleem");
	    sendText(addEmp.lastName, "Shaheen");
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
	    addEmp.employeeId.clear();
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
	   addEmp.checkboxLoginDetails.click();
	}

	@When("user enters  login credentials")
	public void user_enters_login_credentials() {
	    sendText(addEmp.username, "SaleemShaheen");
	    sendText(addEmp.password, "Saheen@123_");
	    
	}

}