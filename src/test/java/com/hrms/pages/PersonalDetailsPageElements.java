package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {

	@FindBy (id="personal_txtEmpFirstName")
	public WebElement empFirstName;
	
	@FindBy (id="personal_txtEmpMiddleName")
	public WebElement empMilldeName;
	
	@FindBy (id="personal_txtEmpLastName")
	public WebElement empLastName;
	
	@FindBy (id="personal_txtLicenNo")
	public WebElement empDLicense;
	
	@FindBy (id="//input[@id='personal_txtLicExpDate']")
	public WebElement empDlicenseExpiryD;
	
	
	
	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]")
	public List<WebElement> genderRadioGroup;

	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	
	@FindBy (xpath="//div[@id='profile-pic']/h1")
	public WebElement profilPic;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}