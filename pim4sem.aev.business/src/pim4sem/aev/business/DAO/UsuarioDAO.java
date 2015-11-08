package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pim4sem.aev.business.funcionarios.Usuario;

public class UsuarioDAO {

	public void registraUsuario(Usuario usuario) throws SQLException{
		FuncaoUsuarioDAO func = new FuncaoUsuarioDAO();

		Connection conn = new ConnectionFactory().getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Usuario (usu_login, usu_senha, usu_nome, e_funcionario, id_funcao) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?)");

		PreparedStatement stmt = conn.prepareStatement(sql.toString());

		try {
			stmt.setInt(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getNome());
			stmt.setBoolean(4, usuario.isFuncionario());
			stmt.setInt(5, func.retornaIdFuncaoUsuario(usuario.getFuncao()));
			stmt.setInt(6, 1);
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}

	public List<Usuario> retornaUsuario(String recebeColuna, String recebeNome) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();

		List<Usuario> listaUsuario = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT usu.usu_login AS Login, usu.usu_nome AS Nome, usu.e_funcionario AS Funcionario, ");
		sql.append("fun_usu.nome_funcao AS Funcao, sts_usu.usu_status AS Status FROM Usuario AS usu ");
		sql.append("INNER JOIN FuncaoUsuario AS fun_usu ON usu.id_funcao = fun_usu.id_funcao ");
		sql.append("INNER JOIN StatusUsuario AS sts_usu ON usu.id_status = sts_usu.id_status ");
		sql.append("WHERE usu.usu_nome LIKE ?");

		PreparedStatement stmt = conn.prepareStatement(sql.toString());

		try {
			stmt.setString(1, "%" + recebeNome + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Usuario usu = new Usuario();
				usu.setLogin(rs.getInt("Login"));
				usu.setNome(rs.getString("Nome"));
				usu.setFuncionario(rs.getBoolean("Funcionario"));
				usu.setFuncao(rs.getString("Funcao"));
				usu.setStatus(rs.getString("Status"));
				listaUsuario.add(usu);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return listaUsuario;
	}

	public boolean loginUsuario(int recebeLogin, String recebeSenha) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();

		int login = 0;
		String senha = null;
		int status = 0;
		boolean verificaLogin = false;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT usu_login, usu_senha, id_status FROM Usuario ");
		sql.append("WHERE usu_login = ? AND usu_senha = ?");

		PreparedStatement stmt = conn.prepareStatement(sql.toString());

		try {
			if(recebeSenha.length() != 128){
				verificaLogin = false;
			}
			else{
				stmt.setInt(1, recebeLogin);
				stmt.setString(2, recebeSenha);

				ResultSet rs = stmt.executeQuery();
				login = rs.getInt("usu_login");
				senha = rs.getString("usu_senha");
				status = rs.getInt("id_status");
				rs.close();

				if(recebeLogin == login && recebeSenha == senha && (status == 1 || status == 2)){
					verificaLogin =  true;
				}
				else{
					verificaLogin = false;
				}
			}
		} catch (Exception e) {
			verificaLogin = false;
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return verificaLogin;
	}

}
