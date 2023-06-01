<%@page import="java.util.List"%>
<%@page import="com.maneyshop.dao.ProductDAO"%>
<%@page import="com.maneyshop.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.maneyshop.model.LineItem"%>
<%@page import="com.maneyshop.model.Cart"%>
<%@page import="com.maneyshop.model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Maney Shop</title>
    <link rel="icon" href="../image/logo-re.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/fontawesome.min.css"
          integrity="sha512-Rcr1oG0XvqZI1yv1HIg9LgZVDEhf2AHjv+9AuD1JXWGLzlkoKDVvE925qySLcEywpMAYA/rkg296MkvqBF07Yw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="../css/cart.css">
    <link href="../css/responsiveIndex.css" rel="stylesheet">
    <link href="../fonts/themify-icons/themify-icons.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/cartResponsive.css">
</head>
<body>
<div id="cart-main">
    <div id="header">
        <a href="../home-login">
            <div class="header_logo">
                <!--                <img src="../image/img_1.png" alt="" class="logo">-->
            </div>
        </a>
        <form action="" class="header_search">
            <div class="search">
                <input type="text" required placeholder="Nhập từ khóa cần tìm kiếm ..." class="header_input-search">
                <button role="button" class="header_btn-search">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </form>
        <div id="header-list-id"  class="header_list">
            <ul class="header_list-item">
                <li class="header_sub-list">
                    <a class="font-14 hover-header" href="product-page.jsp">
                        <i class="hover-header1 fas fa-laptop"></i>Sản phẩm
                    </a>
                </li>
                <li class="header_sub-list">
                    <a class="font-14 hover-header" href="tutorial-page.jsp">
                        <i class="hover-header1 fas fa-clipboard-check"></i>Hướng dẫn
                    </a>
                </li>
                <li class="header_sub-list">
                    <a class="font-14 hover-header" href="about-us.jsp">
                        <!--                        <i class="hover-header1 fas fa-bell"></i>-->
                        <i class="hover-header1 fas fa-users"></i>Thông tin
                    </a>
                </li>
                <li class="header_sub-list">
                    <a class="font-14 hover-header" href="#">
                        <i class="hover-header1 fas fa-shopping-cart"></i>Giỏ hàng
                    </a>
                    <div id="icon-cart" class="icon-cart"></div>
                </li>
				<li class="header_sub-list">
				  <% HttpSession sessionHttpSession = request.getSession(false);
				    if(session != null && session.getAttribute("account") != null) {
				      Account account = (Account)session.getAttribute("account");
				  %>
				      <form>
				        <span><%= account.getFirstName() %> <%= account.getLastName() %></span>
				        <button class="logout"><a href="<%=request.getContextPath()%>/logout">Log out</a><i class="fas fa-sign-out-alt"></i></button>
				      </form>
				  <% } else { %>
				      <a class="font-14 hover-header js-btn-login" role="button">
				        <i class="hover-header1 fas fa-user"></i>Đăng Nhập
				      </a>
				  <% } %>
				</li>
            </ul>
        </div>

        <div id="mobile-menu" class="menu-mobile-class">
            <i class="menu-mobile-btn ti-menu"></i>
        </div>
        <div class="progress-container">
            <div class="progress-bar" id="myBar"></div>
        </div>
    </div>
    <div class="cart" class="bg-gray">
        <div class="container padding padding-top-60">
            <div class="address-menu">
                <div class="sub-container">
                    <div class="home-btn sub-container-content">
                        <a role="button" class="btn-circle white-bg" href="../index.jsp">
                            <i class="fas fa-home"></i>
                        </a>
                    </div>
                    <div class="arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                    <div class="current-btn sub-container-content">
                        <span class="info-content black-text rounded-border">Giỏ hàng</span>
                    </div>
                </div>
            </div>
            <div class="cart-info">
                <div class="left-content">
                    <div id="your-cart">
                        <div class="container">
                            <div class="top-content">
                                <div class="top-content-container">
                                    <div class="title">
                                    <span class="content">
                                        <span class="big-text bolder">Giỏ hàng của bạn</span>
                                    </span>
                                    </div>
                                    <div class="btn-clear">
                                        <button class="clear">
                                            <span>Xóa tất cả</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cart-item">
                        <div class="cart-container">
                            <div class="cart-header">
                                <div class="left-provider-content">
                                    <div class="provider-container">
                                        <div class="provider-padding provider-checkbox">
                                            <input type="checkbox" name="checkAllProduct" value="">
                                        </div>
                                        <div class="provider-padding-left provider-info">
                                            <div class="provider-icon">
                                                <img class="provider-logo" src="../image/asus-logo.png" alt="Asus">
                                            </div>
                                        </div>
                                        <div class="provider-padding provider-name">
                                            <span class="normal-text bolder">Asus</span>
                                        </div>
                                        <div class="provider-padding verified-logo">
                                            <i class="fas fa-check-circle"></i>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                           <%
							    Cart cart = (Cart)session.getAttribute("cart");
							%>
							
							<div class="cart-item-info">
							    <div class="container">
							        <% 
							        if(cart != null) {
							        for (LineItem lineItem : cart.getItems()) { 
							        %>
									    <div class="item">
									        <!-- Display line item details -->
									        <div class="left-cart-item">
									            <!-- Display line item thumbnail, name, and SKU -->
									            <div class="item-thumbnail item-padding">
									                <img class="item-logo-thumbnail" src="<%= lineItem.getProduct().getProductImage() %>">
									            </div>
									            <div class="item-info-container item-padding">
									                <span class="item-info-name smaller-text"><%= lineItem.getProduct().getProductName() %></span>
									                <span class="item-info-sku smaller-text light-gray-text">Mã Laptop: <%= lineItem.getProduct().getProductID() %></span>
									            </div>
									        </div>
									        <div class="right-cart-item">
											    <!-- Display quantity and price -->
											    <div class="btn-add-subtract">
											        <button class="btn-padding btn-subtract" onclick="decreaseQuantity('<%= lineItem.getProduct().getProductID()%>', '${account.id}')">
											            <i class="icon-btn fas fa-chevron-down"></i>
											        </button>
											        <div class="btn-padding number"><%= lineItem.getQuantity() %></div>
													<button class="btn-padding btn-add" onclick="increaseQuantity('<%= lineItem.getProduct().getProductID() %>', '${account.id}')">
											            <i class="icon-btn fas fa-chevron-up"></i>
											        </button>
											    </div>
											    <div class="price">
											        <span class="bolder gray-text price-text"><%= lineItem.getProduct().getPriceCurrencyFormat() %><span></span></span>
											    </div>
											</div>
									    </div>
									<% } }%>
							    </div>
							</div>

                        </div>
                    </div>
                    <div class="cart-item">
                        <div class="cart-container">
                            
                            
                        </div>
                    </div>
                </div>
                <div class="right-content">
                    <div class="container">
                        <div class="coupon">
                            <div class="container">
                                <div class="coupon-header">
                                    <span class="coupon-text">Mã giảm giá</span>
                                    <div class="coupon-input-container">
                                        <input class="coupon-input" type="text" placeholder="Nhập mã của bạn">
                                        <button class="confirm-btn"><span>Áp dụng ngay</span></button>
                                    </div>
                                </div>
                                <div class="break">
                                    <hr class="hr-break">
                                </div>
                                <div class="list-applied-coupon">
                                    <div class="coupon container">
                                        <div class="applied-coupon-left">
                                            <div class="coupon-applied">
                                                <div class="coupon-code">
                                                    <span class="bolder larger-text">123Y681209</span>
                                                </div>
                                                <div class="coupon-name padding-10">
                                                    <span class="blue-text smaller-text">Giảm giá 30% dành cho đồ điện tử</span>
                                                </div>
                                                <div class="active-day padding-10">
                                                    <span class="experied-day smaller-text">HSD:</span>
                                                    <span class="red-text smaller-text">đến 30/10/2021</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="applied-coupon-right">
                                            <div class="returned-money">
                                                <span>-</span>
                                                <span class="blue-text">30000<span>đ</span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="coupon container">
                                        <div class="applied-coupon-left">
                                            <div class="coupon-applied">
                                                <div class="coupon-code">
                                                    <span class="bolder larger-text">123Y681209</span>
                                                </div>
                                                <div class="coupon-name padding-10">
                                                    <span class="blue-text smaller-text">Giảm giá 30% dành cho đồ điện tử</span>
                                                </div>
                                                <div class="active-day padding-10">
                                                    <span class="experied-day smaller-text">HSD:</span>
                                                    <span class="red-text smaller-text">đến 30/10/2021</span>
                                                </div>
        
                                            </div>
                                        </div>
                                    
                                        <div class="applied-coupon-right">
                                            <span>-</span>
                                            <span class="blue-text returned-money">30000<span>đ</span></span>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="cash">
                            <div class="container">
                                <div class="cash-title">
                                    <span class="large-text bolder">Thanh toán</span>
                                </div>
                                <!-- <div class="provisional-price" class="padding-10">
                                    <span class="left gray-text">Tạm tính</span>
                                    <span class="right provisional-cash bolder">4300000<span>đ</span></span>
                                </div> -->
                                <div class="final-price" class="padding-10 padding-bottom-20">
                                    <span class="left gray-text">Thành tiền</span>
                                    <span class="right final-cash large-text red-text bolder"><%=cart.getTotalPrice()%><span>đ</span></span>
                                </div>
                                <!-- <div class="VAT" class="padding-10">
                                    <span class="gray-text">(Đã bao gồm VAT)</span>
                                </div> -->
                                <div class="buy">
								    <button class="buy-btn">
								        <a href="../createOrder?action=loadCheckOut&accountid=${account.id}&cartid=${cart.id}">
								            Check out
								        </a>
								    </button>
								</div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
    <div id="footer">
        <div class="footer-main">
            <div class="footer-element">
                <a class="footer-icon" href="https://github.com/sktmaneytri" target="_blank"><i
                        class="fab fa-github"></i></a>
                <a class="footer-icon" href="" target="_blank"><i class="fas fa-globe-asia"></i></a>
                <a class="footer-icon" href="" target="_blank"><i class="fas fa-users"></i></a>
                <p class="copyright">Powered by ManeyTris © Student of the HCMC University of Technology and Education</p>
                <p class="copyright">Copyright © 2023 Maney Inc. All rights reserved.</p>
            </div>
        </div>
    </div>
</div>
<div class="js-login" id="login-main" style="z-index: 1000">
    <div class="login js-login-container">
        <div class="title-login">
            <a class="close-login" role="button"></a>
            <h1 class="title-login-main">Đăng nhập</h1>
            <p class="slogan-login">Hãy tham gia cùng chúng tôi</p>
        </div>
        <div class="border"></div>
        <form action="../login" class="login-form" method='post'>
            <div class="input-login">
                <input class="input-items" name='username' placeholder="Tên đăng nhập" required type="text">
                <input class="input-items" name='password' placeholder="Mật khẩu" required type="password">
                <label>Remember me </label>
			 	<input type='checkbox' name='remember'  value="true">
            </div>
            <button class="btn-login">Đăng nhập</button>
        </form>
        <div class="forgot-pass-main">
            <a class="forgot-pass js-forgot-pass" role="button">Quên mật khẩu</a>
        </div>
        <div class="forgot-pass-main">
            <a class="forgot-pass js-forgot-pass" href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8088../LoginGoogleHandler&response_type=code
		   &client_id=65874880585-drm7k6uedo8thspah0br61v499dk4vrr.apps.googleusercontent.com&approval_prompt=force" role="button">Đăng nhập bằng tài khoản google</a>
        </div>
        <div class="border"></div>
        <div class="new-account">
            <a class="btn-new-account js-new-account" role="button">Tạo tài khoản mới</a>
        </div>
    </div>
</div>
<div class="js-forgot" id="forgot-main" style="z-index: 1000">
    <div class="forgot js-forgot-container">
        <div class="title-forgot">
            <a class="close-forgot" role="button"></a>
            <h1 class="title-forgot-main">Quên mật khẩu</h1>
            <p class="slogan-forgot">Chúng tôi sẽ hỗ trợ tận tình</p>
        </div>
        <div class="border"></div>
        <form action="../forget-password" class="forgot-form" method="post">
            <div class="input-forgot">
                <input class="input-items" name="username" placeholder="Tên đăng nhập" required type="text">
                <input class="input-items" name="email" placeholder="Email" required type="email">
            </div>
            <button class="btn-forgot">Tìm tài khoản</button>
        </form>
        <div class="border"></div>
        <div class="come-back">
            <a class="btn-come-back js-come-back" role="button">Quay trở lại đăng nhập</a>
        </div>
    </div>
</div>
<div class="js-register" id="register-main" style="z-index: 1000">
    <div class="register js-register-container">
        <div class="title-register">
            <a class="close-register js-close-icon" role="button"><i class="fas fa-times"></i></a>
            <h1 class="title-register-main" style="margin: 0; line-height: 1.4;">Đăng kí</h1>
            <p class="slogan-register">Nhanh chóng và dễ dàng</p>
        </div>
        <div class="border"></div>
	        <form action="../register" class="register-form" style="max-width: 500px; margin: 0 auto;">
	    <div class="input-register">
	        <input class="input-items" placeholder="First name" name="firstname" required type="text" style="width: 48%; margin-right: 4%;">
	        <input class="input-items" placeholder="Last name" name="lastname" required type="text" style="width: 48%;">
	        <br><br>
	        <input class="input-items" placeholder="Username" name="username" required type="text" style="width: 100%;">
	        <br><br>
	        <input class="input-items" placeholder="Password" name="password" required type="password" style="width: 100%;">
	        <br><br>
	        <input class="input-items" placeholder="Address" name="address" required type="text" style="width: 100%;">
	        <br><br>
	        <label for="role" style="display: block; font-weight: bold;">Role:</label>
	        <select id="role" name="role" required style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 3px; margin-bottom: 20px;">
	            <option value="">Select a role</option>
	            <option value="customer">Customer</option>
	            <option value="admin">Admin</option>
	            <option value="seller">Seller</option>
	        </select>
	        <input class="input-items" placeholder="Email" name="email" required type="email" style="width: 100%;">
	        <br><br>
	        <input class="input-items" placeholder="Phone" name="phone" required type="text" style="width: 100%;">
	    </div>
	    <div class="register-div">
	        <button class="btn-login" style="background-color: #4CAF50; color: #ffffff; border: none; padding: 10px 20px; border-radius: 3px; cursor: pointer;">Đăng kí</button>
	    </div>
		</form>
    </div>
</div>
<!--Back to top-->
<button id="myBtn">&#8593;</button>
</body>
<script src="../js/register.js"></script>
<script crossorigin="anonymous" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        referrerpolicy="no-referrer"
        src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<script>
    function increaseQuantity(productID, idAccount) {
        var quantityElement = document.querySelector(".btn-add-subtract .number");
        var currentQuantity = parseInt(quantityElement.innerText);
        quantityElement.innerText = currentQuantity + 1;
        updateCart(productID, currentQuantity + 1, idAccount);
    }

    function decreaseQuantity(productID, idAccount) {
        var quantityElement = document.querySelector(".btn-add-subtract .number");
        var currentQuantity = parseInt(quantityElement.innerText);
        if (currentQuantity > 0) {
            quantityElement.innerText = currentQuantity - 1;
            updateCart(productID, currentQuantity - 1, idAccount);
        }
    }

    function updateCart(productID, quantity, idAccount) {
        var url = "../cart?action=AddCart&code=" + encodeURIComponent(productID) + "&quantity=" + encodeURIComponent(quantity) + "&accountId=" + encodeURIComponent(idAccount);
        window.location.href = url;
    }
</script>
<script src="../js/nav-responsive.js"></script>
<script src="../js/BackToTop.js"></script>
<script src="../js/Scroll-Indicator.js"></script>
</html>