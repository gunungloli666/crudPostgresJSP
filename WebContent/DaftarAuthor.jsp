<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<%@ page import="com.main.singleton.TestDatabase"  %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

TestDatabase testDatabase = TestDatabase.newInstance(); 
Connection conn = testDatabase.getConnection();

Statement statement = conn.createStatement();
ResultSet resultset = statement.executeQuery("select * from pengarang_buku order by id asc");


%>

<table>
<% 
while (resultset.next()){
%>
<tr>
<%  String id = resultset.getString("id"); 
	String nama = resultset.getString("nama"); 
%>
<td><%=id%></td>
<td><%=nama%></td>
<%String s = "EditAuthor.jsp" + "?id="+id;%>
<td><a href="<%=s%>">edit</a></td>
<%String d = "deleteAuthor" + "?id=" + id; %>
	<td><a href="<%=d%>">delete</a>
</tr>

<%} %>

</table>
<a href="InputAuthor.jsp">Input</a>
</body>
</html>