package com.mhallman.skateshop.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class skateshop_surveyData extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>"+
        
        "<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>"+
  		"<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script><body><nav class='navbar navbar-default'>" +
		  "<div class='container-fluid'>" +
		    "<div class='navbar-header'>" +
		      "<p class='navbar-brand'><a href='index.jsp'>Skateshop Online</a></p>" +
		    "</div>" +
		    "<div>" +
		          "<ul class='nav navbar-nav'>" +
		            "<li><a href='product_addData.jsp'>Add product</a></li>" +
		            "<li><a href='product_deleteData.jsp'>Delete product</a></li>" +
		            "<li><a href='product_updateData.jsp'>Update product</a></li>" +
		            "<li><a href='product_getAll.jsp'>Show all products</a></li>" +
		            "<li><a href='survey'>Fill a survey</a></li>" +
		          "</ul>" +
		    "</div>" +
		  "</div>" +
		"</nav>" +
				"<p>What do You ride: " + request.getParameter("ride") + "<br />" +
				"<p>Opinion: " + request.getParameter("area") + "<br />" +
				"</body></html>");
		out.close();
		
	}

}