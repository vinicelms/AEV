package pim4sem.aev.business.DAO;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
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
	
}
