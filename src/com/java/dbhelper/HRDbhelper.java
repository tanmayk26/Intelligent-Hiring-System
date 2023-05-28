package com.java.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.bean.EmployeeBean;
import com.java.bean.HRBean;



public class HRDbhelper {

	Connection connection = null;

	public boolean validHR(String username, String password) {

		System.out.println("validateHR");
		MyConnection dbcon = new MyConnection();
		Connection con = dbcon.connect();
		try {
			PreparedStatement	preparestatement = con.prepareStatement("select * from hr_table where hr_username=? and hr_password=?");
			preparestatement.setString(1, username);
			preparestatement.setString(2, password);

			ResultSet rs = preparestatement.executeQuery();
			rs.beforeFirst();
			return rs.next();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
	// INSERT USER
	public HRBean InsertHR(HRBean bean) {
		MyConnection dBConnection = new MyConnection();
		connection = dBConnection.connect();
		String query = "insert into hr_table(hr_fname, hr_lname, hr_address, hr_mobileno, hr_email,hr_username,hr_password) values('"
				+ bean.getHr_fname()
				+ "','"
				+ bean.getHr_lname()
				+ "','"
				+ bean.getHr_address()
				+ "','"
				+ bean.getHr_mobileno()
				+ "','"
				+ bean.getHr_email()
				+ "','"
				+ bean.getHr_username()
				+ "','"
				+ bean.getHr_password()
				+ "')";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			// find the max number from db....say id
			String squery = "SELECT *FROM resume.hr_table  where hr_id=(SELECT MAX(hr_id) FROM resume.hr_table);";
			ResultSet resultSet = statement.executeQuery(squery);
			resultSet.beforeFirst();
			while (resultSet.next()) {
				bean.setHr_fname(resultSet.getString("hr_fname"));
				bean.setHr_lname(resultSet.getString("hr_lname"));
				bean.setHr_address(resultSet.getString("hr_address"));
				bean.setHr_mobileno(resultSet.getString("hr_mobileno"));
				bean.setHr_email(resultSet.getString("hr_email"));
				bean.setHr_username(resultSet.getString("hr_username"));
				bean.setHr_password(resultSet.getString("hr_password"));
				return bean;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public  ArrayList<HRBean> viewHR() {

		System.out.println("View HR");
		MyConnection dbcon = new MyConnection();
		Connection con = dbcon.connect();
		ArrayList<HRBean> al =new ArrayList<HRBean>();
		try {
			PreparedStatement	preparestatement = con.prepareStatement("select * from hr_table ");
			ResultSet rs = preparestatement.executeQuery();
			
			if(rs!=null)
			{
				
				rs.beforeFirst();
				while(rs.next()){
					
					HRBean bean=new HRBean();
				
				bean.setHr_fname(rs.getString("hr_fname"));
				bean.setHr_lname(rs.getString("hr_lname"));
				bean.setHr_address(rs.getString("hr_address"));
				bean.setHr_mobileno(rs.getString("hr_mobileno"));
				bean.setHr_email(rs.getString("hr_email"));
				
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
