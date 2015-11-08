package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoProdutoDAO {
	
	public void registraTipoProduto(String recebeTipoProduto) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO TipoProduto (tipo_produto) VALUES (?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeTipoProduto);
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}

	public int retornaIdTipoProduto(String recebeTipoProduto) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaTipoProduto = 0;
		
		String sql = "SELECT id_tipo_produto FROM TipoProduto WHERE tipo_produto = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			
			stmt.setString(1, recebeTipoProduto);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				retornaTipoProduto = rs.getInt("id_tipo_produto");
			}
			rs.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
		return retornaTipoProduto;
	}
	
}
