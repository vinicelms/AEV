package pim4sem.aev.business.funcionarios;

import java.util.Date;

public class SetorCompras extends Funcionario implements IAdministrar {

	public SetorCompras(){
		
	}
	
	//Métodos
	
	public void registraVenda(double recebeValor, int recebeMatriculaFuncionario){
				
	}
	
	public void registraVenda(double recebeValor, int recebeMatriculaFuncionario, Date dataVenda){
	
	}	
	
	public void registraCompra(){
		
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

	@Override
	public void adicionarRegistroHistorico() {
		
	}

	@Override
	public void removerRegistroHistorico() {
		
	}

	@Override
	public void alterarRegistroHistorico() {
		
	}
	
	
	
}
