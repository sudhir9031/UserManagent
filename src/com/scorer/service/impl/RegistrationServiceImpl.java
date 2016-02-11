package com.scorer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.scorer.connection.factory.MySqlConnection;
import com.scorer.service.iface.RegistrationServiceIface;
import com.scorer.web.form.UserRegistrationForm;
import com.scorer.web.vo.RegistrationPageVO;

public class RegistrationServiceImpl extends MySqlConnection implements RegistrationServiceIface{
	

	public boolean registerSave(UserRegistrationForm form) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs;
		
		try{  
			conn = getConnection();
			String sql = "INSERT INTO userdetails(first_name, middle_name, last_name, age, dob, address,last_update) VALUES(?,?,?,?,?,?,current_timestamp)";
		   System.out.println("Query is = "+sql);
		   ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		   
		   ps.setString(1,form.getFirstName());  
		   ps.setString(2,form.getMiddleName());  
		   ps.setString(3,form.getLastName());  
		   ps.setInt(4,form.getAge());  
		   ps.setString(5,form.getDob());  
		   ps.setString(6,form.getAddress());    
		  
		
		   ps.executeUpdate();  
		   
		   rs=ps.getGeneratedKeys();  
			 if(rs != null && rs.next()){
	             System.out.println("Generated Emp Id: "+rs.getInt(1));
	         }
		   
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return true;  
		
	}


	public RegistrationPageVO getUserDetail(RegistrationPageVO vo) {

      RegistrationPageVO registerPageVO=null;
      
      Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
      try {
    	  conn = getConnection();
			String sql = "SELECT * FROM userdetails ";
			System.out.println("Query  --> "+sql);
			
	         stmt = conn.createStatement();
	          rs = stmt.executeQuery(sql);
	          System.out.println("resultSet"+rs);
	         
	         while(rs.next()){
	        	 registerPageVO = new RegistrationPageVO();		        	
	        	 registerPageVO.setFirstName(rs.getString("first_name"));
	        	 registerPageVO.setMiddleName(rs.getString("middle_name"));
	        	 registerPageVO.setLastName(rs.getString("last_name"));
	        	 registerPageVO.setAge(rs.getInt("age"));
	        	 registerPageVO.setDob(rs.getString("dob"));
	        	 registerPageVO.setAddress(rs.getString("address"));	
	          }
		}catch(Exception e){
			System.out.println("Exception in Registration page "+e);
		}finally{
			closeResources(conn, stmt, rs);
		}
		return registerPageVO;
	}

	public List<RegistrationPageVO> getUserDeatilList() {
		
		
		 List<RegistrationPageVO> userRegistartionList=null;
		 
		 RegistrationPageVO userList=null;		   
	     Connection conn = null;
	     java.sql.Statement stmt = null;
	     ResultSet rs = null;
		 
		 try
		 {
		   conn=getConnection();
		   String sql = "SELECT * FROM userdetails ";
		   System.out.println("Query  --> "+sql);
	       stmt = conn.createStatement();
	       rs = stmt.executeQuery(sql);
	       System.out.println("resultSet"+rs);
	       userRegistartionList=new ArrayList<RegistrationPageVO>();
	       
	       while(rs.next())
	       {
	    	   userList=new RegistrationPageVO();
	    	   userList.setUserId(rs.getString("user_id"));
	    	   userList.setFirstName(rs.getString("first_name"));
	    	   userList.setMiddleName(rs.getString("middle_name"));
	    	   userList.setLastName(rs.getString("last_name"));
	    	   userList.setAge(rs.getInt("age"));
	    	   userList.setDob(rs.getString("dob"));
	    	   userList.setAddress(rs.getString("address"));
	    	   
	    	   userRegistartionList.add(userList);
	    	   System.out.println("User registration Details list");
	    	   
	    	   
	       }			 
			
			 
		 }catch(Exception e)
		 {
			 System.out.println("Exception in userlist dao implimentation"+e);
		 }	
		
		
		return userRegistartionList;
	}
	
	public boolean updateUserDetails(UserRegistrationForm form) {
		
		Connection conn=null;
		PreparedStatement ps=null;
		
		try
		{
			conn=getConnection();
			ps=conn.prepareStatement("UPDATE userdetails  SET  first_name=?, middle_name=?, last_name=?, age=?, dob=?, address=?  WHERE user_id=?");
			
			ps.setString(1,form.getFirstName());
			ps.setString(2,form.getMiddleName());
			ps.setString(3,form.getLastName());
			ps.setInt(4,form.getAge());
			ps.setString(5,form.getDob());
			ps.setString(6,form.getAddress());
			ps.setInt(7,form.getUserId());
			
			ps.executeUpdate(); 
			
		}catch(Exception e)
		{
			System.out.println("Eception in update user detais"+e);
		}	
		
		
		return true;
	}


	
	}
	


