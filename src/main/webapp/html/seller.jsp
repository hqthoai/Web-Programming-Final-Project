
<%@page import="java.util.List"%>
<%@page import="com.maneyshop.model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Maney Shop - For Seller</title>
    <link rel="icon" href="../image/logo-re.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/admin.css" class="css">
    <link href="fonts/themify-icons/themify-icons.css" rel="stylesheet">
    <link href="fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          referrerpolicy="no-referrer" rel="stylesheet"/>

</head>
<body>
<div id="main">
    <h1 class="title"><strong>DASHBOARD</strong></h1>
    <button class="logout"><a href="<%=request.getContextPath()%>/logout">Log out</a> <i class="fas fa-sign-out-alt"></i></button>
    <div class="container">
        <div class="tab">
            <button class="tablinks active">DELL</button>
            <button class="tablinks">MSI</button>
            <button class="tablinks">ASUS</button>
        </div>
        <div id="dell" class="details-laptop">
            <a role="button" type="button" href="#table2">
                <div class="logo" style="background-image: url('../image/logo lap/dell.png')"></div>
            </a>
            <div class="details bg-blue">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng nhập</div>
            </div>
            <div class="details bg-green">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng xuất</div>
            </div>
            <div class="details bg-red">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng tồn kho</div>
            </div>
        </div>
        <div id="msi" class="details-laptop">
            <a role="button" type="button" >
                <div class="logo" style="background-image: url('../image/logo lap/msi.png')"></div>
            </a>
            <div class="details bg-blue">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng nhập</div>
            </div>
            <div class="details bg-green">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng xuất</div>
            </div>
            <div class="details bg-red">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng tồn kho</div>
            </div>
        </div>
        <div id="asus" class="details-laptop">
            <a role="button" type="button">
                <div class="logo" style="background-image: url('../image/logo lap/asus.png')"></div>
            </a>
            <div class="details bg-blue">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng nhập</div>
            </div>
            <div class="details bg-green">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng xuất</div>
            </div>
            <div class="details bg-red">
                <div class="details-number">52</div>
                <div class="details-title">Tổng số lượng tồn kho</div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Kho hàng</b></h2>
                        </div>
                        <div class="col-xs-6">
                            <a href="#addproduct"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
                        </div>
                    </div>
                </div>
                <table id="table3" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>CODE</th>
                            <th>NAME</th>
                            <th>BRAND</th>

                            <th>POSTED DATE</th>
                            <th>Price</th>
                            <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listP}" var="o">
                            <tr>
                                <td>${o.productID}</td>
                                <td>${o.productName}</td>
                                <td>${o.productBrand}</td>
                              
								<td>${o.postedData}</td>
                                <td>${o.getPriceCurrencyFormat()}</td>
                                <td>
                                    <a href="../editDetail?pid=${o.productID}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="../deleteProduct?pid=${o.productID}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                	<c:if test="${tag>1 }">
                		<li class="page-item "><a href="../seller-home?index=${tag-1}&index1=${tag1}">Previous</a></li>
                	</c:if>
                    
                    <c:forEach begin="1" end="${endP}" var="a">
                        <li class="page-item ${tag == a ? 'active' : ''}">
				            <a href="../seller-home?index=${a}&index1=${tag1}" class="page-link">${a}</a>
				        </li>
                    </c:forEach>
                    <c:if test="${tag < endP }">
                		<li class="page-item"><a href="../seller-home?index=${tag+1}&index1=${tag1}" class="page-link">Next</a></li>
                	</c:if>
                </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Đơn hàng</b></h2>
                        </div>
                        <div class="col-xs-6">
                           <!--  <a id="addRow3" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm hàng</span></a> --> 
                        </div>
                    </div>
                </div>
                <table id="table4" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>CUSTOMER'S NAME</th>
                        <th>PHONE</th>
                        
                        <th>ADDRESS</th>
                        <th>ORDER DATE</th>
                        <th>TOTAL AMOUNT</th>
                        <th>STATUS</th>
                        <th>ACTION</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                       <c:forEach items="${listO}" var="od">
                            <tr>
                           
                                <td>${od.id}</td>
                                <td>${od.customer.firstName} ${od.customer.lastName} </td>
                                <td>${od.customer.phone}</td>
                              
                              	<td>${od.shippingInfo.shipppingAddress} </td>
                              	<td>${od.orderDate}</td>
								<td>${od.totalAmount}</td>
                                <td>${od.deliveryStatus}</td>
                                <td>
                               <c:if test="${not od.deliveryStatus.equalsIgnoreCase('shipped!')}">
                <a href="../change-status?oid=${od.id}">
                    <button style="border-radius: 12px;background-color: #e7e7e7;text-align: center;padding: 10px 24px;">Completed</button>
                </a>
            </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tr>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                	<c:if test="${tag1>1 }">
                		<li class="page-item "><a href="../seller-home?index1=${tag1-1}&index=${tag}">Previous</a></li>
                	</c:if>
                    
                    <c:forEach begin="1" end="${endO}" var="b">
                        <li class="page-item ${tag1 == b ? 'active' : ''}">
				            <a href="../seller-home?index1=${b}&index=${tag}" class="page-link">${b}</a>
				        </li>
                    </c:forEach>
                    <c:if test="${tag1 < endO }">
                		<li class="page-item"><a href="../seller-home?index1=${tag1+1}&index=${tag}" class="page-link">Next</a></li>
                	</c:if>
                </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive">
            <div class="table-wrapper" style="width: auto">
                <div class="table-title">
                    <div class="row">
                        <div class="col-xs-6">
                            <h2>Quản lý <b>Chi tiết giỏ hàng</b></h2>
                        </div>
                        <div class="col-xs-6">
                           
                        </div>
                    </div>
                </div>
                <table id="table5" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>MÃ GIỎ HÀNG</th>
                        <th>MÃ LAPTOP</th>
                        <th>SỐ LƯỢNG</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>V4R53500U001W</td>
                        <td>Laptop Dell Vostro 14 3405</td>
                        <td>2</td>
                    </tr>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    
    
    
    
</div>
<div id="thongbao" style="z-index: 1000">
    <div class="register js-register-container">
        <form action="../register" class="register-form">
            <div class="input-register">
                Bạn chắc chứ?
            </div>
            <div class="register-div">
                <button type="button" id="yes" class="btn-register" >Có</button>
                <button type="button" id="no" class="btn-register">Không</button>
            </div>
        </form>
    </div>
</div>

	<!-- Add Modal HTML -->
		<div id="addproduct" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="../addProduct" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Product Code</label>
                                <input name="pCode" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input name="pName" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Brand</label>
                                <input name="pBrand" type="text" class="form-control" required>
                           
                            </div>
                                <div class="form-group">
                                <label>Description</label>
                                <input name="pDes" type="text" class="form-control" required>
                            </div>
                                <div class="form-group">
                                <label>Image</label>
                                <input name="pImage" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Posted Date</label>
                                <input name="pDate" type ="date" class="form-control" required></input>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
<!--Back to top-->
<button id="myBtn">&#8593;</button>


</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh" crossorigin="anonymous"></script>
<script src="../js/bstable.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/BackToTop.js"></script>
<script src="../js/tabs.js"></script>
<!--<script src="../js/tabs-table.js"></script>-->
</html>