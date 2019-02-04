package com.main.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.singleton.TestDatabase;

public class InputAuthor extends HttpServlet{
	
	TestDatabase testDatabase; 
	Connection conn; 

	public void doPost(HttpServletRequest request, HttpServletResponse response){
		testDatabase = TestDatabase.newInstance(); 
		conn = testDatabase.getConnection();
		
		String authorName = request.getParameter("author_name"); 
		
//		System.out.println(authorName);
		
		try {
		
			String query = "insert into pengarang_buku(nama) values(?)"; 
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, authorName);
			
			statement.executeUpdate();
			
			request.setAttribute("ket", "Daftar Pengarang Buku"); 
			
			
			ServletContext sc = getServletContext();
			RequestDispatcher dispatcher = sc.getRequestDispatcher("/DaftarAuthor.jsp"); 
			
			
			dispatcher.forward(request, response);
			
//			System.out.println("yess sudah"); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 		
	}

}
