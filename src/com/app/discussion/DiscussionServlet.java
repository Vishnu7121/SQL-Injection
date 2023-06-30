package com.app.discussion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.sql.DataSource;

import com.app.todo.Todo;


/**
 * Servlet implementation class DiscussionServletå
 */
@WebServlet("/discussion.do")
public class DiscussionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//@Resource(name = "jdbc/demo1")
   // private DataSource ds;
	Connection conn;
	
	private DiscussionService discussionService = new DiscussionService();   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			// Initialize the database
			  String dbDriver = "com.mysql.jdbc.Driver";
		        String dbURL = "jdbc:mysql://db:3306/";
		        // Database name to access
		        String dbName = "demo1";
		        String dbUsername = "srikanth";
		        String dbPassword = "17121981";
		  
		        Class.forName(dbDriver);
		        conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
			//conn = ds.getConnection();
			request.setAttribute("messages", discussionService.retrieveMessage(conn));
			request.getRequestDispatcher("view/discussion.jsp").forward(request, response);
			
		}
		catch(Exception e)
		{
			log(e.getMessage(), e);
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		String topic = request.getParameter("topic");
		if (topic!=null && description!=null) {
		    
			   try
				{
					// Initialize the database
					  String dbDriver = "com.mysql.jdbc.Driver";
				        String dbURL = "jdbc:mysql://db:3306/";
				        // Database name to access
				        String dbName = "demo1";
				        String dbUsername = "srikanth";
				        String dbPassword = "17121981";
				  
				        Class.forName(dbDriver);
				        conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
					//conn = ds.getConnection();
					Message m=new Message();
					m.setTopic(topic);
					m.setDescription(description);
					discussionService.addMessage(m,conn);
					response.sendRedirect("discussion.do");
					
				}
				catch(Exception e)
				{
					log(e.getMessage(), e);
				}
				finally
				{
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}   
		else
		{
			request.setAttribute("error", "Confirmation password did not match");
			request.getRequestDispatcher("view/registration.jsp").forward(request, response);
		}
	}

}
