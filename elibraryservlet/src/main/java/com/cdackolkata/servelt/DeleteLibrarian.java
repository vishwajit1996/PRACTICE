package com.cdackolkata.servelt;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.cdackolkata.dao.LibrarianDao;
@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		LibrarianDao.delete(id);
		response.sendRedirect("ViewLibrarian");
	}
}
