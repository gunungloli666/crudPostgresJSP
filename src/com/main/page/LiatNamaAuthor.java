package com.main.page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.model.NamaPengarang;
import com.main.singleton.TestDatabase;

public class LiatNamaAuthor extends HttpServlet{

	TestDatabase testDatabase; 
	Connection conn;

	
	
public void doGet(HttpServletRequest request, HttpServletResponse response){
		

		testDatabase = TestDatabase.newInstance(); 
		conn = testDatabase.getConnection();
		
//		System.out.println("masuk"); 
		
		
//		String id = request.getParameter("user_id"); 
//		String pass = request.getParameter("user_pass"); 
//		
		ServletContext sc = getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher("/Result.jsp"); 
		
		try {
			request.setAttribute("id",  "ahmad"); 
			request.setAttribute("pass", "mubarak"); 
			
			ArrayList<NamaPengarang> daftarNamaPengarang = new ArrayList<>(); 
//			Class.forName("org.postgresql.Driver") ;
			
			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery("select * from pengarang_buku");
			while(resultset.next()) {
				
				String id_ = resultset.getString("id"); 
				String nama = resultset.getString("nama");
				
				NamaPengarang  pengarang = new NamaPengarang(); 
				pengarang.setId(id_);
				pengarang.setNama(nama);
				
				daftarNamaPengarang.add(pengarang);
			}
			
			request.setAttribute( "daftar_pengarang" ,  daftarNamaPengarang); 
			
			
			
			dispatcher.forward(request, response);
		}catch(Exception e) {
			
		}
	}
	
}
