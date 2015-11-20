package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pim4sem.aev.business.funcionarios.Usuario;
import pim4sem.aev.business.seguranca.Log;

public class LogDAO {
	public void registraLog(Log log) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		UsuarioDAO usu = new UsuarioDAO();
		
		String sql = "INSERT INTO Log (matricula_func, descricao_log, data_log) VALUES (?, ?, ?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, log.getUsuario().getCodigo());
			stmt.setString(2, log.getDescricao());
			stmt.setDate(3, (Date) log.getData());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public List<Log> retornaLog() throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<Log> listaLog = new ArrayList<>();
		
		String sql = "SELECT id_log, id_usuario, descricao_log, data_log FROM Log";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Log log = new Log();
				Usuario usuario = new Usuario();
				log.setCodigo(rs.getInt("id_log"));
				usuario.setCodigo(rs.getInt("id_usuario"));
				log.setUsuario(usuario);
				log.setDescricao(rs.getString("descricao_log"));
				log.setData(rs.getDate("data_log"));
				listaLog.add(log);
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return listaLog;
	}
}
