package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetorDAO {

	public void registraSetor(String recebeSetor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO Setor (nome_setor) VALUES (?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			
			stmt.setString(1, recebeSetor);
			
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public int retornaIdSetor(String recebeSetor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaId = 0;
		
		String sql = "SELECT id_setor FROM Setor WHERE nome_setor = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			
			stmt.setString(1, recebeSetor);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				retornaId = rs.getInt("id_setor");
			}
			rs.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return retornaId;
				
	}
	
}
