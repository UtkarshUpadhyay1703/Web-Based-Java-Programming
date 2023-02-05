<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>Add depts Names: ${requestScope.dept_names}</h5>
<form method="post">
<table style="background-color: green; margin:auto">
<caption>Add department Names</caption>
<tr>
<td>Choose Department</td>
<td><select name="dept_name">
<c:forEach var="deptNm" items="${requestScope }"
</select></td>
</tr>
</table>
</form>
</body>
</html>