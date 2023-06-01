package com.maneyshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list-product")
public class ListProduct extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get total sp
		int productNum = 25;
		int endPage = productNum/12;
		if(productNum/12 != 0) {
			endPage++;
		}
		req.setAttribute("endP", endPage);
		
		
		
		resp.sendRedirect(req.getContextPath() +"/html/all-product.jsp");
		//String contextPath = req.getContextPath();
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/html/all-product.jsp");
//		
//        dispatcher.forward(req, resp);
	}
}
