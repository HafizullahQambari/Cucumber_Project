package com.hrms.practiceSQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void dbMetaData() throws SQLException {
		Connection con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		DatabaseMetaData dbMetaData=con.getMetaData();
		String driverName=dbMetaData.getDriverName();
		String dbVersion= dbMetaData.getDatabaseProductVersion();
		
		System.out.println(dbVersion);
		System.out.println(driverName);
		
	}
	@Test
	public void rsMetaData() throws SQLException {
		Connection con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from hs_hr_employees where employee_id= 14688");
		ResultSetMetaData rsMetaData=res.getMetaData();
		int colNumber=rsMetaData.getColumnCount();
		System.out.println(colNumber);
		
		String colName1=rsMetaData.getColumnName(1);
		System.out.println(colName1);
		System.out.println("================usig for loop to print all coloumn names=======================");
		
		for (int i=1; i<=colNumber; i++) {
			
			String colNames=rsMetaData.getColumnName(i);
			System.out.println(colNames);
		}
		// get the result set metadata store it in the arraylist and retrieve it from arraylist
		//also get column type name get the table names
		
		
	}

}
