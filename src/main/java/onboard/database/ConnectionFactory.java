package onboard.database;

import java.sql.Connection;
import java.sql.DriverManager;

public  class ConnectionFactory {
	

	private ConnectionFactory(){
	}

	public static  Connection getDbConnection() {
		Connection con = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");  
				return DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/RECYCLER","root","MyNewPass");  
				
			}
			catch(Exception ex){
				ex.printStackTrace();
				return con;
			}
	}
}
