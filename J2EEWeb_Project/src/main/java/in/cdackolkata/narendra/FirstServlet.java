package in.cdackolkata.narendra;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(value = "/FirstServlet",name="FirstServelt", initParams = {
		  @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver"), 
		   @WebInitParam(name = "dburl", value = " jdbc:oracle:thin:@localhost:1521:X!") ,
		   @WebInitParam(name = "username", value = "sys as sysdba "), 
		   @WebInitParam(name = "password", value = "test1234") ,
		 
})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("Init Method Called for First Servlet");
    	
    	//
    	try {
    		ServletConfig sc=getServletConfig();
    		ServletContext context=getServletContext();  
    		ServletContext sc1=sc.getServletContext();
    		Class.forName(sc1.getInitParameter("driver"));
			conn = DriverManager.getConnection(sc.getInitParameter("dburl"), sc.getInitParameter("username"), sc.getInitParameter("password"));
		} catch (SQLException | ClassNotFoundException e) {
	       System.out.println("Exception occured"+ e.getMessage());
			e.printStackTrace();
		}
    	
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out=response.getWriter();
		     
		    String userName= request.getParameter("userName");
		    String pwrd= request.getParameter("password");
		    try {
				conn.createStatement();
				//Servlet Colbaration
			    RequestDispatcher rd=request.getRequestDispatcher("SecondServlet");
			    rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    
		    
			/*
			 * out.println("<html>"); out.println("<body bgcolor='blue'>");
			 * out.println("User Entered"+userName +","+ pwrd); out.println("</body>");
			 * out.println("</html>");
			 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	     
	    String userName= request.getParameter("userName");
	    String pwrd= request.getParameter("password");
	    //Servlet Colbaration
	    RequestDispatcher rd=request.getRequestDispatcher("SecondServlet");
	    rd.forward(request, response);
	    
}
	}


