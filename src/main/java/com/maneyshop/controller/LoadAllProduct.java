package com.maneyshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.ProductDAO;
import com.maneyshop.model.Product;

/**
 * Servlet implementation class LoadAllProduct
 */
@WebServlet("/allProduct")
public class LoadAllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductDAO productDAO;
	public void init() throws ServletException {
		productDAO = new ProductDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		List<Product> products = productDAO.pageProduct(index, 5);
		
		//get the total account to pagging
		int totalPage = productDAO.getTotalProduct();
		int endP = totalPage / 5;
		if(totalPage % 5 != 0) {
			endP++;
		}
		//List<Product> products = productDAO.getProductbySellID(id);
		session.setAttribute("endP", endP);
		session.setAttribute("tag", index);  
		
		session.setAttribute("listProduct", products);
		
		response.sendRedirect(request.getContextPath() +"/html/all-product.jsp");
	
	
	}

}