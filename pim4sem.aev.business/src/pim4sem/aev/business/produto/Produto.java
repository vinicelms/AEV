package pim4sem.aev.business.produto;

import java.util.ArrayList;
import java.util.List;

public class Produto {

	private int codigo;
	private String nome;
	private String marca;
	private String cor;
	private double valorCompra;
	private double valorVenda;
	private String descricao;
	private int tamanho;
	private int tipoProduto;
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
	
	//M�todos
	
	public String getMarca() {
		return marca;
	}


	public String getCor() {
		return cor;
	}


	public double getValorCompra() {
		return valorCompra;
	}


	public double getValorVenda() {
		return valorVenda;
	}


	public int getTamanho() {
		return tamanho;
	}


	public int getTipoProduto() {
		return tipoProduto;
	}


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
	
	//ATEN��O!! IMPOSS�VEL FAZER SOBRECARGA ONDE OS TIPOS DE 2 M�TODOS SAO IGUAIS
	/*
	public void alteraProduto(int recebeCodigo, String recebeDescricao){
		
	}
	*/

	public void alteraProduto(int recebeCodigo, int recebeQuantidadeMinima){
		
	}
}
