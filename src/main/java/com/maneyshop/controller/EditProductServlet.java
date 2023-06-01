package com.maneyshop.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.ProductDAO;
import com.maneyshop.model.Account;
import com.maneyshop.model.Product;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductDAO productDAO;

	public void init() throws ServletException {
		productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {

		String pID = req.getParameter("pid");
		long cost = Long.parseLong(req.getParameter("price"));
		String date = req.getParameter("pDate");
		String des = req.getParameter("pDes");
		String name = req.getParameter("pName");
		String brand = req.getParameter("pBrand");
		String img = req.getParameter("pImage");
		
		
//		HttpSession session = req.getSession();
//		Account a = (Account) session.getAttribute("account");
//		int sID = a.getId();
//		String sellID = Integer.toString(sID);
		
		Product product = productDAO.getProductbyID(pID);
		product.setPostedData(date);
		product.setProductBrand(brand);
		product.setProductCost(cost);
		product.setProductDes(des);
		product.setProductImage(img);
		product.setProductName(name);
		product.setProductID(pID);
		//Product product = new Product(pID,date,cost,name,des,brand,img,sellID);
		
		productDAO.updateProduct(product);
		response.sendRedirect(req.getContextPath() + "/seller-home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
