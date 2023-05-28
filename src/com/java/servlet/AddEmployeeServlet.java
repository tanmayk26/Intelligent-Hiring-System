package com.java.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.EmployeeBean;
import com.java.bean.HRBean;
import com.java.dbhelper.EmployeeDbhelper;
import com.java.dbhelper.HRDbhelper;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
		
		EmployeeBean bean = new EmployeeBean();
		
		bean.setEmp_fname(request.getParameter("emp_fname"));
		bean.setEmp_lname(request.getParameter("emp_lname"));
		bean.setEmp_address(request.getParameter("emp_address"));
		bean.setEmp_mobileno(request.getParameter("emp_mobileno"));
		bean.setEmp_email(request.getParameter("emp_email"));
		

		EmployeeDbhelper helper = new EmployeeDbhelper();
		EmployeeBean employeebean= helper.InsertEmployee(bean);
		
		if(employeebean!=null)
		{
			request.setAttribute("flag","success");
	        ServletContext ctx = this.getServletContext();
	        RequestDispatcher rd = ctx.getRequestDispatcher("/AddEmployee.jsp");
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
 