<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=session.getId() %>
<form action="Validate.jsp" method="post">
<table style="background-color: green; margin: auto;">
<tr>
<td> Enter user Email</td>
<td><input type="text" name="email" /></td>
</tr>
<tr>
<td> Enter Password</td>
<td><input type="password" name="password" /></td>
</tr>
<tr>
<td><button type="text" value="login" />Submit</td>
</tr>
</table>
</form>
</body>
</html>