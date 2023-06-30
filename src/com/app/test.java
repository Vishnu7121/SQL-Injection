package com.app;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// Servlet Name
@WebServlet("/testdb")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
HttpServletResponse response)
		throws ServletException, IOException
	{
		try {

			// Initialize the database
			  String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://db:3306/";
        // Database name to access
        String dbName = "demo1";
        String dbUsername = "srikanth";
        String dbPassword = "17121981";
  
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
			con.close();
			// Get a writer pointer
			// to display the successful result
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Connected"
						+ "</b></body></html>");
		}
		catch (Exception e) {
			e.printStackTrace();
      PrintWriter out = response.getWriter();
			out.println("<html><body><b>"+ e.getMessage() +"</b></body></html>");
		}
	}
}

