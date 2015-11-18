package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class StatusUsuario {
	public int retornaStatus(String recebeStatus) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaStatus = 0;
		
		if(recebeStatus == null){
			throw new IllegalArgumentException("O Status não pode ser vazio!");
		}
		
		String sql = "SELECT id_status FROM StatusUsuario WHERE usu_status = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeStatus);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaStatus = rs.getInt("id_status");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaStatus;
	}
	
	public String retornaStatus(int recebeStatus) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String retornaStatus = null;
		if(recebeStatus == 0){
			throw new IllegalArgumentException("O Status não pode ser vazio!");
		}
		
		String sql = "SELECT usu_status FROM StatusUsuario WHERE id_status = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeStatus);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaStatus = rs.getString("usu_status");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaStatus;
	}
}
