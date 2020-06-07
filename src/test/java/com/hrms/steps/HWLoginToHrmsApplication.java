package com.hrms.steps;

import org.junit.Assert;
import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class HWLoginToHrmsApplication extends CommonMethods {
		@Given("user Navigate to Hrms application")
	public void user_Navigate_to_Hrms_application() {
	    setUp(); 
	}
	@When("user enter valid username and invalid password")
	public void user_enter_valid_username_and_invalid_password() {
	    sendText(login.username, "Admin");
	    sendText(login.password, "254556");
	    login.loginBtn.click();
	}
	@Then("user should the see the error message invalid credentials")
	public void user_should_the_see_the_error_message_invalid_credentials() {
		boolean invalidCredetials=login.errorMsg.isDisplayed();
	    Assert.assertTrue(invalidCredetials);
	}
	@When("user enter valid username but empty password")
	public void user_enter_valid_username_but_empty_password() {
		sendText(login.username, "Admin");
	    sendText(login.password, "");
	    login.loginBtn.click();
	}
	@Then("user should see Password cannot be empty")
	public void user_should_see_Password_cannot_be_empty() {
	    String expectedMessage="Password cannot be empty";
	   String actualMessage=login.errorMsg.getText();
	   Assert.assertEquals(expectedMessage, actualMessage);
	}
	@When("user enter empty username but valid password")
	public void user_enter_empty_username_but_valid_password() {
		sendText(login.username, "");
	    sendText(login.password, "Hum@nhrm123");
	    login.loginBtn.click();
	}
	@Then("user should see Username cannot be empty")
	public void user_should_see_Username_can_not_be_empty() {
	    String expected="Username cannot be empty";
	 String actual=login.errorMsg.getText();
	 Assert.assertEquals(expected, actual);
	}
}


