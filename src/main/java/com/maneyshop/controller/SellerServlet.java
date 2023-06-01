package com.maneyshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.OrderDAO;
import com.maneyshop.dao.ProductDAO;
import com.maneyshop.model.Account;
import com.maneyshop.model.Order;
import com.maneyshop.model.Product;

/**
 * Servlet implementation class SellerServlet
 */
@WebServlet("/seller-home")
public class SellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        orderDAO = new OrderDAO();
    }
	
    @Override
    	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		doGet(req, resp);
    	}
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	HttpSession session = req.getSession();
    	Account a = (Account) session.getAttribute("account");
    	String id = Integer.toString(a.getId());
    	
    	
    	// change status of order

    	// PAGGING PRODUCT
		String indexPage = req.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		List<Product> products = productDAO.pageProductbySellID(index, 4, id);
		
		//get the total product to pagging
		int totalProduct = productDAO.getTotalProductbySellID(id);
		int endP = totalProduct / 4;
		if(totalProduct % 4 != 0) {
			endP++;
		}
		
		// PAGGING ORDERS
		String indexPage1 = req.getParameter("index1");
		if(indexPage1 == null) {
			indexPage1 = "1";
		}
		
		int index1 = Integer.parseInt(indexPage1);
		List <Order> orders = orderDAO.loadPageOrder(index1,4);
		int totalOrder = orderDAO.getTotalOrder();
		int endOrder = totalOrder / 4;
		if(totalOrder % 4 != 0) {
			endOrder++;
		}
		
	
		
		session.setAttribute("endP", endP);
		session.setAttribute("tag", index);  
    	session.setAttribute("listP", products);
    	
    	session.setAttribute("endO", endOrder);
    	session.setAttribute("tag1", index1); 
    	session.setAttribute("listO", orders);
    	resp.sendRedirect(req.getContextPath() +"/html/seller.jsp");
    }
}
