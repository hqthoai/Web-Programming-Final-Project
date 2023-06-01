<%@page import="com.maneyshop.model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Register Form</title>
    <style>
      * {
        box-sizing: border-box;
      }

      body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
      }

      .container {
        max-width: 500px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.3);
      }

      h1 {
        text-align: center;
        margin-top: 0px;
      }

      form {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        margin-top: 20px;
      }

      label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
      }

      input,
      select {
        width: 100%;
        padding: 12px;
        margin-bottom: 20px;
        border: none;
        border-bottom: 2px solid #ccc;
        background-color: #f2f2f2;
        font-size: 16px;
        font-weight: 300;
        color: #333;
      }

      input:focus,
      select:focus {
        outline: none;
        border-bottom-color: #4CAF50;
      }

      button {
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        padding: 14px 20px;
        margin-top: 20px;
        width: 100%;
        font-size: 16px;
        font-weight: 400;
        transition: background-color 0.3s ease;
      }

      button:hover {
        background-color: #45a049;
      }
      a {
	    color: #fff; /* Link color */
	    text-decoration: none; /* Remove underline */
	    transition: color 0.3s ease; /* Transition effect for color change */
	  }

    </style>
  </head>
  <body>
    <div class="container">
		<h1>Register Form</h1>
		<c:if test="${not empty errorMessage}">
                <div class="alert alert-danger" style="color:red;">${errorMessage}</div>
  			</c:if>
		<form action="/FinalProject/register" class="register-form" method="post">
			
			<label for="firstname">First name:</label>
			<input type="text" id="firstname" name="firstname" value="${account.firstName}" required>

			<label for="lastname">Last name:</label> 
			<input type="text" id="lastname" name="lastname" value="${account.lastName}" required>

			<label for="username">Username:</label>
			<input type="text" id="username" name="username" value="${account.username}" required>

			<label for="password">Password:</label>
			<input type="password" id="password" name="password" value="${account.password}" required>

			<label for="address">Address:</label>
			<input type="text" id="address" name="address" value="${account.address}" required>

			<label for="role">Role:</label>
			<select id="role" name="role" required>
<option value="">Select a role</option>
				<option value="customer">Customer</option>
				<option value="seller">Seller</option>
			</select>
			<label for="email" class="form-label">Email:</label>
	        <input type="email" class="form-control" id="email" name="email" value="${account.email}" required />
	        
	        <label for="phone" class="form-label">Phone:</label>
          <input type="tel" class="form-control" id="phone" name="phone" value="${account.phone}" required />
          <button type="submit" class="btn btn-primary">Register</button>
          
      </form>
      <button type="submit" class="btn btn-primary"><a href="./index.jsp">Back to home page!</a></button>
    </div>
	</body>     
</html>