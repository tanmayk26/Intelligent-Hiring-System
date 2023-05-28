package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.HRBean;
import com.java.dbhelper.HRDbhelper;

/**
 * Servlet implementation class AddHRServlet
 */
@WebServlet("/AddHRServlet")
public class AddHRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHRServlet() {
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
		// TODO Auto-generated method stub
		HRBean bean=new HRBean();
		
		bean.setHr_fname(request.getParameter("hr_fname"));
		bean.setHr_lname(request.getParameter("hr_lname"));
		bean.setHr_address(request.getParameter("hr_address"));
		bean.setHr_mobileno(request.getParameter("hr_mobileno"));
		bean.setHr_email(request.getParameter("hr_email"));
		bean.setHr_username(request.getParameter("hr_username"));
		bean.setHr_password(request.getParameter("hr_password"));
				

		HRDbhelper helper = new HRDbhelper();
		HRBean hrbean= helper.InsertHR(bean);
		
		if(hrbean!=null)
		{
			request.setAttribute("flag","success");
	        ServletContext ctx = this.getServletContext();
	        RequestDispatcher rd = ctx.getRequestDispatcher("/AddHR.jsp");
	        rd.forward(request, response);
			System.out.println("record inserted");
		}
		else
		{
			System.out.println("record not inserted");
			response.sendRedirect("error.jsp");

		}
	
	}

}
