<%@page import="com.maneyshop.model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Quên mật khẩu</title>
	<style>
body {
  background-color: #f2f2f2;
}

h1 {
  font-size: 36px;
  text-align: center;
  margin-top: 50px;
  margin-bottom: 30px;
}

.forgot-form {
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  padding: 20px;
  margin: 0 auto;
  max-width: 500px;
  width: 100%;
}

.input-forgot {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}

.input-items {
  background-color: #f2f2f2;
  border: none;
  border-radius: 5px;
  box-sizing: border-box;
  color: #333;
  font-size: 16px;
  margin-bottom: 10px;
  padding: 10px;
  transition: box-shadow 0.3s ease;
}

.input-items:focus {
  outline: none;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}

.btn-forgot {
  background-color: #00bcd4;
  border: none;
  border-radius: 5px;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  font-size: 16px;
  padding: 10px;
  transition: background-color 0.3s ease;
}

.btn-forgot:hover {
  background-color: #007d8a;
}

.btn-forgot a {
  /* Add your styles here */
  /* For example: */
  color: #ffffff; /* Text color */
  text-decoration: none; /* Remove underline */
  margin-top: 10px;
  /* ... */
}
	</style>
</head>
<body>
	<h1>Forget Password</h1>
	<c:if test="${not empty FailedMessage}">
            <div class="alert alert-danger" style="color:red; text-align: center;">${FailedMessage}</div>
  	</c:if>
	<form action="../forget-password?action=checkemail" class="forgot-form" method="post">
		<div class="input-forgot">
			<p class="card-text py-2">
            Enter your email address and we'll send you an email with instructions to reset your password.
       		</p>
			<input class="input-items" name="email" placeholder="Email" required type="email">
		</div>
		<button class="btn-forgot">Send Email</button>
		
	</form>
	<div style="text-align: center;">
  <button class="btn-forgot"><a href="./index.jsp">Back</a></button>
</div>
</body>
</html>