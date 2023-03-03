
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login2
 */
@WebServlet("/login2")
public class login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n =request.getParameter( "uname");
		String d = request.getParameter("pword");
		PrintWriter out=response.getWriter();
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anand","root","root123");
				PreparedStatement ps=con.prepareStatement("select *from details where username=? and password=?");  
						ps.setString(1, n);
				        ps.setString(2, d);
				        ResultSet ros =ps.executeQuery();
				        if(ros.next()) {
				        	RequestDispatcher rd=request.getRequestDispatcher("login3.jsp");
				        	rd.include(request, response);
				        	out.print("details are incorrect");
				        } else {
				        	
				        	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				        	rd.forward(request, response);
				        }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		        	
		 }

	}
