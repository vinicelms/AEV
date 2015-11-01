package pim4sem.aev.business.funcionarios;

import java.sql.Date;

public abstract class Funcionario {

	protected int matricula;
	protected String nome;
	protected char sexo;
	protected String cargo;
	protected String setor;
	protected double salario;
	protected String gerente;
	protected boolean cargoGerencial;
	protected Date dataNascimento;
	protected Date dataContratacao;
	
	public void gerenciaDados(int recebeMatricula, String recebeNome, String recebeCargo, double recebeSalario,
			String recebeGerente, boolean recebeCargoGerencial){
		
		matricula = recebeMatricula; 
		nome = recebeNome;
		cargo = recebeCargo;
		salario = recebeSalario;
		gerente = recebeGerente;
		cargoGerencial = recebeCargoGerencial;
	}
	
	public void cadastraFuncionario(){
		int ultimaMatricula;
		
		/* Pegar último ID cadastrado
		 e atribui à variável ultimaMatricula */ 
		
		
		
		
	}
	
	public abstract void alterarCargoFuncionario(String recebeNome, int recebeMatricula);
	
	public abstract void demitirFuncionario(String recebeNome, int recebeMatricula);
	
	public abstract void pesquisaFuncionario(String recebeNome);
	public abstract void pesquisaFuncionario(int recebeMatricula);

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

	public String getGerente() {
		return gerente;
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
	
}
