package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightLocal_ejb10;
import com.airline.service.FlightServiceStatelessBean;

/**
 * Servlet implementation class FlightDetails
 */
@WebServlet("/FlightDetails")
public class FlightDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private FlightLocal_ejb10 fs;
	
	private FlightLocal_ejb10 fsStateful;
	

	
	
	

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
		
		try {
			
			Context context = new InitialContext();
			
			Object fsObject = context.lookup("java:global/ejb10/flightStateless!com.airline.service.FlightLocal_ejb10");
			this.fs = (FlightLocal_ejb10) fsObject;
			
			Object fsStatefulObject = context.lookup("java:global/ejb10/flightStateful!com.airline.service.FlightLocal_ejb10");
			this.fsStateful = (FlightLocal_ejb10) fsStatefulObject;
			
			
		}
		catch(NamingException e) {
			
			System.out.println("Naming exception has occured in the lookup of our FlightService EJBs");
			e.printStackTrace();
			
		}
		
		//Stateless
		
		out.println("Flight Details: " + fs.getFrom() + " to " + fs.getTo() + " costing " + fs.getPrice());
		

		//Stateful
		out.println("Flight Details: " + fsStateful.getFrom() + " to " + fsStateful.getTo() + " costing " + fsStateful.getPrice());
		


		


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
