package com.rahul.cignex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register_Servlet
 */
@WebServlet("/Register_Servlet")
public class Register_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Singleton singleton = new Singleton();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		System.out.println(fname+" "+lname+" "+address+" "+email+" "+gender+" "+password+" "+cpassword );
		if (password.equals(cpassword)) {
			System.out.println("Password Matched");
		boolean isRegister = singleton.InsertDataParent(fname, lname, address, email, password);
		
		if (isRegister) {
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            rd.forward(request, response);
		}
		}else {
			 RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
	            rd.forward(request, response);
		}
		
		
		
	}

}
