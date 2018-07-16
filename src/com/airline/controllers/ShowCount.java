package com.airline.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.CounterBean;
import com.airline.service.CounterStatefulBean;

/**
 * Servlet implementation class ShowCount
 */
@WebServlet("/ShowCount")
public class ShowCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	CounterBean cb;
	
	@EJB
	CounterStatefulBean cbStateful;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		out.println("The count value is for the Singleton Bean is : " + cb.getCount());
		
		out.println("The counter value for the Stateful Bean is : " + cbStateful.getCount());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
