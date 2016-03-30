package pim4sem.aev.business.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	
	private static final String user = null; // User to connect on database
	private static final String password = null; // Password to connect on database

	public Connection getConnection(){
		
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pimaev", user, password);
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
}