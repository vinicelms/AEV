package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GerenteDAO {
	
	SetorDAO setor = new SetorDAO();

	public void registraGerente(String recebeGerente, String recebeSetor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO Gerente (nome, id_setor) VALUES (?, ?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			
			stmt.setString(1, recebeGerente);
			stmt.setInt(2, setor.retornaIdSetor(recebeSetor));
			
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public int retornaIdGerente(String recebeGerente) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaId = 0;
		
		String sql = "SELECT id_gerente FROM Gerente WHERE nome = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeGerente);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				retornaId = rs.getInt("id_gerente");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
}
