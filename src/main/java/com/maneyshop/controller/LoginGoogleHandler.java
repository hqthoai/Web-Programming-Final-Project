package com.maneyshop.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.maneyshop.dao.AccountDAO;
import com.maneyshop.dao.Constants;
import com.maneyshop.model.Account;
import com.maneyshop.model.GoogleUser;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
@WebServlet(urlPatterns = { "/LoginGoogleHandler" })
public class LoginGoogleHandler extends HttpServlet {
	

		/**
	 * 
	 */
	private static final long serialVersionUID = -6255937175858070258L;

		/**
		 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
		 * @param request servlet request
		 * @param response servlet response
		 * @throws ServletException if a servlet-specific error occurs
		 * @throws IOException if an I/O error occurs
		 */
		protected void processRequest(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String code = request.getParameter("code");
			String accessToken = getToken(code);
			GoogleUser user = getUserInfo(accessToken);
			System.out.println(user);
			HttpSession session = request.getSession();
			AccountDAO accDao = new AccountDAO();
			if(accDao.checkUserEmail(user.getEmail())) {
				//return failed
				String alertMsg = "Username or Password is wrong!";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/html/login.jsp").forward(request, response);
			} else {
				Account account = new Account();
				account.setFirstName(user.getFamily_name());
				account.setLastName(user.getGiven_name());
				account.setEmail(user.getEmail());
				session.setAttribute("account", account);
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
			
		} 

		public static String getToken(String code) throws ClientProtocolException, IOException {
			// call api to get token
			String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
					.bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
							.add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
							.add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
							.add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
					.execute().returnContent().asString();

			JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
			String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
			return accessToken;
		}

		public static GoogleUser getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
			String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
			String response = Request.Get(link).execute().returnContent().asString();

			GoogleUser googlePojo = new Gson().fromJson(response, GoogleUser.class);

			return googlePojo;
		}

		// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the +
		// sign on the left to edit the code.">
		/**
		 * Handles the HTTP <code>GET</code> method.
		 * @param request servlet request
		 * @param response servlet response
		 * @throws ServletException if a servlet-specific error occurs
		 * @throws IOException if an I/O error occurs
		 */
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			processRequest(request, response);
		}

		/**
		 * Handles the HTTP <code>POST</code> method.
		 * @param request servlet request
		 * @param response servlet response
		 * @throws ServletException if a servlet-specific error occurs
		 * @throws IOException if an I/O error occurs
		 */
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			processRequest(request, response);
		}

		/**
		 * Returns a short description of the servlet.
		 * @return a String containing servlet description
		 */
		@Override
		public String getServletInfo() {
			return "Short description";
		}// </editor-fold>

}
