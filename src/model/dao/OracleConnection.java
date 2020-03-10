package model.dao;

import java.sql.*;

public class OracleConnection {
	private String server;
	private String user;
	private String pass;
	private String port;
	private String SID;
	private String url;
	public Connection conn;

	public OracleConnection() {
		server="localhost";
		user="system";
		pass="1234";
		port="1521";
		SID="xe";
		url="jdbc:oracle:thin:@"+server+":"+port+":"+SID;
	}
	
	public boolean openConection() {
		boolean retorno=false;
				
		try {
			conn = DriverManager.getConnection(url,user,pass);
			
			if (conn!=null) {
				retorno=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			conn=null;
		}
	}

}
