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
	
	public void registrarProduto(Produto produto) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		TipoProdutoDAO tipoProduto = new TipoProdutoDAO();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO Produto (nome_produto, marca_produto, cor_produto, descricao_produto, ");
		sql.append("tamanho_produto, id_tipo_produto, qtd_minima, qtd_estoque, valor_compra, valor_venda) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		int tipoProd = tipoProduto.retornaTipoProduto(produto.getTipoProduto());
		
		if(tipoProd < 1){
			tipoProduto.registraTipoProduto(produto.getTipoProduto());
			tipoProd = tipoProduto.retornaTipoProduto(produto.getTipoProduto());
		}
		
		try {
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getCor());
			stmt.setString(4, produto.getDescricao());
			stmt.setInt(5, produto.getTamanho());
			stmt.setInt(6, tipoProd);
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
			sql.append(defineNomeColuna(recebeColuna));
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
	
	public void alteraProduto(Produto produto) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		TipoProdutoDAO tp = new TipoProdutoDAO();
		int tipoProduto = 0;
		tipoProduto = tp.retornaTipoProduto(produto.getTipoProduto());
		if(tipoProduto == 0){
			throw new IllegalArgumentException("O Tipo de Produto " + produto.getTipoProduto() 
				+ " não existe!");
		}
		
		int idProduto = 0;
		List<Produto> listaProduto = new ArrayList<>();
		listaProduto = retornaProduto("Codigo", String.valueOf(produto.getCodigo()));
		if(listaProduto.size() == 0){
			throw new IllegalArgumentException("O Código de Produto " + produto.getCodigo()
				+ " não existe!");
		} else {
			idProduto = produto.getCodigo();
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE Produto SET nome_produto = ?, marca_produto = ?, cor_produto = ?, ");
		sql.append("descricao_produto = ?, tamanho_produto = ?, id_tipo_produto = ?, qtd_minima = ?, ");
		sql.append("qtd_estoque = ?, valor_compra = ?, valor_venda = ? WHERE id_produto = ?");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getCor());
			stmt.setString(4, produto.getDescricao());
			stmt.setInt(5, produto.getTamanho());
			stmt.setInt(6, tipoProduto);
			stmt.setInt(7, produto.getQuantidadeMinima());
			stmt.setInt(8, produto.getQuantidadeEstoque());
			stmt.setDouble(9, produto.getValorCompra());
			stmt.setDouble(10, produto.getValorVenda());
			stmt.setInt(11, idProduto);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	private String defineNomeColuna(String recebeColuna){
		Map<String, String> colunas = new HashMap<String, String>();
		colunas.put("Codigo", "id_produto");
		colunas.put("Nome", "nome_produto");
		colunas.put("Marca", "marca_produto");
		colunas.put("Cor", "cor_produto");
		colunas.put("Descricao", "descricao_produto");
		colunas.put("Tamanho", "tamanho_produto");
		colunas.put("Tipo de Produto", "id_tipo_produto");
		colunas.put("Quantidade Minima", "qtd_minima");
		colunas.put("Quantidade Estoque", "qtd_estoque");
		colunas.put("Valor de Compra", "valor_compra");
		colunas.put("Valor de Venda", "valor_venda");
		
		return colunas.get(recebeColuna);
	}
	
}
