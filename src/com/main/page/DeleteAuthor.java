package com.main.page;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.singleton.TestDatabase;

public class DeleteAuthor extends HttpServlet{
	
	TestDatabase test; 
	Connection conn; 
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
	
		String id = request.getParameter("id"); 
		
		test = TestDatabase.newInstance(); 
		conn = test.getConnection(); 
		
		
//		System.out.println("id author yang di delete " + id); 
		
		try {
			
			
			
			String query =  "delete from pengarang_buku where id = ?"; 
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, Integer.valueOf(id));
			
			statement.executeUpdate(); 
			
			
			
			ServletContext sc = getServletContext();
			RequestDispatcher dispatcher = sc.getRequestDispatcher("/DaftarAuthor.jsp"); 
			
			
			dispatcher.forward(request, response);
 			
			
		}catch(Exception e) {
			
		}
		
		
//		String nama = request.getParameter("nama"); 
	}
}
