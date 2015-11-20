package pim4sem.aev.business.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.security.Timestamp;
import java.sql.Connection;

import pim4sem.aev.business.controlefinanceiro.Caixa;

public class CaixaDAO {
	public void cadastraCaixa(Caixa caixa) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Caixa (data_caixa, valor_caixa, soma_estoque, soma_vendas, soma_compra) ");
		sql.append("VALUES (NOW(), ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			stmt.setDouble(1, caixa.getSaldo());
			stmt.setDouble(2, caixa.getEstoque());
			stmt.setDouble(3, caixa.getVenda());
			stmt.setDouble(4, caixa.getCompra());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public List<Caixa> retornaCaixa() throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<Caixa> listaCaixa = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_caixa, data_caixa, valor_caixa, soma_estoque, soma_vendas, soma_compra ");
		sql.append("FROM Caixa");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Caixa caixa = new Caixa();
				caixa.setCodigo(rs.getInt("id_caixa"));
				caixa.setData(rs.getDate("data_caixa"));
				caixa.setSaldo(rs.getDouble("valor_caixa"));
				caixa.setEstoque(rs.getDouble("soma_estoque"));
				caixa.setVenda(rs.getDouble("soma_vendas"));
				caixa.setCompra(rs.getDouble("soma_compra"));
				listaCaixa.add(caixa);
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return listaCaixa;
	}
}
