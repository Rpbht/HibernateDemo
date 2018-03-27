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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Singleton singleton = new Singleton();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		
		if (password.equals(cpassword)) {
			System.out.println("Password Matched");
			int oid = (int) request.getSession().getAttribute("id");
			boolean b = singleton.isUpdated(oid,fname,lname,address,email,password);
			
			ArrayList<Owner> owner =singleton.getOwner(oid);
			request.getSession().setAttribute("name", owner.get(0).getfName()+" "+owner.get(0).getlName());
		    
			
			
			ArrayList<Worker> worker  =singleton.getWorker(oid);
			request.setAttribute("workers", worker);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}else {
			int oid = (int) request.getSession().getAttribute("id");
			ArrayList<Worker> worker  =singleton.getWorker(oid);
			request.setAttribute("workers", worker);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		

}
}
