package pim4sem.aev.business.DAO;

import com.mysql.jdbc.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pim4sem.aev.business.funcionarios.Funcionario;

public class FuncionarioDAO {
	
	public void adicionaFuncionario(Funcionario funcionario) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		CargoDAO cargo = new CargoDAO();
		GerenteDAO gerente = new GerenteDAO();
		SetorDAO setor = new SetorDAO();
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO Funcionario (matricula, nome_func, sexo_func, id_cargo, id_setor, ");
		sql.append("salario, cargo_gerencial, ano_nascimento, ano_contratacao) VALUES (");
		sql.append("?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
				
		try{
			stmt.setLong(1, funcionario.getMatricula());
			stmt.setString(2, funcionario.getNome());
			stmt.setString(3, funcionario.getSexo()+"");
			stmt.setInt(4, cargo.retornaCargo(funcionario.getCargo()));
			stmt.setInt(5, setor.retornaSetor(funcionario.getSetor()));
			stmt.setDouble(6, funcionario.getSalario());
			stmt.setBoolean(7, funcionario.isCargoGerencial());
			stmt.setDate(8, (Date) funcionario.getDataNascimento());
			stmt.setDate(9, (Date) funcionario.getDataContratacao());
			stmt.execute();
			if(funcionario.isCargoGerencial()){
				gerente.registraGerente(funcionario, funcionario.getSetor());
			}
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}		
	}
	
	public Funcionario carregaFuncionario(int recebeMatriculaFuncionario) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		Funcionario funcionario = null;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT matricula, nome_func, sexo_func, id_cargo, id_setor, salario, cargo_gerencial, ");
		sql.append("ano_nascimento, ano_contratacao WHERE matricula = ?");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			stmt.setInt(1, recebeMatriculaFuncionario);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				funcionario.setNome(rs.getString("nome_func"));
				funcionario.setCargo(rs.getString("id_cargo"));
				funcionario.setSexo(rs.getString("sexo_func").charAt(0));
				funcionario.setCargoGerencial(rs.getBoolean("cargo_gerencial"));
				funcionario.setSalario(rs.getDouble("salario"));
				funcionario.setSetor(rs.getString("id_setor"));
				funcionario.setDataNascimento(rs.getDate("ano_nascimento"));
				funcionario.setDataContratacao(rs.getDate("ano_contratacao"));
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			stmt.close();
			conn.close();
		}
		return funcionario;
	}
	
	public void removerFuncionario(int recebeMatricula) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "DELETE FROM Funcionario WHERE matricula = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setLong(1, recebeMatricula);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public void alteraFuncionario(Funcionario funcionario)throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		CargoDAO cargo = new CargoDAO();
		GerenteDAO gerente = new GerenteDAO();
		SetorDAO setor = new SetorDAO();
		
		StringBuilder sql = new StringBuilder();		
		sql.append("UPDATE Funcionario SET nome_func = ?, sexo_func = ?, id_cargo = ?, id_setor = ?, ");
		sql.append("salario = ?, cargo_gerencial = ?, ano_nacimento = ?, ");
		sql.append("ano_contratacao = ? WHERE matricula = ?");
		
		PreparedStatement stmt = conn.clientPrepareStatement(sql.toString());
		
		try {
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSexo()+"");
			stmt.setInt(3, setor.retornaSetor(funcionario.getSetor()));
			stmt.setDouble(4, funcionario.getSalario());
			stmt.setBoolean(5, funcionario.isCargoGerencial());
			stmt.setDate(6, (Date) funcionario.getDataNascimento());
			stmt.setDate(7, (Date) funcionario.getDataContratacao());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}	
}