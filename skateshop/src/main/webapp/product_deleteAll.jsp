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
		            <li><a href="product_getAll.jsp">Show all products</a></li>
		          </ul>
		    </div>
		  </div>
		</nav>

		<jsp:useBean id="Product" class="com.mhallman.skateshop.domain.Product" scope="session" />
		<jsp:setProperty name="Product" property="*" /> 
		<jsp:useBean id="ProductManager" class="com.mhallman.skateshop.service.ProductManager" scope="application" />
		<% 
			boolean empty=ProductManager.getAllProducts().isEmpty();
		    
		    if(empty==true){
		    	out.println("<p>Database is empty. Go to main page!</p>");
		    }else{
					ProductManager.deleteAllProducts();
					out.println("<div class=\"modal fade\">");
					out.println("<div class=\"modal-dialog\">");
					out.println("<div class=\"modal-content\">");
					out.println("<div class=\"modal-header\">");
					out.println("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>");
					out.println("<h4 class=\"modal-title\">Message for Skateshop user</h4>");
					out.println("</div>");
					out.println("<div class=\"modal-body\">");
					out.println("<p>All products have been deleted</p>");
					out.println("</div>");
					out.println("<div class=\"modal-footer\">");
					out.println("<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");
		    }
		%>
		<a href="index.jsp" class="btn btn-danger">Go to main page</a>
	</body>
</html>