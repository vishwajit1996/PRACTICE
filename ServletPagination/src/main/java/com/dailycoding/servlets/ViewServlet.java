package com.dailycoding.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.dailycoding.beans.Department;
import com.dailycoding.beans.Emp;
import com.dailycoding.dao.EmpDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	
	 public void init(ServletConfig config) throws ServletException {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","test1234");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
	 }
	
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		response.setContentType("text/html");
 		PrintWriter out=response.getWriter();
 		
 		String spageid=request.getParameter("page");
 		int pageid=Integer.parseInt(spageid);
 		int total=5;
 		if(pageid==1){}
 		
 		else{
 			pageid=pageid-1;//2-1-=1
 			pageid=pageid*total+1;//6
 		}
 		List<Emp> list=EmpDao.getRecords(pageid,total);

 		out.print("<h1>Page No: "+spageid+"</h1>");
 		out.print("<table border='1' cellpadding='4' width='60%'>");
 		out.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");
 		for(Emp e:list){
 			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getSalary()+"</td></tr>");
 		}
 		out.print("</table>");
 		
 		out.print("<a href='ViewServlet?page=1'>1</a> ");
 		out.print("<a href='ViewServlet?page=2'>2</a> ");
 		out.print("<a href='ViewServlet?page=3'>3</a> ");
 		
 		out.close();
	}
 	
 	
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		PrintWriter out=response.getWriter();
 		String employeeName=request.getParameter("employeeName");
 		String employeesalary=request.getParameter("employeesalary");
 		String departmentName=request.getParameter("departmentName");
 		String departmentManager=request.getParameter("departmentManager");
 		
 		Emp  emp=new Emp();
 		emp.setId(1);
 		emp.setName("Narendra");
 		emp.setSalary(50000);
 		
 		Department department=new Department();
 		department.setDepartmentId(101);
 		department.setDepartmentName("IOT");
 		department.setDepartManager("Sangam sir");
 		
 		emp.setDepartment(department);
 		
 		int rowsInserted=EmpDao.insertEmployeeData(emp);
 		if(rowsInserted==0) {
 			out.println("<h1 color='red'> Registartion got failed please verify the db connection </h1>");
 			RequestDispatcher rd=request.getRequestDispatcher("index.html");
 			rd.include(request, response);
 			
 		}else {
 			
 			out.println("Registartion got succesfull");
 			
 		}
 	
 		
 		
 		
 		
 		
 	}
 	
 	
 	
}
