package pim4sem.aev.business.produto;

import java.util.ArrayList;
import java.util.List;

public class Produto {

	private int codigo;
	private String nome;
	private double valor;
	private String descricao;
	private int quantidadeEstoque;
	private int quantidadeMinima;
	private char posicaoEstoque;
	private int posicaoPrateleira;
	
	//Gets do atributos
	
	public int getCodigo() {
		return codigo;
	}


	public String getNome() {
		return nome;
	}


	public double getValor() {
		return valor;
	}


	public String getDescricao() {
		return descricao;
	}


	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}


	public char getPosicaoEstoque() {
		return posicaoEstoque;
	}


	public int getPosicaoPrateleira() {
		return posicaoPrateleira;
	}
	
	//Métodos
	
	public void registraProduto(String recebeNome, double recebeValor, 
								int recebeQuantidade){
		
	}
	
	
	public List pesquisaProduto(int recebeCodigo){
		return new ArrayList();
	}
	

	public List pesquisaProduto(String recebeNome){
		return new ArrayList();
		
	}
	
	public void alteraProduto(int recebeCodigo, String recebeNome, 
							double recebeValor, String recebeDescricao){
		
	}
	
	public void alteraProduto(int recebeCodigo, String recebeNome){
		
	}
	
	public void alteraProduto(int recebeCodigo, double recebeValor){
		
	}
	
	//ATENÇÃO!! IMPOSSÍVEL FAZER SOBRECARGA ONDE OS TIPOS DE 2 MÉTODOS SAO IGUAIS
	/*
	public void alteraProduto(int recebeCodigo, String recebeDescricao){
		
	}
	*/

	public void alteraProduto(int recebeCodigo, int recebeQuantidadeMinima){
		
	}
}
