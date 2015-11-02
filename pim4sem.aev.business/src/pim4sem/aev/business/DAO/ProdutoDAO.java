package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pim4sem.aev.business.produto.*;

public class ProdutoDAO {
	
	public void registarProduto(Produto produto) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO Produto (nome_produto, marca_produto, cor_produto, descricao_produto, ");
		sql.append("tamanho_produto, id_tipo_produto, qtd_minima, qtd_estoque, valor_compra, valor_venda) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getCor());
			stmt.setString(4, produto.getDescricao());
			stmt.setInt(5, produto.getTamanho());
			stmt.setInt(6, retornaIdTipoProduto(produto.getTipoProduto()));
			stmt.setInt(7, produto.getQuantidadeMinima());
			stmt.setInt(8, produto.getQuantidadeEstoque());
			stmt.setDouble(9, produto.getValorCompra());
			stmt.setDouble(10, produto.getValorVenda());
			
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
	}
	
	public List<Produto> retornaProduto(String recebeColuna, String recebeValor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<Produto> prod = new ArrayList<Produto>();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT prod.id_produto AS Codigo, prod.nome_produto AS Nome, ");
		sql.append("prod.marca_produto AS Marca, prod.cor_produto AS Cor, ");
		sql.append("prod.descricao_produto as Descricao, prod.tamanho_produto as Tamanho, ");
		sql.append("tp_prod.tipo_produto as TipoProduto, prod.qtd_minima as QtdMinima, ");
		sql.append("prod.qtd_estoque as QtdEstoque, prod.valor_compra as ValorCompra, ");
		sql.append("prod.valor_venda as ValorVenda FROM produto AS prod ");
		sql.append("INNER JOIN tipoproduto AS tp_prod on tp_prod.id_tipo_produto = prod.id_tipo_produto");		
		if(recebeValor != null && recebeColuna != null){
			sql.append(" WHERE ");
			sql.append(verificaNomeColuna(recebeColuna));
			sql.append(" = ?");
		}
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			
			if(recebeValor != null && recebeColuna != null){
				stmt.setString(1, recebeValor);
			}
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Produto produto = new Produto();
				
				produto.setCodigo(rs.getInt("Codigo"));
				produto.setNome(rs.getString("Nome"));
				produto.setMarca(rs.getString("Marca"));
				produto.setCor(rs.getString("Cor"));
				produto.setDescricao(rs.getString("Descricao"));
				produto.setTamanho(rs.getInt("Tamanho"));
				produto.setTipoProduto(rs.getString("TipoProduto"));
				produto.setQuantidadeMinima(rs.getInt("QtdMinima"));
				produto.setQuantidadeEstoque(rs.getInt("QtdEstoque"));
				produto.setValorCompra(rs.getDouble("ValorCompra"));
				produto.setValorVenda(rs.getDouble("ValorVenda"));
				
				prod.add(produto);
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
		return prod;
	}
	
	private String verificaNomeColuna(String recebeColuna){
		
		Map<String, String> colunas = new HashMap<String, String>();
		
		colunas.put("Código", "id_produto");
		colunas.put("Nome", "nome_produto");
		colunas.put("Marca", "marca_produto");
		colunas.put("Cor", "cor_produto");
		colunas.put("Descrição", "descricao_produto");
		colunas.put("Tamanho", "tamanho_produto");
		colunas.put("Tipo de Produto", "id_tipo_produto");
		colunas.put("Quantidade Mínima", "qtd_minima");
		colunas.put("Quantidade Estoque", "qtd_estoque");
		colunas.put("Valor de Compra", "valor_compra");
		colunas.put("Valor de Venda", "valor_venda");
		
		return colunas.get(recebeColuna);
	}
	
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
