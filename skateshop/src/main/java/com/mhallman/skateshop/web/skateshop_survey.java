package com.mhallman.skateshop.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/survey")
public class skateshop_survey extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>"+
        
        "<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>"+
  		"<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script><body><h2>Survey</h2>" +
				"<form action='data'>" +
				"What do You ride: <br /> <div class='form-group'> <input type='radio' name='ride' id='skateboard' value='skateboard'>" +
				"<label for='skateboard'>SKATEBOARD</label>" +
				"<br /> <input type='radio' name='ride' id='MTB' value='MTB'>" +
				"<label for='MTB'>MTB</label>" +
				"<br /> <input type='radio' name='ride' id='BMX' value='BMX'>" +
				"<label for='BMX'>BMX</label> <br /> <br />" +
				"<label for='comment'>Comment:</label> </div> " +
				"<br/> <div class='form-group'>" +
				"<textarea name='area' class='form-control' rows='5' id='comment'></textarea>"+
				"</div>" +
				"<div class='form-group'>" +
			    "<div class='col-sm-offset-2 col-sm-10'>" +
			    "<button type='submit' class='btn btn-default'>Submit</button>" +
			    "</div>" +
				"</form>" +
				"</body>" +
				"</html>");
		out.close();
		
	}

}