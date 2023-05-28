package com.java.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.bean.EmployeeProfileBean;



public class EmployeeProfileDbhelper {

	Connection connection = null;


	// INSERT USER
		public EmployeeProfileBean InsertEmployeeProfile(EmployeeProfileBean bean) {
			MyConnection dBConnection = new MyConnection();
			connection = dBConnection.connect();
			String query = "insert into employee_profile_table(emp_id, rating,gender, university,qualification,technology,total_experience) values('"
					+ bean.getEmp_id()
					+ "','"
					+ bean.getRating()
					+ "','"
					+ bean.getGender()
					+ "','"
					+ bean.getUniversity()
					+ "','"
					+ bean.getQualification()
					+ "','"
					+ bean.getTechnology()
					+ "','"
					+ bean.getTotal_experience()
					+ "')";
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				// find the max number from db....say id
				String squery = "SELECT *FROM resume.employee_profile_table  where profile_id=(SELECT MAX(profile_id) FROM resume.employee_profile_table);";
				ResultSet resultSet = statement.executeQuery(squery);
				resultSet.beforeFirst();
				while (resultSet.next()) {
					bean.setProfile_id(resultSet.getInt("profile_id"));
					bean.setEmp_id(resultSet.getInt("emp_id"));
					bean.setRating(resultSet.getInt("rating"));
					bean.setGender(resultSet.getString("gender"));
					bean.setUniversity(resultSet.getString("university"));
					bean.setQualification(resultSet.getString("qualification"));
					bean.setTechnology(resultSet.getString("technology"));
					bean.setTotal_experience(resultSet.getString("total_experience"));
					return bean;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		//VIEW 
		public  ArrayList<EmployeeProfileBean> ViewEmployeeProfile() {

			System.out.println("View Employee Profile");
			MyConnection dbcon = new MyConnection();
			Connection con = dbcon.connect();
			ArrayList<EmployeeProfileBean> al =new ArrayList<EmployeeProfileBean>();
			try {
				PreparedStatement	preparestatement = con.prepareStatement("select * from employee_profile_table ");
				ResultSet rs = preparestatement.executeQuery();
				
				if(rs!=null)
				{
					
					rs.beforeFirst();
					while(rs.next()){
						
						EmployeeProfileBean bean=new EmployeeProfileBean();
					
					bean.setProfile_id(rs.getInt("profile_id"));
					bean.setEmp_id(rs.getInt("emp_id"));
					bean.setRating(rs.getInt("rating"));
					bean.setGender(rs.getString("gender"));
					bean.setUniversity(rs.getString("university"));
					bean.setQualification(rs.getString("qualification"));
					bean.setTechnology(rs.getString("technology"));
					bean.setTotal_experience(rs.getString("total_experience"));
					
					al.add(bean);
					}
				}					
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Record Size:"+al.size());
			return al;		
	}
}
