package com.maneyshop.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import com.maneyshop.dao.AccountDAO;
import com.maneyshop.model.Account;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/forget-password")
public class ForgetPasswordServlet extends HttpServlet {

	/**
	 * 
	 */
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
		String action = req.getParameter("action");
		
		
		if (action.equals("checkemail")) {
			String email = req.getParameter("email");
		try {
			//generate code
			Random random = new Random();
			 int code = 10000 + random.nextInt(90000);
			boolean isSuccess = accountDao.checkUserEmail(email);
			if(isSuccess) {
				Account account = accountDao.getAccountByEmail(email);
				account.setCode(code);
				if(sendEmail(account, code)) {
					session.setAttribute("account", account);
					accountDao.UpdateAccount(account);
		            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/verify.jsp");
		            dispatcher.forward(req, resp);
				} else {
					req.setAttribute("FailedMessage", "Some unknown bugs are occurred! Please try again!");
		            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/forget-password.jsp");
		            dispatcher.forward(req, resp);
				}
//				req.setAttribute("successMessage", "The new password has been sent to your email! Please check it!!");
//	            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
//	            dispatcher.forward(req, resp);
			} else {
				req.setAttribute("FailedMessage", "Your email is not correct! Please check it again!!");
	            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/forget-password.jsp");
	            dispatcher.forward(req, resp);
			}
		}catch(Exception e) {
			req.setAttribute("FailedMessage", "Your email is not correct! Please check it again!!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/forget-password.jsp");
            dispatcher.forward(req, resp);
			e.printStackTrace();
			}
		
		} else if (action.equals("changePass")) {
			Account account = (Account) session.getAttribute("account");
			String newPass = req.getParameter("password");
			String verifyPass = req.getParameter("confirmPassword");
			if(newPass.equals(verifyPass)) {
				account.setPassword(newPass);
				accountDao.UpdateAccount(account);
				session.removeAttribute("account");
				RequestDispatcher dispatcher = req.getRequestDispatcher("./index.jsp");
	            dispatcher.forward(req, resp);
			} else {
				req.setAttribute("FailedMessage", "Password not match!!");
	            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/new-password.jsp");
	            dispatcher.forward(req, resp);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Account account = (Account) session.getAttribute("account");
		String Code = req.getParameter("code");
		int verifyCode = Integer.parseInt(Code);
		int code = account.getCode();
		System.out.println(code);
		if(verifyCode == code) {
			session.setAttribute("account", account);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/new-password.jsp");
            dispatcher.forward(req, resp);
		} else {
			req.setAttribute("FailedMessage", "The code you input is not correct, try again!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/verify.jsp");
            dispatcher.forward(req, resp);
		}
	}
	
	private boolean sendEmail(Account account, int code) {
	 boolean test = false;
	 String toEmail = account.getEmail();
	 String fromEmail = "20110422@student.hcmute.edu.vn";
	 String password = "nguyenminhtri16092002";
	 
	 try {
		 Properties properties = System.getProperties();
         properties.put("mail.smtp.host", "smtp.gmail.com");
         properties.put("mail.smtp.port", "465");
         properties.put("mail.smtp.ssl.enable", "true");
         properties.put("mail.smtp.auth", "true");
		 
		 //set session
		 Session session = Session.getInstance(properties, new Authenticator() {
			 @Override
			 protected PasswordAuthentication getPasswordAuthentication() {
				 return new PasswordAuthentication(fromEmail, password);
			 }
		});
		 
		 Message mess = new MimeMessage(session);
		 
		 mess.setFrom(new InternetAddress(fromEmail));
		 mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

		 mess.setText("Hi dear! Thanks for using our servies! Please verify your account using this code: "+ code);
		 
		 Transport.send(mess);
		 test = true;
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	 	return test;
	}
	
	
}
