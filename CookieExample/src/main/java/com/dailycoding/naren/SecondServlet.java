package com.dailycoding.naren;
import java.io.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class SecondServlet extends HttpServlet {

public void doPost(HttpServletRequest request, HttpServletResponse response){
	try{

	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	Cookie ck[]=request.getCookies();
	out.print("Hello "+ck[0].getValue());
    
	out.close();

         }catch(Exception e){System.out.println(e);}
	}
	

}
