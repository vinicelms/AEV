package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pim4sem.aev.business.controlefinanceiro.BalancoFinanceiro;
import pim4sem.aev.business.funcionarios.Funcionario;

public class BalancoFinanceiroDAO {
	public void registraBalancoFinanceiro(BalancoFinanceiro balanco, int recebeMatriculaFuncionario)
			throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO BalancoFinanceiro (matricula_func, data_auditoria, data_ini_auditoria, ");
		sql.append("data_term_auditoria, valor_entrada, valor_saida, auditoria_ok) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			stmt.setInt(1, recebeMatriculaFuncionario);
			stmt.setDate(2, (Date) balanco.getDataExecucao());
			stmt.setDate(3, (Date) balanco.getDataInicioAuditoria());
			stmt.setDate(4, (Date) balanco.getDataTerminoAuditoria());
			stmt.setDouble(5, balanco.getValorEntrada());
			stmt.setDouble(6, balanco.getValorSaida());
			stmt.setBoolean(7, balanco.isStatusAuditoria());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public List<BalancoFinanceiro> retornaBalancoFinanceiro() throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<BalancoFinanceiro> listaBalanco = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_auditoria, matricula_func, data_auditoria, data_ini_auditoria, ");
		sql.append("data_term_auditoria, valor_entrada, valor_saida, auditoria_ok FROM BalancoFinanceiro");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				BalancoFinanceiro bf = new BalancoFinanceiro();
				Funcionario funcionario = null;
				bf.setCodigo(rs.getInt("id_auditoria"));
				funcionario.setMatricula(rs.getInt("matricula_func"));
				bf.setFuncionario(funcionario);
				bf.setDataExecucao(rs.getDate("data_auditoria"));
				bf.setDataInicioAuditoria(rs.getDate("data_ini_auditoria"));
				bf.setDataTerminoAuditoria(rs.getDate("data_term_auditoria"));
				bf.setValorEntrada(rs.getDouble("valor_entrada"));
				bf.setValorSaida(rs.getDouble("valor_saida"));
				bf.setStatusAuditoria(rs.getBoolean("auditoria_ok"));
				listaBalanco.add(bf);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return listaBalanco;
	}
}
