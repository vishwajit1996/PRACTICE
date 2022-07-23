package com.dailycoding.naren;
import java.io.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response){
	try{

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
		
	String n=request.getParameter("userName");
	out.print("Welcome "+n);

	Cookie ck=new Cookie("uname",n);//creating cookie object
	//ck.setMaxAge(0)
       	response.addCookie(ck);//adding cookie in the response

	//creating submit button
	out.print("<form action='/CookieExample/servlet2' method='post'>");
	out.print("<input type='submit' value='go'>");
	out.print("</form>");
		
	out.close();

        }catch(Exception e){System.out.println(e);}
  }
}

