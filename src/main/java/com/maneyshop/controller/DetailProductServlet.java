package com.maneyshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.ProductDAO;
import com.maneyshop.model.Product;

/**
 * Servlet implementation class DetailProductServlet
 */
@WebServlet("/detailProduct")
public class DetailProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDAO = new ProductDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String id = request.getParameter("pid");
		Product p = productDAO.getProductbyID(id);
		session.setAttribute("product", p);

		response.sendRedirect("html/product-page.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}