package pim4sem.aev.business.funcionarios;

import java.util.Date;

public class SetorFinanceiro extends Funcionario{

	//Métodos da Classe
	public void aprovaPagamento(int idCompra, double recebeValorCompra){
		
	}
	
	public void negaPagamento(int idCompra){
		
	}
	
	public Date retornaPrevisaoPagamento(int idCompra, Date dataPrevista){
		
		return new Date();
	}

	//Métodos sobrescritos

	@Override
	public void cadastraFuncionario(String recebeNome, String recebeCargo, double recebeSalario, String recebeGerente,
			boolean recebeCargoGerencial) {
		
	}

	@Override
	public void alterarCargoFuncionario(String recebeNome, int recebeMatricula) {
			
	}

	@Override
	public void demitirFuncionario(String recebeNome, int recebeMatricula) {
		
	}

	@Override
	public void pesquisaFuncionario(String recebeNome) {
		
	}

	@Override
	public void pesquisaFuncionario(int recebeMatricula) {
		
	}
}
