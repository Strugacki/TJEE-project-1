<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page import="com.mhallman.skateshop.domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

		<jsp:useBean id="productManager" class="com.mhallman.skateshop.service.ProductManager" scope="application" />
		<jsp:useBean id="Product" class="com.mhallman.skateshop.domain.Product" scope="session" />
		<c:forEach var="product" items="${productManager.allProducts}">
		<div class="well well-sm">
		<form class="form-inline" action="product_delete.jsp">
		<p>Product ID: <c:out value="${product.id_product}"></c:out></p>
		
		<p>Product name: <c:out value="${product.product_name}"></c:out></p>
		
		<p>Brand name: <c:out value="${product.brand_name}"></c:out></p>
		 
		<p>Price : <c:out value="${product.price}"></c:out></p>
		
		<input type="hidden" class="form-control" name="id_product" value="<c:out value="${product.id_product}"></c:out>">
		<input type="submit" class="btn btn-danger" value="Delete" />
		</form>
		</div>
		</c:forEach> 
		 
	
</body>
</html>