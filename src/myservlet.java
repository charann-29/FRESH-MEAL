

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import freshmeal.MySqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	        PrintWriter out = response.getWriter();
	     
	        String name = request.getParameter("name");
	        String user = request.getParameter("user");
	        String email = request.getParameter("email");
	        String pass = request.getParameter("pdw");
	         
	        try {
	           Connection con=MySqlConnection.initializedatabse();
	            PreparedStatement ps = con.prepareStatement("insert into freshdb(name,user,email,password) values(?,?,?,?)");
	            ps.setString(1, name);
	            ps.setString(2, user);
	            ps.setString(3, email);
	            ps.setString(4, pass);
	            int i = ps.executeUpdate();
	             
	            if(i > 0) {
	                out.println("You have successfully signed in");
	                response.sendRedirect("login.html");
	            }
	         
	        }  
	        catch(Exception se) {
	            se.printStackTrace();
	        }
	}

}
