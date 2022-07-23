package in.cdackolkata.narendra;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
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
 * Servlet implementation class SecondServlet
 */
@WebServlet(value = "/SecondServlet",name="SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	   static final String USER = "sys as sysdba";
	   static final String PASS = "test1234";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("Init Method Called for First Servlet");
    	
    	//Class.forName("");
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException | ClassNotFoundException e) {
	       System.out.println("Exception occured"+ e.getMessage());
			e.printStackTrace();
		}
    	
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy Method Called");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("Service Method Called"); }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     System.out.println("Do Get method");	     
	     PrintWriter out=response.getWriter();
	     
	    String userName= request.getParameter("userName");
	    String pwrd= request.getParameter("password");
	    
	    out.println("<html>");
	    out.println("<body bgcolor='blue'>");
	    out.println("User Entered"+userName +","+ pwrd);
	    out.println("</body>");
	    out.println("</html>");
	     
		//out.append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out=response.getWriter();
		     
		    String userName= request.getParameter("userName");
		    String pwrd= request.getParameter("password");
		    
		    out.println("<html>");
		    out.println("<body bgcolor='blue'>");
		    out.println("User Entered"+userName +","+ pwrd);
		    out.println("</body>");
		    out.println("</html>");
	}

}
