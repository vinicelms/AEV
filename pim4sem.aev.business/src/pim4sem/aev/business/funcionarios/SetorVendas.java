package pim4sem.aev.business.funcionarios;

public class SetorVendas extends Funcionario implements IAdministrar {
	
	private double comissao;
	
		
	public SetorVendas(){
		
	}
	
	//Métodos
	public void realizaVenda(double recebeValorVenda, int recebeMatriculaFuncionario){
		
	}
	
	public void cancelaVenda(){
		
	}
	
	public double calculaComissaoSobreVenda(double recebeValorVenda){
		
		return 0;
	}
	
	public void removeProduto(int codigoProduto){
		
	}
	
	//Métodos sobrescritos
	
	@Override
	public void cadastraFuncionario(String recebeNome, String recebeCargo, double recebeSalario,
			String recebeGerente, boolean recebeCargoGerencial){
		
	}
	
	@Override
	public void alterarCargoFuncionario(String recebeNome, int recebeMatricula){
		
	}
	
	@Override
	public void demitirFuncionario(String recebeNome, int recebeMatricula){
		
	}
	
	@Override
	public void pesquisaFuncionario(String recebeNome){

	}
	
	@Override
	public void pesquisaFuncionario(int recebeMatricula){

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
