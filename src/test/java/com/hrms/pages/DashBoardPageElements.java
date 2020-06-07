package com.hrms.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;



public class DashBoardPageElements extends CommonMethods {

	@FindBy(id="welcome")
	public WebElement welcome;
	@FindBy (id="menu_pim_viewPimModule")
	public WebElement pim;
	@FindBy (id="menu_pim_addEmployee")
	
	public WebElement addEmp;
	
	@FindBy (id="menu_pim_viewEmployeeList")
	public WebElement empList;
	
	
	@FindBy (id="menu_core_viewDefinedPredefinedReports")
	WebElement report;

	public DashBoardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
		
	}
	public void navigateToAddEmployee() {
		pim.click();
		wait(2);
		addEmp.click();
		
	}
	public void navidgateToReportPage() {
		pim.click();
		wait(2);
		report.click();
	}
	
	
}
