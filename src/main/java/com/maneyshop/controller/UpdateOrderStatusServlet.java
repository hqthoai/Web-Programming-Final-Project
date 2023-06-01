package com.maneyshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.OrderDAO;
import com.maneyshop.model.Order;

/**
 * Servlet implementation class UpdateOrderStatusServlet
 */
@WebServlet("/change-status")
public class UpdateOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderDAO orderDAO = new OrderDAO();
    public UpdateOrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oId = Integer.parseInt(request.getParameter("oid"));
		
		
		Order order = orderDAO.getOrderbyID(oId);
		order.setDeliveryStatus("shipped!");
		orderDAO.updateStatus(order);
		
		response.sendRedirect(request.getContextPath() + "/seller-home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
