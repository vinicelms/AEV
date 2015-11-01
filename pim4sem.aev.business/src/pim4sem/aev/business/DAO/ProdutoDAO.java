package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pim4sem.aev.business.produto.*;

public class ProdutoDAO {
	
	private Connection conn = new ConnectionFactory().getConnection();
	
	public void cadastraProduto(Produto produto) throws SQLException{
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO Produto (nome_produto, marca_produto, cor_produto, descricao_produto, ");
		sql.append("tamanho_produto, id_tipo_produto, qtd_minima, qtd_estoque, valor_compra, valor_venda) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			
		}
		
	}
	
}
