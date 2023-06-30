package com.app.todo;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class TodoList
 */
@WebServlet("/todoList.do")
public class TodoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOG = LoggerFactory.getLogger(TodoList.class);

	
	//@Resource(name = "jdbc/demo1")
        //private DataSource ds;
	Connection conn;
	
	private TodoService todoService = new TodoService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getSession().getAttribute("name"));
		int user_id=(int) request.getSession().getAttribute("user_id");
		LOG.info("Hello, user");
		try
		{
			LOG.trace("doGet : DBConnection Open");
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
			LOG.info("doGet : Retrive todo list");
			request.setAttribute("todos", todoService.retrieveTodos(user_id,conn));
			LOG.info("doGet : Request from TodoServlet to todoList.jsp");
			request.getRequestDispatcher("view/todoList.jsp").forward(request, response);

		}
		catch(Exception e)
		{
			LOG.error("doGet : Catch block : SQLException : "+e.getMessage());
			log(e.getMessage(), e);
		}
		finally
		{
			try {
				conn.close();
				LOG.trace("doGet : DBConnection Close");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOG.error("doGet : Finally block : SQLException : "+e.getMessage());
				e.printStackTrace();
			}
		}
		

	}

}
