package com.hrms.practiceSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo {

	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	// JDBC:driver type:hostname:portnumber/db name
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void abc() throws SQLException{
		
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		
		Statement result= conn.createStatement();
		
		ResultSet rs=result.executeQuery("select * from hs_hr_employees");
		
		rs.next();
		String firstname=rs.getString("emp_firstname");
		System.out.println(firstname);
		
		rs.next();
		String firstname2=rs.getObject("emp_number").toString();// we use object in case if we don't know the datatype inside our column 
		// we have to convert it to String
		System.out.println(firstname2);
		
		while(rs.next()) {
		String	allData=rs.getObject("emp_firstname").toString();
		System.out.println(allData);
		
		}
		rs.close();
		result.close();
		conn.close();
	
	}
	//Retrieve all jobTitles and store them in the arrayList and show that in console
	

}
