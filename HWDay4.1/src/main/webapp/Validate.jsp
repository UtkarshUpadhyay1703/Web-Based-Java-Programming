<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>This is validate .jsp file</h2>
<%
String email=request.getParameter("email");
String pass=request.getParameter("password");
out.write("<h3>Welcome : "+email+"</h3>");
if(email.equals("IACSD") && pass.equals("123")){
	session.setAttribute("userinfo", email);
	response.sendRedirect("Welcome.jsp");
}else{
	response.sendRedirect("login.jsp");
}
%>
<hr>
<%=request.getParameter("password") %>
<br>
<i><%=request.getParameter("email") %></i>
<hr>
User Email: <h4>${param.email}</h4>
</body>
</html>