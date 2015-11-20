package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pim4sem.aev.business.funcionarios.Funcionario;

public class GerenteDAO {

	public void registraGerente(Funcionario funcionario, String recebeSetor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		SetorDAO setor = new SetorDAO();
		
		String sql = "INSERT INTO Gerente (matricula, id_setor, ativo) VALUES (?, ?, true)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, funcionario.getMatricula());
			stmt.setInt(2, setor.retornaSetor(recebeSetor));
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public int retornaGerente(int recebeFuncionario) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int retornaFuncionario = 0;
		
		String sql = "SELECT id_gerente FROM Gerente WHERE matricula = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeFuncionario);
			ResultSet rs = stmt.executeQuery();
			if(rs.getFetchSize() > 0){
				retornaFuncionario = rs.getInt("id_gerente");
			} else{
				retornaFuncionario = 0;
			}
			rs.close();
		} catch (Exception e) {
			retornaFuncionario = 0;
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaFuncionario;
	}
	
	public void desativaGerente(int recebeMatriculaFuncionario) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "UPDATE Gerente SET ativo = false WHERE matricula = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeMatriculaFuncionario);
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
