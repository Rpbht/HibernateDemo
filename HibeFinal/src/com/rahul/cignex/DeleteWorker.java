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
 * Servlet implementation class DeleteWorker
 */
@WebServlet("/DeleteWorker")
public class DeleteWorker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWorker() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Singleton singleton = new Singleton();
		int oid = (int) request.getSession().getAttribute("id");
		boolean isDeketed = singleton.deleteWorker(oid,id);
		System.out.println(isDeketed);
		int ooid = (int) request.getSession().getAttribute("id");
		ArrayList<Worker> worker  =singleton.getWorker(ooid);
		request.setAttribute("workers", worker);
		RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}

}
