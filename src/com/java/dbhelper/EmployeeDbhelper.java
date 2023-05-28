package com.java.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.bean.EmployeeBean;
import com.java.bean.HRBean;



public class EmployeeDbhelper {

	Connection connection = null;


	// INSERT USER
		public EmployeeBean InsertEmployee(EmployeeBean bean) {
			MyConnection dBConnection = new MyConnection();
			connection = dBConnection.connect();
			String query = "insert into employee_table(emp_fname, emp_lname, emp_address, emp_mobileno, emp_email) values('"
					+ bean.getEmp_fname()
					+ "','"
					+ bean.getEmp_lname()
					+ "','"
					+ bean.getEmp_address()
					+ "','"
					+ bean.getEmp_mobileno()
					+ "','"
					+ bean.getEmp_email()
					+ "')";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				// find the max number from db....say id
				String squery = "SELECT *FROM resume.employee_table  where emp_id=(SELECT MAX(emp_id) FROM resume.employee_table);";
				ResultSet resultSet = statement.executeQuery(squery);
				resultSet.beforeFirst();
				while (resultSet.next()) {
					bean.setEmp_id(resultSet.getInt("emp_id"));
					bean.setEmp_fname(resultSet.getString("emp_fname"));
					bean.setEmp_lname(resultSet.getString("emp_lname"));
					bean.setEmp_address(resultSet.getString("emp_address"));
					bean.setEmp_mobileno(resultSet.getString("emp_mobileno"));
					bean.setEmp_email(resultSet.getString("emp_email"));
					return bean;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		//VIEW USER	
		public  ArrayList<EmployeeBean> viewemployee() {

			System.out.println("View Employee");
			MyConnection dbcon = new MyConnection();
			Connection con = dbcon.connect();
			ArrayList<EmployeeBean> al =new ArrayList<EmployeeBean>();
			try {
				PreparedStatement	preparestatement = con.prepareStatement("select * from employee_table ");
				ResultSet rs = preparestatement.executeQuery();
				
				if(rs!=null)
				{
					
					rs.beforeFirst();
					while(rs.next()){
						
						EmployeeBean bean=new EmployeeBean();
					
					bean.setEmp_id(rs.getInt("emp_id"));
					bean.setEmp_fname(rs.getString("emp_fname"));
					bean.setEmp_lname(rs.getString("emp_lname"));
					bean.setEmp_address(rs.getString("emp_address"));
					bean.setEmp_mobileno(rs.getString("emp_mobileno"));
					bean.setEmp_email(rs.getString("emp_email"));
					
					al.add(bean);
					}
				}					
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Record size:"+al.size());
			return al;		
	}
}
