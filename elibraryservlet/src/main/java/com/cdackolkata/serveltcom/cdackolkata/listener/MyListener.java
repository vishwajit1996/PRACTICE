package com.cdackolkata.serveltcom.cdackolkata.listener;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try{  
    		Class.forName("oracle.jdbc.driver.OracleDriver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
    		          
    		//storing connection object as an attribute in ServletContext  
    		ServletContext ctx=sce.getServletContext();  
    		ctx.setAttribute("mycon", con);  
    		          
    		}catch(Exception e){e.printStackTrace();}  
    		}  
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
