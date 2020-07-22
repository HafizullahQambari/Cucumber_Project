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

public class Task {
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	String dbUrl="jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	@Test
	public void task() throws SQLException {
	Connection con=	DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from ohrm_nationality");
	ResultSetMetaData rsMetaData=rs.getMetaData();
	
	List<Map<String, String>> data=new ArrayList<>();
	
	Map<String, String>mapData;
	
	while(rs.next()) {
		mapData=new LinkedHashMap<>();
		
		mapData.put("nationlaity id", rs.getObject("id").toString());
		mapData.put("nationality", rs.getObject("name").toString());
		
		data.add(mapData);
		
	}
	
	System.out.println(data);
	for(Map<String, String> alldata:data) {
		System.out.println(alldata);
	}
	
//	
//		for(int i=1; i<=rsMetaData.getColumnCount(); i++) {
//			
//			if(i==1) {
//				mapData.put("Nationality id"+ rsMetaData.getColumnLabel(i), rs.getObject(i).toString());
//			}else {
//				mapData.put("name",rs.getObject(i).toString());
//			}
//			
//		}
//		data.add(mapData);
//		System.out.println(data);
//		
//	}

}
}
