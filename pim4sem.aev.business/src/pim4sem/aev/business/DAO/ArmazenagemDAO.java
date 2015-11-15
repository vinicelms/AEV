package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pim4sem.aev.business.produto.Armazenagem;

public class ArmazenagemDAO {
	public void defineArmazenagem(Armazenagem armazenagem)
			throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Armazenagem (produto_prateleira, prateleiras, estante, ativo) ");
		sql.append("VALUES (?, ?, ?, true)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			stmt.setInt(1, armazenagem.getQuantidadePorPrateleira());
			stmt.setInt(2, armazenagem.getQuantidadePrateleiras());
			stmt.setInt(3, armazenagem.getQuantidadeEstantes());
			stmt.execute();
		} catch (Exception e) {
			new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public Armazenagem retornaArmazenagem() throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		Armazenagem arm = new Armazenagem();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT produto_prateleira, prateleiras, estantes FROM Armazenagem ");
		sql.append("WHERE ativo = 1");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				arm.setQuantidadePorPrateleira(rs.getInt("produto_prateleira"));
				arm.setQuantidadePrateleiras(rs.getInt("prateleiras"));
				arm.setQuantidadeEstantes(rs.getInt("estantes"));
			}
			rs.close();
		} catch (Exception e) {
			new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return arm;
	}
	
	public void alteraArmazenagem(Armazenagem armazenagem) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Armazenagem (produto_prateleira, prateleiras, estante, ativo) ");
		sql.append("VALUES (?, ?, ?, true)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			desativaArmazenagem();
			stmt.setInt(1, armazenagem.getQuantidadePorPrateleira());
			stmt.setInt(2, armazenagem.getQuantidadePrateleiras());
			stmt.setInt(3, armazenagem.getQuantidadeEstantes());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	private void desativaArmazenagem() throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "UPDATE Armazenagem SET ativo = false WHERE ativo = 1";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
}
