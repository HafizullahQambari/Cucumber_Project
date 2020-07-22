package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	@FindBy (xpath="//table[@id='resultTable']")
	public WebElement employeesTable;
	
	@FindBy (xpath="//table[@id='resultTable']//tbody/tr/td[4]")
	public List<WebElement> empLastname;
	
	/**
	 * this Method will verify if the employees table is displayed 
	 * @return boolean value
	 */
	public boolean isTableDisplayed() {
		return employeesTable.isDisplayed();
	}
	
	public List<Map<String, String>> getLastnameFromTable(){
		
		List<Map<String, String>> uiName=new ArrayList<>();
		
		for(WebElement row:empLastname) {
		Map<String, String> storeUiName=new LinkedHashMap<>();
		String tableName=row.getText();
		storeUiName.put("emp_lastname", tableName);
		
		uiName.add(storeUiName);
		}
		return uiName;
		
	}
	
	
	public EmployeeListPageElements() {
		PageFactory.initElements(driver, this);
	}

}
