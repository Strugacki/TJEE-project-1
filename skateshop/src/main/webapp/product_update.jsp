<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='../webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Skateshop Online</title>
</head>
<body>

		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <p class="navbar-brand"><a href="index.jsp">Skateshop Online</a></p>
		    </div>
		    <div>
		          <ul class="nav navbar-nav">
		            <li><a href="product_addData.jsp">Add product</a></li>
		            <li><a href="product_deleteData.jsp">Delete product</a></li>
		            <li><a href="product_updateData.jsp">Update product</a></li>
		            <li><a href="product_getAll.jsp">Show all products</a></li>
		          </ul>
		    </div>
		  </div>
		</nav>

		<jsp:useBean id="Product" class="com.mhallman.skateshop.domain.Product" scope="session" />
		
		<jsp:setProperty name="Product" property="*" /> 
		
		<jsp:useBean id="ProductManager" class="com.mhallman.skateshop.service.ProductManager" scope="application" />
		
		<% 
			ProductManager.updateProduct(Product);
		%>
		
		<h2>Following product has been updated: </h2>
		<div class="well">
			<p>Product name: <jsp:getProperty name="Product" property="product_name"></jsp:getProperty></p><br/>
			<p>Brand name: <jsp:getProperty name="Product" property="brand_name"></jsp:getProperty></p><br/>
			<p>Price: <jsp:getProperty name="Product" property="price"></jsp:getProperty> pln</p>
			<a href="product_updateData.jsp" class="btn btn-primary" value="Update another"></a>
		</div>

</body>
</html>