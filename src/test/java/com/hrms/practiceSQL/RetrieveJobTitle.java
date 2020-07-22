package com.hrms.practiceSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RetrieveJobTitle {

	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void arrList() throws SQLException{
		
		Connection con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from ohrm_job_title");
		
		List<String> jobTitle=new ArrayList<>();
	
		while (res.next()) {
			jobTitle.add(res.getObject("job_title").toString());
		}
		System.out.println(jobTitle);
		
		for(String jt:jobTitle) {
			System.out.println(jt);
		}
		
		
		
		
		
}
}
