package pim4sem.aev.business.funcionarios;

public class SetorVendas implements Funcionario {
	
	public SetorVendas(){
		
	}
	
	public void CadastraFuncionario(String recebeNome, String recebeCargo, double recebeSalario,
			String recebeGerente, boolean recebeCargoGerencial){
		
	}
	
	public void AlterarCargoFuncionario(String recebeNome, int recebeMatricula){
		
	}
	
	public void DemitirFuncionario(String recebeNome, int recebeMatricula){
		recebeNome = nome;
		recebeMatricula = matricula;
	}
	
	public void PesquisaFuncionario(String recebeNome){
		recebeNome = nome;
	}
	
	public void PesquisaFuncionario(int recebeMatricula){
		recebeMatricula = matricula;
	}
	
}
