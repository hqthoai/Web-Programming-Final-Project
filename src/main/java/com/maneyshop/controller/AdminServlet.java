package com.maneyshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.AccountDAO;
import com.maneyshop.model.Account;

@WebServlet("/admin-home")
public class AdminServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1795672676230326197L;
	private AccountDAO accDao;
	
	@Override
	public void init() throws ServletException {
		accDao = new AccountDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String idDelete = req.getParameter("deleteId");
		if(idDelete != null) {
			int id = Integer.parseInt(idDelete);
			accDao.DeleteAccount(id);
			System.out.print("Delete successful!");
		}
		String indexPage = req.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		List<Account> accounts = accDao.pageAccount(index, 4);
		//get the total account to pagging
		int totalPage = accDao.getTotalAccounts();
		int endP = totalPage / 4;
		if(totalPage / 4 != 0) {
			endP++;
		}
		
		session.setAttribute("endP", endP);
		session.setAttribute("tag", index);
		session.setAttribute("accounts", accounts);
		resp.sendRedirect(req.getContextPath() +"/html/admin.jsp");
//		req.setAttribute("accounts", accounts);
//		req.getRequestDispatcher("/html/admin.jsp").forward(req, resp);
	}
}
