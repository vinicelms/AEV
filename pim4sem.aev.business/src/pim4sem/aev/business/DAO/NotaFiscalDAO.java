package pim4sem.aev.business.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.type.NullType;

import pim4sem.aev.business.controlefinanceiro.NotaFiscal;
import pim4sem.aev.business.funcionarios.Funcionario;

public class NotaFiscalDAO {
	public int registraNotaFiscal(NotaFiscal notaFiscal) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		int idPagamento = 0;
		PagamentoDAO pag = new PagamentoDAO();
		int retornaNotaFiscal = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO NotaFiscal (matricula_func, valor_nota, tipo_movimentacao, ");
		sql.append("data_vencimento, data_pagamento, id_pagamento, nota_paga) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		
		try {
			idPagamento = pag.retornaTipoPagamento(notaFiscal.getTipoPagamento());
			if(idPagamento == 0){
				idPagamento = pag.cadastrarTipoPagamento(notaFiscal.getTipoPagamento());
			}
			stmt.setInt(1, notaFiscal.getFuncionario().getMatricula());
			stmt.setDouble(2, notaFiscal.getValor());
			stmt.setString(3, notaFiscal.getTipoMovimentacao()+"");
			stmt.setDate(4, (Date) notaFiscal.getDataVencimento());
			stmt.setDate(5, (Date) notaFiscal.getDataPagamento());
			stmt.setInt(6, idPagamento);
			stmt.setBoolean(7, notaFiscal.isNotaPaga());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while(rs.next()){
				retornaNotaFiscal = rs.getInt(1);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaNotaFiscal;
	}
	
	public List<NotaFiscal> retornaNotaFiscal(String recebeColuna, String recebeValor) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		List<NotaFiscal> nf = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT NF.id_nota_fiscal AS 'Codigo Nota Fiscal', NF.matricula_func AS Matricula, ");
		sql.append("NF.valor_nota AS Valor, NF.tipo_movimentacao AS 'Tipo Movimentacao', ");
		sql.append("NF.data_pagamento AS 'Data Pagamento', NF.data_vencimento AS 'Data Vencimento', ");
		sql.append("pag.tipo_pagamento AS 'Tipo Pagamento', NF.nota_paga AS 'Nota Paga' ");
		sql.append("FROM NotaFiscal AS NF ");
		sql.append("INNER JOIN Pagamento AS pag ON pag.id_pagamento = NF.id_pagamento");
		if(recebeColuna != null && recebeValor != null){
			sql.append(" WHERE ");
			sql.append(defineColuna(recebeColuna));
			if(recebeColuna == "Data Pagamento" || recebeColuna == "Data Vencimento"){
				sql.append(" LIKE ");
			} else{
				sql.append(" = ");
			}
			sql.append("?");
		}
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			if(recebeColuna != null && recebeValor != null){
				if(recebeColuna == "Codigo Nota Fiscal" || recebeColuna == "Matricula Funcionario"){
					stmt.setInt(1, Integer.parseInt(recebeValor));
				} else if(recebeColuna == "Valor"){
					stmt.setDouble(1, Double.parseDouble(recebeValor));
				} else if(recebeColuna == "Tipo Movimentacao" || recebeColuna == "Tipo Pagamento"){
					stmt.setString(1, recebeValor);
				} else if(recebeColuna == "Data Vencimento" || recebeColuna == "Data Pagamento"){
					Date dt = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(recebeValor);
					stmt.setDate(1, dt);
				} else if(recebeColuna == "Nota Paga"){
					stmt.setBoolean(1, Boolean.parseBoolean(recebeValor));
				}
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				NotaFiscal notaFiscal = new NotaFiscal();
				Funcionario funcionario = new Funcionario() {};
				notaFiscal.setCodigoNotaFiscal(rs.getInt("Codigo Nota Fiscal"));
				funcionario.setMatricula(rs.getInt("Matricula"));
				notaFiscal.setFuncionario(funcionario);
				notaFiscal.setValor(rs.getDouble("Valor"));
				notaFiscal.setTipoMovimentacao(rs.getString("Tipo Movimentacao").charAt(0));
				notaFiscal.setDataPagamento(rs.getDate("Data Pagamento"));
				notaFiscal.setDataVencimento(rs.getDate("Data Vencimento"));
				notaFiscal.setTipoPagamento(rs.getString("Tipo Pagamento"));
				notaFiscal.setNotaPaga(rs.getBoolean("Nota Paga"));
				nf.add(notaFiscal);
			}
			rs.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return nf;
	}
	
	public void pagaNotaFiscal(int recebeIdNotaFiscal) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		String sql = "UPDATE NotaFiscal SET nota_paga = true WHERE id_nota_fiscal = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeIdNotaFiscal);
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public void alteraNotaFiscal(NotaFiscal nf) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		if(verificaNotaFiscal(nf.getCodigoNotaFiscal())){
			throw new IllegalArgumentException("O Código da Nota Fiscal " + nf.getCodigoNotaFiscal() 
				+ " não existe!");
		}
		
		PagamentoDAO pag = new PagamentoDAO();
		int idPagamento =  pag.retornaTipoPagamento(nf.getTipoPagamento());
		if(idPagamento < 1){
			throw new IllegalArgumentException("O Tipo de Pagamento " + nf.getTipoPagamento() 
				+ " não existe");
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE NotaFiscal SET data_vencimento = ?, data_pagamento = ?, id_pagamento = ?, ");
		sql.append("nota_paga = ? WHERE id_nota_fiscal = ?");
		
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		
		try {
			stmt.setDate(1, (Date) nf.getDataVencimento());
			stmt.setDate(2, (Date) nf.getDataPagamento());
			stmt.setInt(3, idPagamento);
			stmt.setBoolean(4, nf.isNotaPaga());
			stmt.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
	}
	
	public boolean verificaNotaFiscal(int recebeIdNotaFiscal) throws SQLException{
		Connection conn = new ConnectionFactory().getConnection();
		
		boolean retornaVerificacao = false;
		
		String sql = "SELECT id_nota_fiscal FROM NotaFiscal WHERE id_nota_fiscal = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		try {
			stmt.setInt(1, recebeIdNotaFiscal);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				retornaVerificacao = true;
			}
		} catch (Exception e) {
			retornaVerificacao = false;
			throw new RuntimeException(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return retornaVerificacao;
	}
	
	private String defineColuna(String recebeColuna){
		Map<String, String> coluna = new HashMap<>();
		coluna.put("Codigo Nota Fiscal", "id_nota_fiscal");
		coluna.put("Matricula Funcionario", "matricula_func");
		coluna.put("Valor", "valor_nota");
		coluna.put("Tipo Movimentacao", "tipo_movimentacao");
		coluna.put("Data Vencimento", "data_vencimento");
		coluna.put("Data Pagamento", "data_pagamento");
		coluna.put("Tipo Pagamento", "id_pagamento");
		coluna.put("Nota Paga", "nota_paga");
		
		return coluna.get(recebeColuna);
	}
}
