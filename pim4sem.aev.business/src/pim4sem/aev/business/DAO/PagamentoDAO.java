package pim4sem.aev.business.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PagamentoDAO {

	public int cadastrarTipoPagamento(String recebePagamento) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaTipoPagamento = 0;
		
		String sql = "INSERT INTO Pagamento (tipo_pagamento) VALUES (?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		try {
			stmt.setString(1, recebePagamento);
			retornaTipoPagamento = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while(rs.next()){
				retornaTipoPagamento = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaTipoPagamento;
	}
	
	public String retornaTipoPagamento(int recebeTipoPagamento) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String tipoProduto = null;
		
		String sql = "SELECT tipo_pagamento FROM Pagamento WHERE id_pagamento = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeTipoPagamento);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				tipoProduto = rs.getString("tipo_pagamento");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return tipoProduto;
	}
	
}
