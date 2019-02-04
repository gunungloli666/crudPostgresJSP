<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ page import="com.main.model.*"  %>
<%@ page import="java.util.ArrayList" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String keterangan  =(String) request.getAttribute("ket");

ArrayList<NamaPengarang> list = (ArrayList<NamaPengarang>) request.getAttribute("daftar_pengarang") ;
%>
<h1><%= keterangan  %></h1>


<table>

<%for(NamaPengarang pengarang: list){ 

	String nama = pengarang.getNama(); 
	String id_ = pengarang.getId();
%>
<tr>
<td> <%= id_ %></td>
<td> <%= nama %> </td>
</tr>
<%} %>

</table>

</body>
</html>