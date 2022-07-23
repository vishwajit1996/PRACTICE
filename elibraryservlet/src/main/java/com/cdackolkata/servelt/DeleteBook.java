package com.cdackolkata.servelt;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.cdackolkata.dao.BookDao;
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao.delete(request.getParameter("callno"));
		response.sendRedirect("ViewBook");
	}
}
