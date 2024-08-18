

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import freshmeal.MySqlConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import freshmeal.MySqlConnection;

@WebServlet("/serlogin")
public class serlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	        PrintWriter out = response.getWriter();
	     
	        
	        String user = request.getParameter("uname");
	       
	        String pass = request.getParameter("psw");
	        boolean status=false;
	        try {
	        	 Connection con=MySqlConnection.initializedatabse();
		         PreparedStatement ps = con.prepareStatement("select * from freshdb where user=? and password=?");
	           
	            ps.setString(1, request.getParameter("uname"));	      
	            ps.setString(2,request.getParameter("psw"));
	            System.out.println(ps.toString());
	            ResultSet rst=ps.executeQuery();
	           //  System.out.println(rst.next());
	           
	            if(rst.next()==true){
	           	   response.sendRedirect("freshmeal.html");
	            }
	            else{        	               
	               response.sendRedirect("login.html");
	            }
	            ps.close();
	            con.close();
	        }
	        
	        catch(Exception se) {
	            se.printStackTrace();
	        }
	}

}
