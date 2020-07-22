package com.hrms.practiceSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringData {
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void sdMap() throws SQLException {
		Connection con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
	Statement st=	con.createStatement();
	ResultSet rs=st.executeQuery("select id, name, country_code from ohrm_location");
	
	List<Map<String, String>> data=new ArrayList<>();
	
	Map<String, String> mapData;
	
	while (rs.next()) {
		mapData=new LinkedHashMap<>();
		
		mapData.put("Location id", rs.getObject("id").toString());
		mapData.put("Office name", rs.getObject("name").toString());
		mapData.put("country code", rs.getObject("country_code").toString());
		
		data.add(mapData);
		
		
	}
	System.out.println(data);
	
	for(Map<String, String> alldata:data) {
		
		System.out.println(alldata);
		rs.close();
		st.close();
		con.close();
	}
	
	}	
	
	
	@Test 
	public void retrivedata() throws SQLException {
	
	Connection conn=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	Statement state=conn.createStatement();
	ResultSet rst=state.executeQuery("select * from ohrm_job_title");
	ResultSetMetaData rsMetaData=rst.getMetaData();
	
	List<Map<String, String>> newData=new ArrayList<>();
	Map<String, String> mapData;
	
	while (rst.next()) {
		mapData=new LinkedHashMap<>();
		
		for(int i=1; i<=rsMetaData.getColumnCount(); i++) {
			
			mapData.put(rsMetaData.getColumnName(i), rst.getObject(i).toString());
			System.out.println(mapData);
		}
		newData.add(mapData);
		
		System.out.println(newData);
	}
	
	
	}

}
