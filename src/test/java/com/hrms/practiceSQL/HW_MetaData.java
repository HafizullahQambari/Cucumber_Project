package com.hrms.practiceSQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class HW_MetaData {
	// hw get the resultset metadata store it in the arraylist and retrieve it from arraylist 
	
	public static Connection con;
	public static Statement st;
	public static ResultSet res;
	public static ResultSetMetaData rsMetaData;
	
	String dbUserName="syntax_hrm";
	String dbPassword="syntaxhrm123";
	String query="select emp_firstname, emp_lastname, job_title from hs_hr_employees emp\r\n" + 
			"join ohrm_job_title jobTitle on emp.job_title_code = jobTitle.id";
			
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void metaData() throws SQLException {
		con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
	DatabaseMetaData d=	con.getMetaData();
	System.out.println("My database producer is "+d.getDatabaseProductName());
	System.out.println(d.getTypeInfo());
	System.out.println("_____________________________________________");
	
	
		st=con.createStatement();
		res=st.executeQuery(query);
		rsMetaData=res.getMetaData();
		
		String columnName=rsMetaData.getColumnLabel(1);
		String columnName2=rsMetaData.getColumnLabel(2);
		String columnName3=rsMetaData.getColumnLabel(3);
		
		System.out.println(columnName+"     "+columnName2+"          "+columnName3);
		System.out.println("_____________________________________________________________________");
		
		List<String> empFirstname=new ArrayList<>();
		List<String> empLastname=new ArrayList<>();
		List<String> empJobTitle=new ArrayList<>();
		
		while (res.next()) {
			empFirstname.add(res.getObject("emp_firstname").toString());
			empLastname.add(res.getObject("emp_lastname").toString());
			empJobTitle.add(res.getObject("job_title").toString());
		}
		
		for(int i=1; i<empFirstname.size(); i++) {
			
			System.out.println(empFirstname.get(i)+"             "+empLastname.get(i)+"                    "+empJobTitle.get(i));
		}
	
	}
	
}
	
	
