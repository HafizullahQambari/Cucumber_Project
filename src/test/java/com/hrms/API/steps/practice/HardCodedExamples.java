package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;



import org.junit.*;
import org.junit.runners.MethodSorters;
//import org.apache.hc.core5.http.ContentType;
/**
 * this @FixMethodOrder(MethodSorters.Name_Ascending) will execute the @Test annotation in ascending alphabetical order
 * @author baria
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {
	/**
	 * Rest Assured has 3 concepts given - prepare the request when - you are making
	 * the call to the endpoint then - validating
	 * 
	 * @param args
	 */
	static String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	static String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg1NjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTc2NCwidXNlcklkIjoiNjg1In0.8cGE6yyo_Q6_ym0QvOOkBEEge-uF7tKf6sYbuxPmGgo";
	static String employeeID;
	public void sampleTestNotes() {

		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
		/**
		 * JWT require for all calls expires every 12 hours
		 */
		token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUwOTQ4NzAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTEzODA3MCwidXNlcklkIjoiNjg1In0.kIxbW5zXkUCZWtOUd2E5XSzPRe49VHW80aHdyINSOQ4";
		/**
		 * preparing get one employee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16498A").log().all();
		/**
		 * string response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

		getOneEmployeeResponse.prettyPrint();

		getOneEmployeeResponse.then().assertThat().statusCode(200);

	}

	@Test
	public void aPOSTcreatEmployee() {

		RequestSpecification CreateEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token)
				.body("{\r\n" + 
						"  \"emp_firstname\": \"Hafiz\",\r\n" + 
						"  \"emp_lastname\": \"Qambari\",\r\n" + 
						"  \"emp_middle_name\": \"Qam\",\r\n" + 
						"  \"emp_gender\": \"M\",\r\n" + 
						"  \"emp_birthday\": \"1993-04-03\",\r\n" + 
						"  \"emp_status\": \"Employee\",\r\n" + 
						"  \"emp_job_title\": \"QA Tester\"\r\n" + 
						"}").log().all();
		
		
		Response CreateEmployeeResponse=CreateEmployeeRequest.when().post("/createEmployee.php");
		
		CreateEmployeeResponse.prettyPrint();
		/**
		 * jsonPath() to view response body which lets us get the employee ID 
		 * we store employee id as global variable so that we may use it with other calls 
		 */
		employeeID =CreateEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		System.out.println(employeeID);
		
		/**
		 * verifying response status code is 201
		 */
		
		CreateEmployeeResponse.then().assertThat().statusCode(201);
		/**
		 * verifying message using equal to() method manually import static package 
		 * import static.org.hamcrest.Matchers.*;
		 */
		CreateEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created")); 
		
		CreateEmployeeResponse.then().assertThat().body("Employee[0].emp_lastname", equalTo("Qambari"));
		/**
		 * verifying contetn-type using assertThat
		 */
		
		CreateEmployeeResponse.then().assertThat().header("Content-Type", "application/json");
		
	}

	
	@Test
	public void bGETcreatedEmployee() {
		
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json").header("Authorization", token).queryParam("employee_id", employeeID).log().all();
		/**
		 * making call to retrieve created employee
		 */
		Response getCreatedEmployeeResponse=getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
		
		String response=getCreatedEmployeeResponse.prettyPrint();
		String empID=getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		boolean verifyingEmployeeIDMatch=empID.equalsIgnoreCase(employeeID);
		
		Assert.assertTrue(verifyingEmployeeIDMatch);
		
		System.out.println("employee id is match "+verifyingEmployeeIDMatch);
		/**
		 * verifying employee status code is 200
		 */
		
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		/**
		 * second way of stroing objects through jsonPath
		 */
		JsonPath js=new JsonPath(response);
		String emplID=js.getString("employee[0].employee_id");
		String fName=js.getString("employee[0].emp_firstname");
		
		String mName=js.getString("employee[0].emp_middle_name");
		String lName=js.getString("employee[0].emp_lastname");
		String bDay=js.getString("employee[0].emp_birthday");
		String empGender=js.getString("employee[0].emp_gender");
		String jTitle=js.getString("employee[0].emp_job_title");
		String empStatus=js.getString("employee[0].emp_status");
		
		System.out.println(emplID);
		System.out.println(fName);
		System.out.println(mName);
		/**
		 * Verifying that expected firstname, lastname, birthday,gender,jobtitle,empStatus ... matches actual values
		 */
		 
		Assert.assertTrue(emplID.contentEquals(employeeID));
		Assert.assertEquals(employeeID, emplID);
		Assert.assertTrue(fName.contentEquals("Hafiz"));
		Assert.assertTrue(mName.contentEquals("Qam"));
		Assert.assertTrue(lName.contentEquals("Qambari"));
//		Assert.assertTrue(bDay.contentEquals("1993-07-11"));
//		Assert.assertTrue(empGender.contentEquals("M"));
		Assert.assertTrue(jTitle.contentEquals("QA Tester"));
		Assert.assertTrue(empStatus.contentEquals("Employee"));
		
		
		
	
		
	}
	@Test
	public void cGETallEmployees() {
		
		/**
		 * preparing /getAllEmployee call
		 */
		RequestSpecification getAlleEmployeeRequest = given().header("Content-Type", "application/json").header("Authorization", token);
		/**
		 * stroing response into all
		 */
		Response getAlleEmployeeResponse=getAlleEmployeeRequest.when().get("/getAllEmployees.php");
//		getAlleEmployeeResponse.prettyPrint();
		
		String allEmployees=getAlleEmployeeResponse.body().asString();
		/**
		 * this will pass but its worng
		 */
		allEmployees.contains(employeeID);
		
		
		JsonPath js=new JsonPath(allEmployees);
		int sizeOfList=js.getInt("Employees.size()");
		
		System.out.println(sizeOfList);
		
//		for(int i=0; i<=sizeOfList; i++) {
//			/**
//			 * printing all employee id
//			 */
//			String allEmployeeIDs=js.getString("Employees["+i+"].employee_id");
//			
//			System.out.println(allEmployeeIDs);
//			
//			/**
//			 * 
//			 */
//			if(allEmployeeIDs.contentEquals(employeeID)) {
//				System.out.println("Employee ID :"+ employeeID + " is present in body");
//				String employeeFirstName=js.getString("Employees["+i+"].emp_firstname");
//				System.out.println(employeeFirstName);
//				break;
//			}
//			
//		}
		
	}
@Test
	public void dPUTupdateCreatedEmployee(){
		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type", "application/json").header("Authorization", token).body("{\r\n" + 
				"            \"employee_id\": \""+employeeID+"\",\r\n" + 
				"            \"emp_firstname\": \"hafiz\",\r\n" + 
				"            \"emp_middle_name\": \"Qam\",\r\n" + 
				"            \"emp_lastname\": \"Qambari\",\r\n" + 
				"            \"emp_birthday\": \"1993-07-11\",\r\n" + 
				"            \"emp_gender\": \"Male\",\r\n" + 
				"            \"emp_job_title\": \"Developer\",\r\n" + 
				"            \"emp_status\": \"Employee\"\r\n" + 
				"        }");
		Response updateCreatedEmployeeResponse=updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		
		System.out.println(updateCreatedEmployeeResponse);
	}
		
}
