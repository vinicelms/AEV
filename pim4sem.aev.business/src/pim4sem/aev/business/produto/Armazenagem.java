package pim4sem.aev.business.produto;

import java.sql.SQLException;

import pim4sem.aev.business.DAO.ArmazenagemDAO;

public class Armazenagem {

	private int codigoEstante;
	private int quantidadePrateleiras;
	private int quantidadeEstantes;
	private int quantidadePorPrateleira;
	private int capacidadeTotal = quantidadeEstantes * quantidadePrateleiras * quantidadePorPrateleira;
	private ArmazenagemDAO amd = new ArmazenagemDAO();
	private Armazenagem amg = new Armazenagem();

	//Métodos
	public void verificarCapacidade(){
		
	}
	
	public void cadastrarEstante(int recebeQtdPratileira, int recebeQtdPorPratileira) throws SQLException{
		
		amg.setQuantidadePrateleiras(recebeQtdPorPratileira);
		amg.setQuantidadePorPrateleira(recebeQtdPorPratileira);
		
		amd.defineArmazenagem(amg);
		
	}
	
	public void definirCadacidadeArmazegem(int recebeQtdEstante, int recebeQtdPrateleiras, int recebeQtdPorPrateleira){
		
		amg.setQuantidadeEstantes(recebeQtdEstante);
		amg.s

		}
	}
	
	public boolean verificaEspaçoDisponivel(){
	
		amd.retornaArmazenagem();		
		
	}
	
	public void verificaQtdEstante(){
		
		amd.retornaArmazenagem().getQuantidadeEstantes();
		
	}
	
	public void verificaQtdPrateleiras(){
		
		amd.retornaArmazenagem().getQuantidadePrateleiras();
		
	}
	
	public void verificaQtdPorPrateleiras(){
		
		amd.retornaArmazenagem().getQuantidadePorPrateleira();
		
	}
		///verificar qtd estante, prateleiras, por prateleira, qtd produto, qtd produto por estante,
	
	//Gets e Sets do atributos
	
	public void setCodigoEstante(int codigoEstante) {
		if(codigoEstante == 0){
			throw new IllegalArgumentException("O codigo precisa ser gerado!");
		}
		this.codigoEstante = codigoEstante;
	}

	public void setQuantidadePrateleiras(int quantidadePrateleiras) {
		if(quantidadePrateleiras < 1 || quantidadePrateleiras >= 200) {
			if(quantidadePrateleiras < 1)
				throw new IllegalArgumentException("A quantidade de prateleira deve ser maior do que 0!");
			} else{
				throw new IllegalArgumentException("A quantidade de prateleira deve ser menor do que 201!");
		}
		this.quantidadePrateleiras = quantidadePrateleiras;
	}
	
	public void setQuantidadeEstantes(int quantidadeEstantes) {
		if(quantidadeEstantes < 1 || quantidadeEstantes >= 1000) {
			if(quantidadeEstantes < 1)
				throw new IllegalArgumentException("A quantidade de prateleira deve ser maior do que 0!");
			} else{
				throw new IllegalArgumentException("A quantidade de prateleira deve ser menor do que 1001!");
		}
		this.quantidadeEstantes = quantidadeEstantes;
	}

	public void setQuantidadePorPrateleira(int quantidadePorPrateleira) {
		if(quantidadePorPrateleira < 1 || quantidadePorPrateleira >= 300) {
			if(quantidadeEstantes < 1)
				throw new IllegalArgumentException("A quantidade de prateleira deve ser maior do que 0!");
			} else{
				throw new IllegalArgumentException("A quantidade de prateleira deve ser menor do que 301!");
		}
		this.quantidadePorPrateleira = quantidadePorPrateleira;
	}

	public void setCapacidadeTotal(int capacidadeTotal) {
		if(capacidadeTotal > 60000000){
			throw new IllegalArgumentException("Limite da capacidade total excedido!");
		}
		this.capacidadeTotal = capacidadeTotal;
	}
	
	public int getQuantidadePrateleiras() {
		return quantidadePrateleiras;
	}

	public int getQuantidadeEstantes() {
		return quantidadeEstantes;
	}

	public int getQuantidadePorPrateleira() {
		return quantidadePorPrateleira;
	}

	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}
	
}
