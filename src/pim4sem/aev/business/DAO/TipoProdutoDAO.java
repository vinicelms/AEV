package pim4sem.aev.business.DAO;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoProdutoDAO {
	
	public int registraTipoProduto(String recebeTipoProduto) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaTipoProduto = 0;
		
		String sql = "INSERT INTO TipoProduto (tipo_produto) VALUES (?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1, recebeTipoProduto);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while(rs.next()){
				retornaTipoProduto = rs.getInt(1);
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
	
	public List<String> retornaTipoProduto() throws SQLException {
		Connection conn = new ConnectionFactory().getConnection();
		
		List<String> listaTipoProduto = new ArrayList<>();
		
		String sql = "SELECT tipo_produto FROM TipoProduto";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				listaTipoProduto.add(rs.getString("tipo_produto"));
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return listaTipoProduto;
	}

	public int retornaTipoProduto(String recebeTipoProduto) throws SQLException{
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
	
	public void alteraTipoProduto(String recebeTipoProduto) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int tipoProduto = retornaTipoProduto(recebeTipoProduto);
		if(tipoProduto < 1){
			throw new IllegalArgumentException("O Tipo de Produto " + recebeTipoProduto + " não existe!");
		}
		
		String sql = "UPDATE TipoProduto SET tipo_produto = ? WHERE id_tipo_produto = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeTipoProduto);
			stmt.setInt(2, tipoProduto);
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
