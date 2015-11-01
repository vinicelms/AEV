package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pim4sem.aev.business.produto.*;

public class ProdutoDAO {
	
	private static Connection conn = new ConnectionFactory().getConnection();
	
	static void cadastraProduto(Produto produto) throws SQLException{
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO Produto (nome_produto, marca_produto, cor_produto, descricao_produto, ");
		sql.append("tamanho_produto, id_tipo_produto, qtd_minima, qtd_estoque, valor_compra, valor_venda) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getMarca());
		stmt.setString(3, produto.getCor());
		stmt.setString(4, produto.getDescricao());
		stmt.setInt(5, produto.getTamanho());
		stmt.setInt(6, produto.getTipoProduto());
		stmt.setInt(7, produto.getQuantidadeMinima());
		stmt.setInt(8, produto.getQuantidadeEstoque());
		
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
