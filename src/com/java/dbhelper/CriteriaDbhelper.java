package com.java.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.bean.CriteriaBean;
import com.java.bean.EmployeeBean;
import com.java.bean.HRBean;



public class CriteriaDbhelper {

	Connection connection = null;


	// INSERT USER
		public CriteriaBean InsertCriteria(CriteriaBean bean) {
			MyConnection dBConnection = new MyConnection();
			connection = dBConnection.connect();
			String query = "insert into criteria_table(total_year_of_exp, technology,qualification) values('"
					+ bean.getTotal_year_of_exp()
					+ "','"
					+ bean.getTechnology()
					+ "','"
					+ bean.getQualification()
					+ "')";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				// find the max number from db....say id
				String squery = "SELECT *FROM resume.criteria_table  where criteria_id=(SELECT MAX(criteria_id) FROM resume.criteria_table);";
				ResultSet resultSet = statement.executeQuery(squery);
				resultSet.beforeFirst();
				while (resultSet.next()) {
					bean.setCriteria_id(resultSet.getInt("criteria_id"));
					bean.setTotal_year_of_exp(resultSet.getString("total_year_of_exp"));
					bean.setTechnology(resultSet.getString("technology"));
					bean.setQualification(resultSet.getString("qualification"));
					
					return bean;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		//VIEW USER	
		/*public  ArrayList<EmployeeBean> viewemployee() {

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
*/}
