package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeListPageElements extends BaseClass {
	
	@FindBy (id="empsearch_employee_name_empName")
	public WebElement empName;
	
	
	
	@FindBy (id="empsearch_id")
	public WebElement empId;
	
	@FindBy (id="searchBtn")
	public WebElement searchBtn;
	
	@FindBy (xpath="//a[text()='10100']")
	public WebElement getempID;
	
	public EmployeeListPageElements() {
		PageFactory.initElements(driver, this);
	}

}
