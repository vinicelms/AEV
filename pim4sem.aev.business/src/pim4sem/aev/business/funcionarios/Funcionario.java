package pim4sem.aev.business.funcionarios;

public abstract class Funcionario {

	protected int matricula;
	protected String nome;
	protected String cargo;
	protected double salario;
	protected String gerente;
	protected boolean cargoGerencial;
	
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
	
}
