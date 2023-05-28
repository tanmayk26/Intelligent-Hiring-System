package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.EmployeeBean;
import com.java.bean.EmployeeProfileBean;
import com.java.dbhelper.EmployeeDbhelper;
import com.java.dbhelper.EmployeeProfileDbhelper;

/**
 * Servlet implementation class EmployeeProfileServlet
 */
@WebServlet("/EmployeeProfileServlet")
public class EmployeeProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeProfileServlet() {
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
		EmployeeProfileBean bean = new EmployeeProfileBean();
		
		bean.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
		bean.setRating(Integer.parseInt(request.getParameter("rating")));
		bean.setGender(request.getParameter("gender"));
		bean.setUniversity(request.getParameter("university"));
		bean.setQualification(request.getParameter("qualification"));
		bean.setTechnology(request.getParameter("technology"));
		bean.setTotal_experience(request.getParameter("total_experience"));
		

		EmployeeProfileDbhelper helper = new EmployeeProfileDbhelper();
		EmployeeProfileBean employeeprofilebean= helper.InsertEmployeeProfile(bean);
		
		if(employeeprofilebean!=null)
		{
			request.setAttribute("flag","success");
			request.setAttribute("emp_id","emp_id");
			ServletContext ctx = this.getServletContext();
	        RequestDispatcher rd = ctx.getRequestDispatcher("/AddEmployeeProfile.jsp");
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
