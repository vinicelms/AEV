package pim4sem.aev.business.funcionarios;

public interface Funcionario {
	
	int matricula = 0;
	String nome = null;
	String cargo = null;
	double salario = 0;
	String gerente = null;
	boolean cargoGerencial = false;
	
	public void CadastraFuncionario(String recebeNome, String recebeCargo, double recebeSalario,
			String recebeGerente, boolean recebeCargoGerencial);
	
	public void AlterarCargoFuncionario(String recebeNome, int recebeMatricula);
	
	public void DemitirFuncionario(String recebeNome, int recebeMatricula);
	
	public void PesquisaFuncionario(String recebeNome);
	public void PesquisaFuncionario(int recebeMatricula);
	
}
