package com.scorer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;
import com.scorer.connection.factory.MySqlConnection;
import com.scorer.service.iface.UserServiceIface;
import com.scorer.web.form.UserLoginForm;
import com.scorer.web.vo.UserPageVO;

public class UserServiceImpl extends MySqlConnection implements UserServiceIface {
	
	/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String current_timestamp = dateFormat.format(System.currentTimeMillis());
*/
	public UserPageVO getUserPage(UserLoginForm form ) {
		
		Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		UserPageVO userPage = null;
		
			try{
				conn = getConnection();
				String sql = "SELECT * FROM userlogin where user_name = ? or user_pass = ?";
				System.out.println("Query  --> "+sql);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, form.getUserName());
				pstmt.setString(2, form.getUserPass());
		          rs = pstmt.executeQuery();
		          System.out.println("resultSet"+rs);
		       
		         while(rs.next()){
		        	 userPage = new UserPageVO();
		        	 userPage.setUserId(rs.getInt("user_id"));
		        	 userPage.setUserName(rs.getString("user_name"));
		        	 userPage.setUserPass(rs.getString("user_pass"));
		          }
			}catch(Exception e){
				System.out.println("Exception in user page "+e);
			}finally{
				closeResources(conn, stmt, rs);
			}
				
		return userPage;
	
		
	}

	public boolean save(UserLoginForm form) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs;
		try{  
			conn = getConnection();
			String sql = "INSERT INTO userlogin( user_name, user_pass,last_Updated) VALUES(?,?,current_timestamp)";
		  System.out.println("Query is = "+sql);
		ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	    
		ps.setString(1,form.getUserName());  
		ps.setString(2,form.getUserPass());  
		
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

	public boolean updatePass(UserLoginForm form) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{  
			conn = getConnection();
			ps=conn.prepareStatement("update userlogin set user_pass=? where user_id=?");
			
   		    ps.setString(1, form.getUserPass());
			ps.setInt(2,form.getUserId());  
   		    
			
		ps.executeUpdate(); 
			
		}catch(Exception e)
		{
			System.out.println("Exception in change user pass");
		}
		
			
		return true;
	}





}
