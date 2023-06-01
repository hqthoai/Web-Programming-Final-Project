<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Maney Shop - For Admin</title>
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
    <button class="logout"><a href="<%=request.getContextPath()%>/logout">Log out</a><i class="fas fa-sign-out-alt"></i></button>
    

<div class="container">
    <div class="table-responsive">
        <div class="table-wrapper" style="width: auto">
            <div class="table-title">
                <div class="row">
                    <div class="col-xs-6">
                        <h2>Account <b>Management</b></h2>
                    </div>
                    <div class="col-xs-6">
                        <a id="addRow5" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add new account!</span></a>
                    </div>
                </div>
            </div>
            <table id="table6" class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>USERNAME</th>
                        <th>PASSWORD</th>
                        <th>ROLE</th>
                        <th>MANAGE</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${accounts}" var="account">
                        <tr>
                            <td>${account.id}</td>
                            <td>${account.username}</td>
                            <td>${account.password}</td>
                            <c:choose>
							  <c:when test="${account.role == 0}">
							    <td>Admin</td>
							  </c:when>
							  <c:when test="${account.role == 1}">
							    <td>Seller</td>
							  </c:when>
							  <c:when test="${account.role == 2}">
							    <td>Customer</td>
							  </c:when>
							  <c:otherwise>
							    <td>Unknown</td>
							  </c:otherwise>
							</c:choose>
							<td>
							<button class="btn btn-info btn-lg" data-target="#myModal" data-toggle="modal" type="button"><a href ="../admin-home?deleteId=${account.id}">Delete</a></button>
							</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="clearfix">
                <ul class="pagination">
                	<c:if test="${tag>1 }">
                		<li class="page-item "><a href="../admin-home?index=${tag-1}">Previous</a></li>
                	</c:if>
                    
                    <c:forEach begin="1" end="${endP}" var="a">
                        <li class="page-item ${tag == a ? 'active' : ''}">
				            <a href="../admin-home?index=${a}" class="page-link">${a}</a>
				        </li>
                    </c:forEach>
                    <c:if test="${tag < endP }">
                		<li class="page-item"><a href="../admin-home?index=${tag+1}" class="page-link">Next</a></li>
                	</c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
    
    

<div id="thongbao" style="z-index: 1000">
    <div class="register js-register-container">
        <form class="register-form">
            <div class="input-register">
                Are you sure?
            </div>
            <div class="register-div">
                <button type="button" id="yes" class="btn-register" >Yes</button>
                <button type="button" id="no" class="btn-register">No</button>
            </div>
        </form>
    </div>
</div>
<!--Back to top-->
<button id="myBtn">&#8593;</button>
</body>
<script>
  function confirmDelete(accountId) {
    if (confirm("Are you sure you want to delete this account?")) {
      window.location.href = `../admin-home?deleteId=${account.id}`;
    }
  }
</script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh" crossorigin="anonymous"></script>
<script src="../js/bstable.js"></script>

<script src="../js/BackToTop.js"></script>
<script src="../js/tabs.js"></script>
<!--<script src="../js/tabs-table.js"></script>-->
</html>