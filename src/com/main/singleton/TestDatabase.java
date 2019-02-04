package com.main.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class TestDatabase {

	Connection connection; 

	static private TestDatabase testDatabase; 
	
	public static TestDatabase newInstance() {
		if(testDatabase == null) {
			testDatabase = new TestDatabase(); 
			return testDatabase; 
		}else {
			return testDatabase;
		}
	}
	
	
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	
	
	private  TestDatabase() {
//		System.out.println("mulai membuka koneksi ");
		try {
//			System.out.println("cccxc"); 
			Class.forName("org.postgresql.Driver") ;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/buku", "postgres" , "09huiI" ); 
//			System.out.println("sukses membuka koneksi ");
//			Class.forName("org.postgresql.Driver") ;
//			
//			Statement statement = connection.createStatement();
//			ResultSet resultset = statement.executeQuery("select * from pengarang_buku");
//			while(resultset.next()) {
//				System.out.print( resultset.getString("id") + " "); 
//				System.out.println(resultset.getString("nama"));
//			}
			
			
		}catch(Exception e) {
			System.out.println("error "); 
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new TestDatabase();
		
		
		
		
	}
	
}
