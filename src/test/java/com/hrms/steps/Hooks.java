package com.hrms.steps;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods{
	
	@Before
	public void start() {
		BaseClass.setUp();
		
		
	}
	@After
	public void end() {
	BaseClass.tearDown();
	
	}
}
