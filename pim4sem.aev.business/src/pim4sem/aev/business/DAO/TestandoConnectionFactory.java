package pim4sem.aev.business.DAO;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TestandoConnectionFactory {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = new ConnectionFactory().getConnection();
		
		System.out.println("Conexão aberta!");
		
		conn.close();

	}

}
