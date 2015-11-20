package pim4sem.aev.business.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import pim4sem.aev.business.controlefinanceiro.NotaFiscal;
import pim4sem.aev.business.controlefinanceiro.Venda;
import pim4sem.aev.business.produto.Produto;

public class VendaDAO {
	
	public void cadastraVenda(Venda venda) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Venda (id_produto, valor_produto, qtd_produto, id_nota_fiscal) ");
		sql.append("VALUES (?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public int retornaVenda(int recebeNotaFiscal) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaVenda = 0;
		
		String sql = "SELECT id_venda FROM Venda WHERE id_nota_fiscal = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeNotaFiscal);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaVenda = rs.getInt("id_venda");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaVenda;
	}
	
	public List<Venda> retornaVenda() throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<Venda> listaVenda = new ArrayList<>();
		
		String sql = "SELECT id_venda, id_produto, valor_produto, qtd_produto, id_nota_fiscal FROM Venda";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Venda venda = new Venda();
				Produto produto = new Produto();
				NotaFiscal nf = new NotaFiscal();
				venda.setIdVenda(rs.getInt("id_venda"));
				produto.setCodigo(rs.getInt("id_produto"));
				produto.setValorVenda(rs.getDouble("valor_produto"));
				venda.setProduto(produto);
				venda.setQuantidadeProduto(rs.getInt("qtd_produto"));
				nf.setCodigoNotaFiscal(rs.getInt("id_nota_fiscal"));
				venda.setNf(nf);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return listaVenda;
	}
	
}
