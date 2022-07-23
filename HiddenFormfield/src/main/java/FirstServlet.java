import java.io.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class FirstServlet extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("uname");
		out.print("Welcome "+n);
		
		//creating form that have invisible textfield
		out.print("<form action='welcome'>");
		out.print("<input type='hidden' name='uname' value='"+n+"'>");
		out.print("<input type='submit' value='go'>");
		out.print("</form>");
		
		out.close();

                }catch(Exception e){System.out.println(e);}
	}

}

