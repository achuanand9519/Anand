<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  String a=request.getParameter("uname");
  out.print("<h1>hi sir mr.</h1>"+"<h1>"+a+"</h1>");
  %>

</body>
</html>