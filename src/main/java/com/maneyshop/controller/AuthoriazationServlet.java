package com.maneyshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.AccountDAO;
import com.maneyshop.model.Account;
@SuppressWarnings("serial")
@WebServlet("/authorization")
public class AuthoriazationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDao;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		accountDao = new AccountDAO();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =  req.getSession();
		if (session != null && session.getAttribute("account") != null)
		{
			Account account = (Account)session.getAttribute("account");
			int role = accountDao.getUserRoleFromDatabase(account.getUsername());
			Account account2 = accountDao.getAccountByUsername(account.getUsername());
			session.setAttribute("account", account2);
	    	if( role == 0) {
			resp.sendRedirect(req.getContextPath() +"/admin-home");
			} else if (role == 1) {
				resp.sendRedirect(req.getContextPath() + "/seller-home");
			} else if (role == 2) {
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
	        dispatcher.forward(req, resp);
			}
		}
		else
		{
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
