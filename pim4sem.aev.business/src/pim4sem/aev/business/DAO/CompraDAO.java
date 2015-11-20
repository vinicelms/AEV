package pim4sem.aev.business.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import pim4sem.aev.business.controlefinanceiro.Compra;
import pim4sem.aev.business.controlefinanceiro.NotaFiscal;
import pim4sem.aev.business.produto.Produto;

public class CompraDAO {
	public void cadastraCompra(Compra compra) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Compra (id_produto, valor_produto, qtd_produto, id_nota_fiscal) ");
		sql.append("VALUES (?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			stmt.setInt(1, compra.getProduto().getCodigo());
			stmt.setDouble(2, compra.getProduto().getValorCompra());
			stmt.setInt(3, compra.getQuantidadeProduto());
			stmt.setInt(4, compra.getNf().getCodigoNotaFiscal());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public int retornaCompra(int recebeNotaFiscal) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaCompra = 0;
		
		String sql = "SELECT id_compra FROM Compra WHERE id_nota_fiscal = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeNotaFiscal);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaCompra = rs.getInt("id_compra");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaCompra;
	}
	
	public List<Compra> retornaCompra() throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<Compra> listaCompra = new ArrayList<>();
		
		String sql = "SELECT id_compra, id_produto, valor_produto, qtd_produto, id_nota_fiscal FROM Compra";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Compra compra = new Compra();
				Produto produto = new Produto();
				NotaFiscal nf = new NotaFiscal();
				compra.setIdCompra(rs.getInt("id_compra"));
				produto.setCodigo(rs.getInt("id_produto"));
				produto.setValorCompra(rs.getInt("valor_produto"));
				compra.setProduto(produto);
				compra.setQuantidadeProduto(rs.getInt("qtd_produto"));
				nf.setCodigoNotaFiscal(rs.getInt("id_nota_fiscal"));
				compra.setNf(nf);
				listaCompra.add(compra);
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return listaCompra;
	}
}
