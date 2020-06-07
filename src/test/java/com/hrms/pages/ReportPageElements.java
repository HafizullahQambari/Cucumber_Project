package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class ReportPageElements extends CommonMethods{
	
	
	@FindBy (xpath="//input[@id='btnAdd']")
	public WebElement addButton;
	
	@FindBy (id="report_report_name")
	public WebElement reportName;
	
	@FindBy (id="report_criteria_list")
	public WebElement selectionCriteria;
	
	@FindBy (id="report_include_comparision")
	public WebElement selectedCriteria;
	
	@FindBy (id="btnAddConstraint")
	public WebElement addskill;
	
	@FindBy (id="report_skill")
	public WebElement selectSkillName;
	
	@FindBy (id="employee_name_empName")
	public WebElement employeeName;
	
	@FindBy (id="report_education")
	public WebElement selectEducation;
	
	@FindBy (id="report_job_title")
	public WebElement jobTitle;
	
	@FindBy (id="report_display_groups")
	public WebElement displayFieldGroup;
	
	
	@FindBy (id="report_display_field_list")
	public WebElement displayField;
	
	@FindBy (id="btnAddDisplayField")
	public WebElement addDisplayField;
	
	
	@FindBy (id="display_group_1")
	public WebElement includeDisplay;
	
	@FindBy (id="btnSave")
	public WebElement saveButton;
	
	
	public ReportPageElements() {
		PageFactory.initElements(driver, this);
	}
		
	
}
