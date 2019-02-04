package com.main.page;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.singleton.TestDatabase;

public class UpdateAuthor extends HttpServlet{

	TestDatabase test; 
	Connection conn; 
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		
		TestDatabase test = TestDatabase.newInstance(); 
		conn = test.getConnection(); 
		
		String id = request.getParameter("author_id");
		String nama = request.getParameter("author_name"); 
		
		try {
			
			String query = "update pengarang_buku set nama = ? where id = ?"; 
			PreparedStatement statement = conn.prepareStatement(query);
			
			System.out.println(nama); 
			
			statement.setString(1, nama); 
			statement.setInt(2, Integer.valueOf(id)); 
			
			statement.executeUpdate();
			
			System.out.println("finish update"); 
			
			ServletContext sc = getServletContext();
			RequestDispatcher dispatcher = sc.getRequestDispatcher("/DaftarAuthor.jsp"); 
			
			
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			
			
			
		}
		
	}
	
	
}
