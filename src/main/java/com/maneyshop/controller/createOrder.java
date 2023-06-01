package com.maneyshop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.AccountDAO;
import com.maneyshop.dao.OrderDAO;
import com.maneyshop.dao.ShippingInforDAO;
import com.maneyshop.model.*;

/**
 * Servlet implementation class createOrder
 */
@WebServlet("/createOrder")
public class createOrder extends HttpServlet {
	private AccountDAO accDao;
	private OrderDAO orderDao;
	private ShippingInforDAO shipDao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createOrder() {
        super();
    	accDao = new AccountDAO();
    	orderDao = new OrderDAO();
    	shipDao = new ShippingInforDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		HttpSession session = request.getSession();
		String action =  request.getParameter("action");
		System.out.print(action);
		String accountid = request.getParameter("accountid");
		System.out.print(accountid);
		String address = request.getParameter("address");
		if(action.equals("loadCheckOut")) {	
			if(accountid != null) {
			int id = Integer.parseInt(accountid);
			Account account = accDao.getAccountById(id);
			session.setAttribute("account", account);
			try {
				response.sendRedirect(request.getContextPath() + "/html/check-out.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		String email = req.getParameter("Email");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("address");
		String phone = req.getParameter("phoneNumber");
		String accountId = req.getParameter("accountid");
	    String cartId = req.getParameter("cartid");
		
		Cart cart =(Cart) session.getAttribute("cart");
		Account account = (Account) session.getAttribute("account");
		
		
		long millis=System.currentTimeMillis();  
	      
		    // creating a new object of the class Date  
		 java.sql.Date date = new java.sql.Date(millis);        
		
		double priceShipping = 100000;
		
		if (account != null && cart != null) {
		if(address != null && phone != null) {
			ShippingInfo shippinginfor = new ShippingInfo();
			Order order = new Order();
			shippinginfor.setShipppingAddress(address);
			shippinginfor.setShippingCost(priceShipping);
			shippinginfor.setShippingPhone(phone);
			order.setDeliveryStatus("not done!");
			order.setOrderDate(date);
			order.setShippingInfo(shippinginfor);
			order.setCustomer(account);
			long totalAmount = (long) (cart.getTotalPrice() + shippinginfor.getShippingCost());
			order.setTotalAmount(totalAmount);
			System.out.println(account.getLastName());
			
			try {
				orderDao.saveOrder(order);
				resp.sendRedirect(req.getContextPath()+"/html/checkout-sucess.jsp");
				
			} catch (Exception e) {
				resp.sendRedirect(req.getContextPath()+"/html/check-out.jsp");
				e.printStackTrace();
			}
		}
	}
	}
	

}
