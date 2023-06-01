package com.maneyshop.controller;

import java.io.IOException;

import com.maneyshop.dao.AccountDAO;
import com.maneyshop.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private AccountDAO accountDao;
	 
	 @Override
	public void init() throws ServletException {
		accountDao = new AccountDAO();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String roleValue = req.getParameter("role");
		int role;
		switch (roleValue) {
		    case "admin":
		        role = 0;
		        break;
		    case "seller":
		        role= 1;
		        break;
		    case "customer":
		    default:
		        role = 2;
		        break;
		}
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		account.setFirstName(firstname);
		account.setLastName(lastname);
		account.setAddress(address);
		account.setEmail(email);
		account.setPhone(phone);
		account.setRole(role);
		System.out.println("Firstname: " + account.getFirstName());
		if(password.length() < 6) {
			account.setPassword("");
			req.setAttribute("account", account);
			req.setAttribute("errorMessage", "Password must have at least 6 digits!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/register.jsp");
            dispatcher.forward(req, resp);
		}
		try {
            boolean isSuccess = accountDao.saveAccount(account);
            System.out.print(isSuccess);
            if (isSuccess) {
            	req.setAttribute("account", account);
            	req.setAttribute("successMessage","Your new account is available! Experience it now!!!");
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, resp);
            } else {

            	req.setAttribute("account", account);
            	req.setAttribute("errorMessage","Register failed! Try again! Somethings error with the bug in sql");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/html/register.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (RuntimeException e) {
        	account.setEmail("");
        	account.setUsername("");
        	req.setAttribute("account", account);
req.setAttribute("errorMessage", "Email or Username are already exist!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/register.jsp");
            dispatcher.forward(req, resp);
        }
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
