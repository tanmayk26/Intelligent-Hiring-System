package com.java.servlet;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dbhelper.HRDbhelper;




/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(true);

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		HRDbhelper hRDbhelper =new HRDbhelper();
		Boolean result= hRDbhelper.validHR(username, password);

		if(username.equals("admin") && password.equals("admin"))
		{
			session.setAttribute("role", "ADMIN");
			response.sendRedirect("WelcomeAdmin.jsp");
		}	else if(result==true){
			session.setAttribute("role", "HR");
			response.sendRedirect("WelcomeHR.jsp");
		}
		
		else 
		{
			response.sendRedirect("login.jsp");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
