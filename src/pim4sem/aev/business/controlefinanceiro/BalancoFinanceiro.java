package pim4sem.aev.business.controlefinanceiro;

import java.util.Date;

import pim4sem.aev.business.funcionarios.Funcionario;

public class BalancoFinanceiro {
	private int codigo;
	private Funcionario funcionario;
	private Date dataExecucao;
	private Date dataInicioAuditoria;
	private Date dataTerminoAuditoria;
	private double valorEntrada;
	private double valorSaida;
	private boolean statusAuditoria;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDataExecucao() {
		return dataExecucao;
	}
	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	public Date getDataInicioAuditoria() {
		return dataInicioAuditoria;
	}
	public void setDataInicioAuditoria(Date dataInicioAuditoria) {
		this.dataInicioAuditoria = dataInicioAuditoria;
	}
	public Date getDataTerminoAuditoria() {
		return dataTerminoAuditoria;
	}
	public void setDataTerminoAuditoria(Date dataTerminoAuditoria) {
		this.dataTerminoAuditoria = dataTerminoAuditoria;
	}
	public double getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	public double getValorSaida() {
		return valorSaida;
	}
	public void setValorSaida(double valorSaida) {
		this.valorSaida = valorSaida;
	}
	public boolean isStatusAuditoria() {
		return statusAuditoria;
	}
	public void setStatusAuditoria(boolean statusAuditoria) {
		this.statusAuditoria = statusAuditoria;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}