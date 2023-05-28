package com.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.CriteriaBean;
import com.java.bean.EmployeeBean;
import com.java.dbhelper.CriteriaDbhelper;
import com.java.dbhelper.EmployeeDbhelper;

/**
 * Servlet implementation class CriteriaServlet
 */
@WebServlet("/CriteriaServlet")
public class CriteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriteriaServlet() {
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
		CriteriaBean bean = new CriteriaBean();
		
		bean.setTotal_year_of_exp(request.getParameter("total_year_of_exp"));
		bean.setTechnology(request.getParameter("technology"));
		bean.setQualification(request.getParameter("qualification"));

		CriteriaDbhelper helper = new CriteriaDbhelper();
		CriteriaBean Bean= helper.InsertCriteria(bean);
		
		if(Bean!=null)
		{
			request.setAttribute("flag","success");
	        ServletContext ctx = this.getServletContext();
	        RequestDispatcher rd = ctx.getRequestDispatcher("/uploadResume.jsp");
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
