package com.maneyshop.controller;

import java.io.IOException;

import com.maneyshop.dao.AccountDAO;
import com.maneyshop.model.Account;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accDAO;

    @Override
    public void init() throws ServletException {
        accDAO = new AccountDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String alertMsg = "";
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	if(username == null || password == null) {
    		response.sendRedirect(request.getContextPath() + "/index.jsp");
    		return;
    	}
    	 HttpSession session = request.getSession();
         Boolean remember = Boolean.parseBoolean(request.getParameter("remember"));
         Account account = new Account();
         account.setUsername(username);
         account.setPassword(password);
        if (accDAO.validate(username, password)) {
        	session.setAttribute("account", account);
        	if(remember) {
				Cookie ucookie = new Cookie("username", username);
				ucookie.setMaxAge(60*60); //1hour
				Cookie pcookie = new Cookie("password", password);
				pcookie.setMaxAge(60*60); //1hour
				response.addCookie(ucookie);
				response.addCookie(pcookie);
				
				request.setAttribute("account", account);
				request.getRequestDispatcher("home-login")
				.forward(request, response);
				return;
			} else { //khong luu mat khau
				session.setAttribute("account", account);
				request.setAttribute("account", account);
				request.getRequestDispatcher("home-login")
				.forward(request, response);
				return;
			}
        } else {
        	alertMsg = "Username or Password is wrong!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher("/html/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}