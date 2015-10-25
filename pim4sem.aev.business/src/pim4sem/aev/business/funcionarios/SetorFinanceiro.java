package pim4sem.aev.business.funcionarios;

public class SetorFinanceiro implements Funcionario{

	//Métodos da Classe
	public void aprovaPagamento(int idCompra, double recebeValorCompra){
		
	}
	
	public void negaPagamento(int idCompra){
		
	}
	
	public Date retornaPrevisaoPagamento(int idCompra, Date dataPrevista){
		
		//verificar biblioteca correta!!!
		return new Date();
	}
	
	
	//Métodos sobrescritos
	
	@Override
	public void CadastraFuncionario(String recebeNome, String recebeCargo, double recebeSalario, String recebeGerente,
			boolean recebeCargoGerencial) {
		
	}

	@Override
	public void AlterarCargoFuncionario(String recebeNome, int recebeMatricula) {
		
	}

	@Override
	public void DemitirFuncionario(String recebeNome, int recebeMatricula) {
			
	}

	@Override
	public void PesquisaFuncionario(String recebeNome) {
		
		
	}

	@Override
	public void PesquisaFuncionario(int recebeMatricula) {
		
		
	}

}
