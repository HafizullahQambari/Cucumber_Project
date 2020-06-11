package com.hrms.steps;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddEmployeeSteps extends CommonMethods {
	
	@Given("user logged in into HRMS")
	public void user_logged_in_into_HRMS() {
	    login.login();
	}

	@Given("user navigate to add Employee Page")
	public void user_navigate_to_add_Employee_Page() {
	    dash.navigateToAddEmployee();
	}

	@When("user enters employees {string} and {string}")
	public void user_enters_employees_and(String fName, String lName) {
	    sendText(addEmp.firstName, fName);
	    sendText(addEmp.lastName, lName);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	    jsClick(addEmp.saveBtn);
	}

	@Then("{string} is added successfully")
	public void is_added_successfully(String expectedName) {
	    String Actual=personalDetails.profilPic.getText();
	    Assert.assertEquals(expectedName, Actual);
	}

	@When("user enters employees firstName and lastName")
	public void user_enters_employees_firstName_and_lastName() {
	    sendText(addEmp.firstName, "Masihullah");
	    sendText(addEmp.lastName, "Haqbin");
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
	    addEmp.employeeId.clear();
	}

	@Then("Employee is added successfully")
	public void employee_is_added_successfully() {
	    String expected="Masihullah Haqbin";
	    String actual=personalDetails.profilPic.getText();
	    Assert.assertEquals("The Employee name dosen't match", expected, actual);
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
	    jsClick(addEmp.checkboxLoginDetails);
	}

	@When("user enters  login credentials")
	public void user_enters_login_credentials() {
	    sendText(addEmp.username, "Rahman");
	    sendText(addEmp.password, "Sofia@123_");
	    sendText(addEmp.password, "Sofia@123_");
	}

	@When("user enter employees {string},{string} and {string}")
	public void user_enter_employees_and(String fName, String mName, String lName) {
	    sendText(addEmp.firstName, fName);
	    sendText(addEmp.middleName, mName);
	    sendText(addEmp.lastName, lName);
	}

	@When("user click save button")
	public void user_click_save_button() {
	    jsClick(addEmp.saveBtn);
	}

	@Then("{string}, {string}, and {string} is added successfully")
	public void and_is_added_successfully(String expectedFname, String expectedMname, String expectedLname) {
	 String actual=personalDetails.profilPic.getText();
	 Assert.assertEquals(expectedFname, actual);
	 Assert.assertEquals(expectedMname, actual);
	 Assert.assertEquals(expectedLname, actual);
	}
	@When("user enters employee details and click on save then employee is added")
	public void user_enters_employee_details_and_click_on_save_then_employee_is_added(DataTable dataTable) {
		List<Map<String, String>> addEmployeeData=dataTable.asMaps();
		
		for(Map<String, String> data:addEmployeeData) {
			String fname=data.get("FirstName");
			String mname=data.get("MidlleName");
			String lname=data.get("LastName");
			
			sendText(addEmp.firstName, fname);
			sendText(addEmp.middleName, mname);
			sendText(addEmp.lastName, lname);
			jsClick(addEmp.saveBtn);
			
			String expected=fname+" "+mname+" "+lname;
			
			String actual=personalDetails.profilPic.getText();
			Assert.assertEquals(expected, actual);
			
		}

	}
	@Then ("Employee is added Successfull")   
	public void employeeAddedSuccssfully() {
		System.out.println("Employee Added");
	}
	
	@When("user enters employee data from {string} excel sheet then employee is added")
	public void user_enters_employee_data_from_excel_sheet_then_employee_is_added(String sheetName) {
	   List<Map<String, String>> excelList=ExcelUtility.excelIntoListOfMaps(Constants.TESTDATA_FILEPATH, sheetName);
	  

		for (Map<String, String> data : excelList) {
			String fname = data.get("FirstName");
			String mname = data.get("MiddleName");
			String lname = data.get("LastName");

			sendText(addEmp.firstName, fname);
			sendText(addEmp.middleName, mname);
			sendText(addEmp.lastName, lname);
			click(addEmp.saveBtn);

			String actual = personalDetails.profilPic.getText();
			String expected = fname + " " + mname + " " + lname;
			Assert.assertEquals("Employee is not addedd successfully", expected, actual);
			jsClick(dash.addEmp);

		}

	}
}