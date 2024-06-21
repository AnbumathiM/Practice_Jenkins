package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn=null;
	public void getDbconnection(String url,String username,String password) throws Throwable
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			
		}
		
	}
	
	public void getDbconnection() {
		try {Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
			
		} catch (Exception e) {
			
		}
	}
	
	
	public ResultSet executeSelectQuery(String query) throws Throwable
	{	ResultSet result = null;
	
		try {
			Statement stat = conn.createStatement();
			result=stat.executeQuery(query);
			
		} catch (Exception e) {
			
		}
		return result;	
	}
	
	public int executeNonSelectQuery(String query) throws Throwable{
		int result=0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
			
			
		} catch (Exception e) {
			
		}return result;
	}
	

	public void closeDbconnection() throws SQLException{

		try {
			conn.close();
			
		} catch (Exception e) {
			
		}
		}
	
}
