<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anand","root","root123");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from details");

while(rs.next())
{
	response.getWriter().println("Name is = "+rs.getString(1));
	response.getWriter().println("Password is = "+rs.getString(2));
}


%>