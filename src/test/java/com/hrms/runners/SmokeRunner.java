package com.hrms.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "C:\\Users\\baria\\eclipse-workspace\\Hrms\\src\\test\\resources\\feature\\Login.feature", //specify which feature file to run
					//in our case we do say to run all features inside features package
		glue="com.hrms.steps", //where we can find implementation code for gherkin steps?
					//we specify just package
		//dryRun=true, //if set to true it will quickly scan that all gherkin steps have implementation code
//					 if set to true no actual execution will happen
		monochrome = true
		,strict=true
		,tags= "@smoke"
		,plugin= {
				"pretty",//prints gherkin steps in console
				"html:target//cucumber-default-report",//create basic html report in specified location
				"json:target//cucumber.json"
		}
		)

public class SmokeRunner {

	
}