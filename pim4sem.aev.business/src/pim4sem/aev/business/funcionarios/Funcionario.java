package pim4sem.aev.business.funcionarios;

public abstract class Funcionario {

	int matricula = 0;
	String nome = null;
	String cargo = null;
	double salario = 0;
	String gerente = null;
	boolean cargoGerencial = false;
	
	public abstract void cadastraFuncionario(String recebeNome, String recebeCargo, double recebeSalario,
			String recebeGerente, boolean recebeCargoGerencial);
	
	public abstract void alterarCargoFuncionario(String recebeNome, int recebeMatricula);
	
	public abstract void demitirFuncionario(String recebeNome, int recebeMatricula);
	
	public abstract void pesquisaFuncionario(String recebeNome);
	public abstract void pesquisaFuncionario(int recebeMatricula);
	
}
