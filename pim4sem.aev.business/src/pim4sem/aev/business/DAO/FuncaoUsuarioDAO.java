package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncaoUsuarioDAO {

	public void registraFuncaoUsuario(String recebeFuncao) throws SQLException{
		
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "INSERT INTO FuncaoUsuario (nome_funcao) VALUES (?)";
		
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
	
	public int retornaIdFuncaoUsuario(String recebeFuncao) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaId = 0;
		
		String sql = "SELECT id_funcao FROM Funcao WHERE nome_funcao = ?";
		
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
	
}
