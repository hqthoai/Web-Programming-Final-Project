package com.maneyshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maneyshop.dao.CartDAO;
import com.maneyshop.dao.LineItemDAO;
import com.maneyshop.dao.ProductDAO;
import com.maneyshop.model.Cart;
import com.maneyshop.model.LineItem;
import com.maneyshop.model.Product;

@WebServlet("/cart")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = -5024898889919680274L;
    private ProductDAO proDao;
    private CartDAO cartDao;
    private LineItemDAO lineitemDao;

    @Override
    public void init() throws ServletException {
        proDao = new ProductDAO();
        cartDao = new CartDAO();
        lineitemDao = new LineItemDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
       
        String id = req.getParameter("accountId");
        int accountId = -1;
        
        if ( action != null && action.equals("AddCart")) {
        	// If the user is already logged in, save the cart and line items into the database
            if (!id.isEmpty() && id != null) {
                accountId = Integer.parseInt(id);
            }
            String productId = req.getParameter("code");
            String Squantity = req.getParameter("quantity");
            int quantity = Integer.parseInt(Squantity);

            if (productId != null) {
                if (quantity > 0) {
                    Product product = proDao.getProductbyID(productId);
                    LineItem lineItem = new LineItem();
                    lineItem.setProduct(product);
                    lineItem.setQuantity(quantity);

                    Cart cart = (Cart) session.getAttribute("cart");
                    
                    if (cart == null) {
                        cart = new Cart();
                        List<LineItem> newList = new ArrayList<>();
                        newList.add(lineItem);
                        cart.setItems(newList);
                        
                    }
                    else {
                    	 cart.getItems().add(lineItem);
                    }

                    session.setAttribute("cart", cart);

                    if (accountId > -1) {


                        cart.setCusId(accountId);
                       
                        cartDao.saveCart(cart);
                    }
                } else {
                    Cart cart = (Cart) session.getAttribute("cart");
                    if (cart != null) {
                        // Find the line item with the specified product ID and remove it
                        LineItem itemToRemove = null;
                        for (LineItem item : cart.getItems()) {
                            if (item.getProduct().getProductID().equals(productId)) {
                                itemToRemove = item;
                                break;
                            }
                        }
                        if (itemToRemove != null) {
                            cart.removeItem(itemToRemove);
                            session.setAttribute("cart", cart);
                        }
                    }
                }

                resp.sendRedirect(req.getContextPath() + "/html/cart.jsp");
            } else {
                System.out.println("Can not get the product id!");
            }
        } else {
        	resp.sendRedirect(req.getContextPath() + "/html/cart.jsp");
        }
    } 
}
