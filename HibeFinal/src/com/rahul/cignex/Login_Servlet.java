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
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email+" "+password);
		Singleton singleton = new Singleton();
		ArrayList<Owner> owner  =singleton.isValid(email, password);
		if (owner.size()>0) {
			ArrayList<Worker> worker  =singleton.getWorker(owner.get(0).getId());
				request.setAttribute("workers", worker);
				request.getSession().setAttribute("name", owner.get(0).getfName()+" "+owner.get(0).getlName());
				request.getSession().setAttribute("id", owner.get(0).getId());
			    RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
	            rd.forward(request, response);
		}else {
			request.setAttribute("msg", "Invalid user or password");
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
		}
	}

}
