import java.io.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//getting value from the query string
		String n=request.getParameter("uname");
		if(n.equalsIgnoreCase("narendra")) {
			out.print("Hello "+n);	
		}else {
			out.print("Not accessaible");	
			//profile logic
		}
	

		out.close();

                }catch(Exception e){System.out.println(e);}
	}
	

}
