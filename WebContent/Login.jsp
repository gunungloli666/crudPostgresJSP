<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form method="post" action="doLogin"  name="form1"> 
	<table> 
		<tr>
		   <td>USER ID: </td>
		   <td>
		   <input type="text" name="user_id" />
		   </td>
		</tr>
		
		<tr>
			<td>PASSWORD:</td> 
			<td><input type="text" name="user_pass" /> </td>
		</tr>
		
		<tr>
		<td colspan="2">  
		<input type="submit" name="submit" value="LOGIN"  />
		</td>
		</tr>
	</table>
</form>


</body>
</html>