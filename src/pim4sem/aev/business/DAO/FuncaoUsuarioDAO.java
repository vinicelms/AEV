package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncaoUsuarioDAO {

	public void registraFuncaoUsuario(String recebeFuncao) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO FuncaoUsuario (nome_funcao, ativo) VALUES (?, 1)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeFuncao);
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
	}
	
	public int retornaFuncaoUsuario(String recebeFuncao) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaId = 0;
		
		String sql = "SELECT id_funcao FROM FuncaoUsuario WHERE nome_funcao = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeFuncao);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaId = rs.getInt("id_funcao");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaId;
	}
	
	public String retornaFuncaoUsuario(int recebeFuncaoUsuario) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String retornaFuncaoUsuario = null;
		
		String sql = "SELECT nome_funcao FROM FuncaoUsuario WHERE id_funcao = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeFuncaoUsuario);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaFuncaoUsuario = rs.getString("nome_funcao");
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaFuncaoUsuario;
	}
	
	public void alteraFuncaoUsuario(String recebeNomeFuncao, boolean recebeAtivo) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "UPDATE FuncaoUsuario SET nome_funcao = ?, ativo = ? WHERE id_funcao = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setString(1, recebeNomeFuncao);
			stmt.setBoolean(2, recebeAtivo);
			stmt.setInt(3, retornaFuncaoUsuario(recebeNomeFuncao));
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public List<String> retornaFuncaoUsuario() throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<String> retornaFuncaoUsuario = new ArrayList<>();
		
		String sql = "SELECT nome_funcao FROM FuncaoUsuario";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaFuncaoUsuario.add(rs.getString("nome_funcao"));
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
		return retornaFuncaoUsuario;
	}
	
}
