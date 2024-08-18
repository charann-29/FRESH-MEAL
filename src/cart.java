

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freshmeal.MySqlConnection;


import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        PrintWriter out = response.getWriter();
     
        String ph = request.getParameter("ph");
        String address=request.getParameter("address");
        String qty = request.getParameter("qty");
        try {
	           Connection con=MySqlConnection.initializedatabse();
	            PreparedStatement p = con.prepareStatement("insert into checkout(ph,address,qty) values(?,?,?)");
	            p.setString(1,ph);
	            p.setString(2,address);
	            p.setString(3,qty);
	            int j = p.executeUpdate();
	            
	            if(j > 0) {
	            	
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('order plced successfully');");
	                out.println("</script>");   
	                response.sendRedirect("freshmeal.html");
	            }
	         
	        }
	        catch(Exception se) {
	            se.printStackTrace();
	        }
		
	}

}
