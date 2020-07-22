package com.hrms.API.steps.practice;

public class HardCodedConstants {
	
	public static String updateCreateEmpBody() {
		
		String updateBody = "{\r\n" + "  \"employee_id\": \"" + HardCodedExamples.employeeID + "\",\r\n"
                + "  \"emp_firstname\": \"Hafizullah\",\r\n"
                + "  \"emp_lastname\": \"ServetUpdatedLast\",\r\n"
                + "  \"emp_middle_name\": \"ServetDoNOT Have MiddleName\",\r\n" + "  \"emp_gender\": \"M\",\r\n"
                + "  \"emp_birthday\": \"2000-06-06\",\r\n"
                + "  \"emp_status\": \"Independent contractor\",\r\n"
                + "  \"emp_job_title\": \"API Tester\"\r\n" + "}";
        
        return updateBody;
    

	}
	
}
