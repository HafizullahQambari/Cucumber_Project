package com.hrms.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps extends CommonMethods{
	
	@When("user logged with valid admin credentials")
	public void user_logged_with_valid_admin_credentials() {
	    login.login();
	}

	@Then("user see dashboard menue is displayed")
	public void user_see_dashboard_menue_is_displayed(DataTable dataTable) {
	    List<String> expectedMenu=dataTable.asList();
	    List<String> actualMenu=new ArrayList<>();
	    
	    for(WebElement el:dash.dashmenue) {
	    	actualMenu.add(el.getText());
	    }
	    System.out.println(expectedMenu);
	    System.out.println(actualMenu);
	    
	    Assert.assertTrue(actualMenu.equals(expectedMenu));
	}



}
