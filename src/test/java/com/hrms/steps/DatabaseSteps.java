package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.DBUtils;

import io.cucumber.java.en.When;

public class DatabaseSteps {
	public static List<Map<String, String>> DbData;
	@When("get last name from db")
	public void get_last_name_from_db() {
		
		String sqlQuery="select emp_lastname from hs_hr_employees where employee_id=12345";
		DbData=DBUtils.storeDataFromDB(sqlQuery);
	   
	}
 

}
