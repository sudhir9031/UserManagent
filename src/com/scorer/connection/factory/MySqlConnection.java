package com.scorer.connection.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlConnection {
	 protected static Connection conn=null;
     public static Connection getConnection() throws Exception{
 	        String driver="com.mysql.jdbc.Driver";
	        String driver_url="jdbc:mysql://localhost/usermanagement";
	        String user="root";
	        String pwd="root";
	       

	        try{
	        Class.forName(driver);
	        conn=DriverManager.getConnection(driver_url, user, pwd);

	     
	        System.out.println("New Connection created.."+conn);
	        System.out.println("Connection via mysql"+driver_url);
	        }catch(Exception e){
	            System.out.println("Exception while getting local mysql Connection : "+e.getMessage());
	        }

	        return conn;
	    }
	    
	    
		/**
		 * This method use to close JDBC resources.
		 * 
		 * @param Connection
		 * @param Statement
		 * @param ResultSet
		 */
		public void closeResources(Connection conn, Statement stmt, ResultSet res) {
			try {
				if (res != null) {
					res.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					//conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		public void closeResources(Connection conn) {
			try {

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	    
	    
	}


