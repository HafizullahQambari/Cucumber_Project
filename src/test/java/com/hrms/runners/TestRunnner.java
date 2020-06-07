package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features= "src//test//resources//feature//AddEmployee.feature",

		glue="com.hrms.steps",
		dryRun=true,
		
		monochrome=true
		
		
		
		)
public class TestRunnner {
	

}
