
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Product Page</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/manager.css" rel="stylesheet" type="text/css" />
<style>
img {
	width: 200px;
	height: 120px;
}
.btn-back{
  background-color: green;
  color: #fff;
  font-size: 12px;
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.3s ease;
  float: left;
}

.btn-back:hover {
  background-color: #0062cc;
}



</style>
<body>
	<div class="container">

		<div id="editproduct">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="editProduct" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Edit Product</h4>
							
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>ID</label> <input value="${detail.productID}" name="pid"
									type="text" class="form-control" readonly required>
							</div>
							<div class="form-group">
								<label>Name</label> <input value="${detail.productName}"
									name="pName" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Brand</label> <input value="${detail.productBrand}"
									name="pBrand" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Description</label> <input value="${detail.productDes}"
									name="pDes" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Image</label> <input value="${detail.productImage}"
									name="pImage" type="text" class="form-control" required>
							</div>

							<div class="form-group">
								<label>Price</label> <input value="${detail.productCost}"
									name="price" type="text" class="form-control" required>
							</div>
							<div class="form-group">
								<label>Posted Date</label> <input value="${detail.postedData}"
									name="pDate" type="date" class="form-control" required>
							</div>

						</div>
						<div class="modal-footer">
							<a href="../seller-home"><button class="btn-back">Back </button></a>
							<input type="submit" class="btn btn-success" value="Edit">
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>


	<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>