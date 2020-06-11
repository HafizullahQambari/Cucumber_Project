package com.hrms.testbase;


import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashBoardPageElements;
import com.hrms.pages.EmployeeListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ReportPageElements;
import com.hrms.steps.ViewEmployeePageElements;



//this class initialize all pages class and stores references in static variables 
//that will called/used in test classes
public class PageInitializer extends BaseClass{
	
	public static LoginPageElements login;
	public static AddEmployeePageElements addEmp;
	public static DashBoardPageElements dash;
	public static PersonalDetailsPageElements personalDetails;
	public static ReportPageElements creatReport;
	public static EmployeeListPageElements empList;
	public static ViewEmployeePageElements viewEmp;
	
	

	public static void initialize() {
		 login=new LoginPageElements();
		
		 dash=new DashBoardPageElements();
		
		 addEmp=new AddEmployeePageElements();
		
		 personalDetails= new PersonalDetailsPageElements();
		
		 creatReport=new ReportPageElements();
		
		empList= new EmployeeListPageElements();
		viewEmp= new ViewEmployeePageElements();
	}

}
