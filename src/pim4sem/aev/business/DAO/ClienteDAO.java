package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import pim4sem.aev.business.cliente.Cliente;

public class ClienteDAO {
	public void cadastraCliente(Cliente cliente) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO Cliente (nome_cliente, cpf_cliente, sexo_cliente) VALUES (?, ?, ?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, cliente.getNome());
			stmt.setLong(2, cliente.getCpf());
			stmt.setString(3, cliente.getSexo()+"");
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public List<Cliente> retornaCliente(String recebeColuna, String recebeValor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<Cliente> cliente = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_cliente, nome_cliente, cpf_cliente, sexo_cliente FROM Cliente");
		if(recebeColuna != null && recebeValor != null){
			sql.append(" WHERE ");
			sql.append(defineColuna(recebeColuna));
			if(recebeColuna == "Nome"){
				sql.append(" LIKE ? ");
			} else{
				sql.append(" = ? ");
			}
		}
		sql.append(" ORDER BY nome_cliente");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			if(recebeColuna != null && recebeValor != null){
				if(recebeColuna == "Codigo"){
					stmt.setInt(1, Integer.parseInt(recebeValor));
				} else if (recebeColuna == "Nome") {
					stmt.setString(1, "%" + recebeValor + "%");
				} else if(recebeColuna == "CPF"){
					stmt.setLong(1, Long.parseLong(recebeValor));
				} else if(recebeColuna == "Sexo"){
					stmt.setString(1, recebeValor);
				}
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Cliente cli = new Cliente();
				cli.setCodigo(rs.getInt("id_cliente"));
				cli.setNome(rs.getString("nome_cliente"));
				cli.setCpf(rs.getLong("cpf_cliente"));
				cli.setSexo(rs.getString("sexo_cliente").charAt(0));
				cliente.add(cli);
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return cliente;
	}
	
	public void alteraCliente(Cliente cliente) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE Cliente SET nome_cliente = ?, cpf_cliente = ?, sexo_cliente = ? ");
		sql.append("WHERE id_cliente = ?");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			stmt.setString(1, cliente.getNome());
			stmt.setLong(2, cliente.getCpf());
			stmt.setString(3, cliente.getSexo()+"");
			stmt.setInt(4, cliente.getCodigo());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	private String defineColuna(String recebeColuna){
		Map<String, String> coluna = new HashMap<>();
		coluna.put("Codigo", "id_cliente");
		coluna.put("Nome", "nome_cliente");
		coluna.put("CPF", "cpf_cliente");
		coluna.put("Sexo", "sexo_cliente");
		
		return coluna.get(recebeColuna);
	}
	
}
