<%@page import="com.maneyshop.model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <title>Tutorial</title>
    <title>Metaverse Laptop</title>
    <link rel="icon" href="../image/logo-re.png">
    <link href="../fonts/themify-icons/themify-icons.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          referrerpolicy="no-referrer" rel="stylesheet"/>
    <link href="../css/style-tutorial.css" rel="stylesheet">
    <link href="../css/responsiveIndex.css" rel="stylesheet">
    <link href="../css/reponsiveIndex.css" rel="stylesheet">
</head>

<body>

<div id="main-tutorial">
    <div id="header">
        <a href="../home-login">
            <div class="header_logo">
                <!--                <img src="../image/img_1.png" alt="" class="logo">-->
            </div>
        </a>
        <form action="" class="header_search">
            <div class="search">
                <input class="header_input-search" placeholder="Nhập từ khóa cần tìm kiếm" required type="text">
                <button class="header_btn-search" role="button">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </form>
        <div class="header_list" id="header-list-id">
            <ul class="header_list-item">
                <li class="header_sub-list">
                    <a class="font-14 hover-header" href="all-product.jsp">
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
                        <i class="hover-header1 fas fa-users"></i>Thông tin
                    </a>
                </li>
                <li id="li-cart" class="header_sub-list">
                    <a class="font-14 hover-header" href="cart.jsp">
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

        <div class="menu-mobile-class" id="mobile-menu">
            <i class="menu-mobile-btn ti-menu"></i>
        </div>

        <div class="progress-container">
            <div class="progress-bar" id="myBar"></div>
        </div>


    </div>

    <div id="cart-hover" class="hover-cart">
        <div class="cover-cart-item">
            <div class="cart-item">
                <div class="img-cart-item" style="background-image: url(../image/image99.png)">

                </div>
                <div class="details-cart-item">
                    <div class="infor-cart-item">Màn hình LCD VIEWSONIC VP2458 (1920 x 1080/IPS/60Hz/5 ms)</div>
                    <div class="num-cart-item">Số lượng: 2</div>
                    <div class="price-cart-item">5.620.000đ</div>
                </div>
            </div>
            <div class="cart-item">
                <div class="img-cart-item" style="background-image: url(../image/image99.png)">

                </div>
                <div class="details-cart-item">
                    <div class="infor-cart-item">Màn hình LCD VIEWSONIC VP2458 (1920 x 1080/IPS/60Hz/5 ms)</div>
                    <div class="num-cart-item">Số lượng: 2</div>
                    <div class="price-cart-item">5.620.000đ</div>
                </div>
            </div>
            <div class="cart-item">
                <div class="img-cart-item" style="background-image: url(../image/image99.png)">

                </div>
                <div class="details-cart-item">
                    <div class="infor-cart-item">Màn hình LCD VIEWSONIC VP2458 (1920 x 1080/IPS/60Hz/5 ms)</div>
                    <div class="num-cart-item">Số lượng: 2</div>
                    <div class="price-cart-item">5.620.000đ</div>
                </div>
            </div>
            <div class="cart-item">
                <div class="img-cart-item" style="background-image: url(../image/image99.png)">

                </div>
                <div class="details-cart-item">
                    <div class="infor-cart-item">Màn hình LCD VIEWSONIC VP2458 (1920 x 1080/IPS/60Hz/5 ms)</div>
                    <div class="num-cart-item">Số lượng: 2</div>
                    <div class="price-cart-item">5.620.000đ</div>
                </div>
            </div>
            <div class="cart-item">
                <div class="img-cart-item" style="background-image: url(../image/image99.png)">

                </div>
                <div class="details-cart-item">
                    <div class="infor-cart-item">Màn hình LCD VIEWSONIC VP2458 (1920 x 1080/IPS/60Hz/5 ms)</div>
                    <div class="num-cart-item">Số lượng: 2</div>
                    <div class="price-cart-item">5.620.000đ</div>
                </div>
            </div>
        </div>
        <div class="total-cart">
            <div class="total-price-infor">
                <div class="total-product">Tổng tiền (2) sản phẩm</div>
                <div class="total-price">11.240.000đ</div>
            </div>
            <div role="button" class="btn-view-cart"><a href="cart.jsp" class="btn-tt">Xem giỏ hàng</a></div>
        </div>
    </div>
    <div id="container">
        <div class="title-tutorial">HƯỚNG DẪN MUA HÀNG</div>
        <div class="step">Bước 1: Đăng nhập</div>
        <div class="content-tutorial">Trước khi mua hàng, bạn cần đăng nhập vào tài khoản của mình</div>
        <div class="img-tutorial" style="background-image: url(../image/Tutorial/tutorial-login.png)"></div>
        <div class="content-tutorial">Trong trường hợp bạn quên mật khẩu, bạn có thể nhấp vào <strong>Quên mật khẩu</strong> và làm theo hướng dẫn sau đó</div>
        <div class="img-tutorial" style="background-image: url(../image/Tutorial/tutorial-fogot.png)"></div>
        <div class="content-tutorial">Nếu bạn chưa có tài khoản, bạn cũng có thể nhấp vào <strong>Tạo tài khoản mới</strong> và tiến hành làm theo hướng dẫn</div>
        <div class="img-tutorial" style="background-image: url(../image/Tutorial/tutorial-register.png)"></div>
        <div class="step">Bước 2: Tìm sản phẩm cần mua</div>
        <div class="content-tutorial">Sử dụng ô tìm kiếm phía trên, gõ tên sản phẩm muốn mua (có thể tìm đích danh 1 sản phẩm, tìm theo hãng...)</div>
        <div class="img-tutorial" style="background-image: url(../image/Tutorial/tutorial1.png)"></div>
        <div class="content-tutorial">Trang web luôn có sẵn những gợi ý sản phẩm hot nhất, có chương trình khuyến mãi hấp dẫn, bạn cũng có thể chọn xem ngay mà không cần tìm kiếm</div>
        <div class="img-tutorial" style="background-image: url(../image/Tutorial/tutorial2.png)"></div>
        <div class="content-tutorial">Hoặc bạn cũng có thể tham khảo các sản phẩm bán chạy nhất ở cuối trang</div>
        <div class="img-tutorial" style="background-image: url(../image/Tutorial/tutorial3.png)"></div>
        <div class="step">Bước 3: Đặt mua sản phẩm</div>
        <div class="content-tutorial">Sau khi chọn được sản phẩm ưng ý muốn mua, bạn tiến hành đặt hàng bằng cách:</div>
        <div class="content-tutorial">+ Chọn vào nút <strong>MUA NGAY</strong> nếu bạn muốn thanh toán luôn toàn bộ giá tiền sản phẩm hoặc nút <strong>THÊM VÀO GIỎ HÀNG</strong></div>
        <div class="content-tutorial">+ Hệ thống sẽ ghi nhận địa chỉ mà bạn đã đăng kí tài khoản trước đó</div>
        <div class="img-tutorial" style="background-image: url(../image/Tutorial/tutorial4.png)"></div>
        <div class="content-tutorial">Ngoài ra, nếu bạn đang sở hữu phiếu mua hàng, mã giảm giá... thì hãy nhập trong giỏ hàng đã đặt để được giảm giá</div>
        <div class="img-tutorial" style="background-image: url(../image/Tutorial/tutorial6.png)"></div>
        <div class="content-tutorial"><strong>Xin trân trọng cảm ơn!</strong></div>
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
<script src="../js/nav-responsive.js"></script>
<script src="../js/BackToTop.js"></script>
<script src="../js/Scroll-Indicator.js"></script>
<script src="../js/visibleCart.js"></script>
<script src="../js/clickAddCartTutorial.js"></script>
</html>