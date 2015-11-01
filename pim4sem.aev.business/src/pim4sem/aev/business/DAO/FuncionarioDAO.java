package pim4sem.aev.business.DAO;

import com.mysql.jdbc.Connection;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pim4sem.aev.business.funcionarios.Funcionario;

public class FuncionarioDAO {

	private Connection conn;
	
	public FuncionarioDAO(){
		conn = new ConnectionFactory().getConnection();
	}
	
	public void adicionaFuncionario(Funcionario funcionario) throws SQLException{
		
		StringBuffer sql = new StringBuffer();
		CargoDAO cargo = new CargoDAO();
		
		sql.append("INSERT INTO Funcionario (matricula, nome_func, sexo_func, id_cargo, id_setor, ");
		sql.append("salario, id_gerente, cargo_gerencial, ano_nascimento, ano_contratacao) VALUES (");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		stmt.setLong(1, funcionario.getMatricula());
		stmt.setString(2, funcionario.getNome());
		stmt.setString(3, String.valueOf(funcionario.getCargo()));
		stmt.setInt(4, cargo.retornaIdCargo(funcionario.getCargo()));
		stmt.setInt(5, funcionario.getSetor()); // TODO: necessita da classe SetorDAO
		stmt.setDouble(6, funcionario.getSalario());
		stmt.setInt(7, funcionario.getGerente()); // TODO: necessita da classe GerenteDAO
		stmt.setBoolean(8, funcionario.isCargoGerencial());
		stmt.setDate(9, funcionario.getDataNascimento());
		stmt.setDate(10, funcionario.getDataContratacao());
		
		try{
			stmt.execute();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}		
	}
	
	public Funcionario carregaFuncionario(int matriculaFunc) throws SQLException{
		Funcionario func = (Funcionario) new Object();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Funcionario WHERE matricula = ?");
		ResultSet rs = stmt.executeQuery();
		try {
			while(rs.next()){
				func.setNome(rs.getString("nome_func"));
				func.setCargo(rs.getString("id_cargo"));
				func.setSexo(rs.getString("sexo_func"));
				func.setCargoGerencial(rs.getBoolean("cargo_gerencial"));
				func.setGerente(rs.getString("id_gerente"));
				func.setSalario(rs.getDouble("salario"));
				func.setSetor(rs.getString("id_setor"));
				func.setDataNascimento(rs.getDate("ano_nascimento"));
				func.setDataContratacao(rs.getDate("ano_contratacao"));
			}			
			return func;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			e.printStackTrace();
			return null;
		} finally {
			stmt.close();
			conn.close();
		}
	}
	
	public void removerFuncionario(int recebeMatricula) throws SQLException{
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Funcionario WHERE matricula = ?");
			stmt.setLong(1, recebeMatricula);
			stmt.execute();			
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public void alteraFuncionario(Funcionario funcionario)throws SQLException{
		String sql = "UPDATE Funcionario SET = nome_func, sexo_func, id_cargo, "
				+ "id_setor, salario, id_gerente, cargo_gerencial, "
				+ "ano_nascimento, ano_contratacao VALUES = ?, ?, ?, ?, ?, ?, ?, ?, ?";
		
		try {
			PreparedStatement stmt = conn.clientPrepareStatement(sql);
			stmt.setLong(1, funcionario.getMatricula());
			stmt.setString(2, funcionario.getNome());
			stmt.setString(3, String.valueOf(funcionario.getCargo()));
			stmt.setInt(4, cargo.retornaIdCargo(funcionario.getCargo()));
			stmt.setInt(5, funcionario.getSetor()); // TODO: necessita da classe SetorDAO
			stmt.setDouble(6, funcionario.getSalario());
			stmt.setInt(7, funcionario.getGerente()); // TODO: necessita da classe GerenteDAO
			stmt.setBoolean(8, funcionario.isCargoGerencial());
			stmt.setDate(9, funcionario.getDataNascimento());
			stmt.setDate(10, funcionario.getDataContratacao());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	
}