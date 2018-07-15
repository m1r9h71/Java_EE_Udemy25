package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightService;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private FlightService fs;

	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		out.println("The flights details servlet has been called.....");
		//This tutorial is showing the issues with a stateless EJB
		
		fs.setFrom("London"); //This could refer to the 5th FlightService Bean object from the pool
		
		fs.setPrice(500);//This could refer to the 1st FlightService Bean object from the pool
		
		fs.setTo("Rome"); //This could refer to the 4th FlightService Bean object from the pool
		
		//Using stateless and the same reference (fs in this case) means the result is completely random
		
		
		out.println(fs.getFrom()); //This will work but we don't know which Bean we are referring to
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
