<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ page import="com.main.singleton.TestDatabase"  %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String nama  = request.getParameter("nama"); 
String id = request.getParameter("id"); 


TestDatabase testDatabase = TestDatabase.newInstance(); 
Connection conn = testDatabase.getConnection();

System.out.println( id); 
PreparedStatement statement = conn.prepareStatement("select * from pengarang_buku where id = ?");

statement.setInt(1, Integer.valueOf(id)); 

ResultSet resultset = statement.executeQuery();
String id_ = "";
String nama_ = ""; 

if( resultset.next()){
	id = resultset.getString("id"); 
	nama = resultset.getString("nama"); 
}
// System.out.println("bisa sampai di sini"); 
%>



<form method="post" action="updateAuthor"  name="form1"> 
<input type="hidden" name="author_id" value="<%=id%>" />
	<table> 
		<tr>
		   <td>NAMA</td>
		   <td>
		   <input type="text" name="author_name" value="<%=nama%>"/>
		   </td>
		</tr>
		<tr>
		<td>
		<td colspan="2">  
		<input type="submit" name="submit" value="OK"  />
		</td>
		</tr>
	</table>
</form>

<a href="DaftarAuthor.jsp">BACK</a>




</body>
</html>