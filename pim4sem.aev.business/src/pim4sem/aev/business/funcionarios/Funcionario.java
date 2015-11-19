package pim4sem.aev.business.funcionarios;

import java.util.Date;
import java.sql.SQLException;

import pim4sem.aev.business.DAO.FuncionarioDAO;

public abstract class Funcionario {

	protected int matricula;
	protected String nome;
	protected char sexo;
	protected String cargo;
	protected String setor;
	protected double salario;
	protected boolean cargoGerencial;
	protected Date dataNascimento;
	protected Date dataContratacao;
	protected FuncionarioDAO bd = new FuncionarioDAO();
	
	public void gerenciaDados(int recebeMatricula, String recebeNome, String recebeCargo, double recebeSalario,
			String recebeGerente, boolean recebeCargoGerencial){
		
		matricula = recebeMatricula; 
		nome = recebeNome;
		cargo = recebeCargo;
		salario = recebeSalario;
		cargoGerencial = recebeCargoGerencial;
	}
	
	public void cadastraFuncionario() throws SQLException{
		bd.adicionaFuncionario(this);		
	}
	
	public void pesquisaFuncionario(int recebeMatricula) throws SQLException{
		Funcionario func = (Funcionario) new Object();
		func = bd.carregaFuncionario(recebeMatricula);
	}
	

	public void alterarCargoFuncionario(int recebeMatricula) throws SQLException{
		bd.alteraFuncionario(this);
	}
	
	public void demitirFuncionario(int recebeMatricula) throws SQLException{
		bd.removerFuncionario(recebeMatricula);
	}
	
	//public abstract void pesquisaFuncionario(String recebeNome);

	// GETTERS AND SETTERS
	
	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public char getSexo() {
		return sexo;
	}

	public String getCargo() {
		return cargo;
	}

	public String getSetor() {
		return setor;
	}

	public double getSalario() {
		return salario;
	}

	public boolean isCargoGerencial() {
		return cargoGerencial;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setCargoGerencial(boolean cargoGerencial) {
		this.cargoGerencial = cargoGerencial;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
	
	
}