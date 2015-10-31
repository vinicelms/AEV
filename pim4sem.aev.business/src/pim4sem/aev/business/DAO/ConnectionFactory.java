package pim4sem.aev.business.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	public Connection getConnection(){
		
		try{
			return (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pimaev", "dbinterator", "dbit@aevpim");
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
		finally {
			// Sem necessidade de código
		}
		
	}
	
}
