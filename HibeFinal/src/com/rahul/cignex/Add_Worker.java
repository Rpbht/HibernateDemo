package com.rahul.cignex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add_Worker
 */
@WebServlet("/Add_Worker")
public class Add_Worker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Worker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Singleton singleton = new Singleton();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		int id = (int) request.getSession().getAttribute("id");
		boolean isAdded = singleton.addWorker(id,name,address);
		
		if (isAdded) {
			int oid = (int) request.getSession().getAttribute("id");
			ArrayList<Worker> worker  =singleton.getWorker(oid);
			request.setAttribute("workers", worker);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("msg", "Something went wrong, please login again");
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
			
		}
		
		System.out.println(isAdded);
	}

}
