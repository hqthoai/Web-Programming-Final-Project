<%@page import="com.maneyshop.model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/tablib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Check out</title>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js"></script>
</head>
<body>
<div class="bg-gray-300">
    <div class="py-12">
        <div class="max-w-md mx-auto bg-white shadow-lg rounded-lg md:max-w-xl mx-2">
            <div class="md:flex ">	
                <form class="w-full p-4 px-5 py-5" action ="../createOrder" method = "post">
                
                    <div class="flex flex-row">
                        <h2 class="text-3xl font-semibold">Maney</h2>
                        <h2 class="text-3xl text-green-400 font-semibold">Shop</h2>
                    </div>
                    <div class="flex flex-row pt-2 text-xs pt-6 pb-5"> <span class="font-bold">Information</span> <small class="text-gray-400 ml-1">></small> <span class="text-gray-400 ml-1">Shopping</span> <small class="text-gray-400 ml-1">></small> <span class="text-gray-400 ml-1">Payment</span> </div> <span>Customer Information</span>
                    <div class="relative pb-5"> 
                    <input type="text" name="Email" class="border rounded h-10 w-full focus:outline-none focus:border-green-200 px-2 mt-2 text-sm" value='${sessionScope.account.email}' placeholder="E-mail"> <span class="absolute text-blue-500 right-2 top-4 font-medium text-sm">Log out</span> </div> <span>Shipping Address</span>
                    <div class="grid md:grid-cols-2 md:gap-2"> 
                    <input type="text" name="firstName" class="border rounded h-10 w-full focus:outline-none focus:border-green-200 px-2 mt-2 text-sm" placeholder="First name*">
                    <input type="text" name="lastName" class="border rounded h-10 w-full focus:outline-none focus:border-green-200 px-2 mt-2 text-sm"  placeholder="Last name*"> </div> 
                    <input type="text" name="address" class="border rounded h-10 w-full focus:outline-none focus:border-green-200 px-2 mt-2 text-sm" placeholder="Address*"> 
                    <input type="text" name="phoneNumber" class="border rounded h-10 w-full focus:outline-none focus:border-green-200 px-2 mt-2 text-sm" value='${sessionScope.account.phone}' placeholder="Phone Number*">
                    <div class="flex justify-between items-center pt-2"> <button type="button" class="h-12 w-24 text-blue-500 text-xs font-medium"><a href="./cart.jsp">Return to cart</a></button> <button type="submit" class="h-12 w-48 rounded font-medium text-xs bg-blue-500 text-white">Ordered</button> </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>