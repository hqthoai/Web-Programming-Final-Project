package com.maneyshop.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maneyshop.dao.AccountDAO;
import com.maneyshop.model.Account;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/home-login")
public class HomeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDao;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		accountDao = new AccountDAO();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account account = (Account) session.getAttribute("account");
		if(account != null) {
			session.setAttribute("account", account);
//			req.getRequestDispatcher("/authorization") .forward(req, resp);
			resp.sendRedirect(req.getContextPath() + "/authorization");
		} else { //truong hop nho mat khau - cookie
			//check cookie
			Cookie[] cookies = req.getCookies();
			String uname = null;
			String pword = null;
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("username")) {
					uname = cookie.getValue();
				}
				if(cookie.getName().equals("password")) {
					pword = cookie.getValue();
				}
			}
			
			//check cookie uname and pword are correct ?
			if(uname!= null && pword != null) {
				try {
					if(accountDao.validate(uname, pword)) {
						Account account2 = new Account();
						account2.setUsername(uname);
						account2.setPassword(pword);
						session.setAttribute("account", account2);
//						req.getRequestDispatcher("/authorization").forward(req, resp);
						resp.sendRedirect(req.getContextPath() + "/authorization");
			            return;
					} else {
						req.getRequestDispatcher("/login").forward(req, resp);
					}
				} catch(ServletException | IOException e) {
					e.printStackTrace();
				}	
			} else {
				req.getRequestDispatcher("/login").forward(req, resp);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
