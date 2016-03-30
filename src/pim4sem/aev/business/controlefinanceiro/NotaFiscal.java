package pim4sem.aev.business.controlefinanceiro;

import java.util.Date;

import pim4sem.aev.business.funcionarios.Funcionario;

public class NotaFiscal {
	private int codigoNotaFiscal;
	private Funcionario funcionario;
	private double valor;
	private char tipoMovimentacao;
	private Date dataVencimento;
	private Date dataPagamento;
	private String tipoPagamento;
	private boolean notaPaga;
	
	public int getCodigoNotaFiscal() {
		return codigoNotaFiscal;
	}
	public void setCodigoNotaFiscal(int codigoNotaFiscal) {
		this.codigoNotaFiscal = codigoNotaFiscal;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public char getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(char tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public boolean isNotaPaga() {
		return notaPaga;
	}
	public void setNotaPaga(boolean notaPaga) {
		this.notaPaga = notaPaga;
	}
}
