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
	
	public int retornaSetor(String recebeSetor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaSetor = 0;
		
		String sql = "SELECT id_setor FROM Setor WHERE nome_setor = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeSetor);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaSetor = rs.getInt("id_setor");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return retornaSetor;
	}
	
	public String retornaSetor(int recebeSetor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String retornaSetor = null;
		
		String sql = "SELECT nome_setor FROM Setor WHERE id_setor = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeSetor);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaSetor = rs.getString("nome_setor");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaSetor;
	}
	
	public void alteraSetor(String recebeSetor, int recebeIdSetor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "UPDATE Setor SET nome_setor = ? WHERE id_setor = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeSetor);
			stmt.setInt(2, recebeIdSetor);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
}
