package pim4sem.aev.business.produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pim4sem.aev.business.DAO.ProdutoDAO;

public class Produto {

	private int codigo;
	private String nome;
	private String marca;
	private String cor;
	private double valorCompra;
	private double valorVenda;
	private String descricao;
	private int tamanho;
	private String tipoProduto;
	private int quantidadeEstoque;
	private int quantidadeMinima;
	private char posicaoEstoque;
	private int posicaoPrateleira;
	
		
	//SENHORES ACHEI OS METODOS ABAIXO DESNECESSARIOS, É VALIDO NOS REFLETIRMOS SOBRE!!
	
	/*
	
	//ATENÇÃO!! IMPOSSÍVEL FAZER SOBRECARGA ONDE OS TIPOS DE 2 MÉTODOS SAO IGUAIS
	
	public void alteraProduto(int recebeCodigo, String recebeDescricao){
		
	}
	

	public void alteraProduto(int recebeCodigo, int recebeQuantidadeMinima){
		
	}*/
	
	//Gets e Sets do atributos
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		if(codigo == 0){
			throw new IllegalArgumentException("O codigo precisa ser gerado!");
		}
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		if(nome == null){
			throw new IllegalArgumentException("O nome precisa ser definido!");
		}
		this.nome = nome;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		if(marca == null){
			throw new IllegalArgumentException("A marca precisa ser definida!");
		}
		this.marca = marca;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		if(cor == null){
			throw new IllegalArgumentException("A cor precisa ser definida!");
		}
		this.cor = cor;
	}


	public double getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(double valorCompra) {
		if(valorCompra < 10 || valorCompra >= 999.99){
			if(valorCompra < 10){
				throw new IllegalArgumentException("O valor de compra deve ser maior do que 10!");
			} else{
				throw new IllegalArgumentException("O valor de venda deve ser menor do que 999.99");
			}
		}
		this.valorCompra = valorCompra;
	}


	public double getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(double valorVenda) {
		if(valorVenda > 999.99 || valorVenda < 10){
			if(valorVenda > 999.99){
				throw new IllegalArgumentException("O valor de venda deve ser menor do que 999.99");
			} else{
				throw new IllegalArgumentException("O valor de venda precisa ser maior do que 10");
			}
		}
		this.valorVenda = valorVenda;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		if(descricao == null){
			throw new IllegalArgumentException("A descrição precisa ser definida!");
		}
		this.descricao = descricao;
	}


	public int getTamanho() {
		return tamanho;
	}


	public void setTamanho(int tamanho) {
		if(tamanho < 3 || tamanho > 60){
			if(tamanho < 3){
				throw new IllegalArgumentException("O tamanho não pode ser menor que 3");
			} else{
				throw new IllegalArgumentException("O tamanho não pode ser maior que 60");
			}
		}
		this.tamanho = tamanho;
	}


	public String getTipoProduto() {
		return tipoProduto;
	}


	public void setTipoProduto(String tipoProduto) {
		if(tipoProduto == null){
			throw new IllegalArgumentException("O tipo de produto precisa ser definido");
		}
		this.tipoProduto = tipoProduto;
	}


	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}


	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}


	public char getPosicaoEstoque() {
		return posicaoEstoque;
	}


	public void setPosicaoEstoque(char posicaoEstoque) {
		this.posicaoEstoque = posicaoEstoque;
	}


	public int getPosicaoPrateleira() {
		return posicaoPrateleira;
	}


	public void setPosicaoPrateleira(int posicaoPrateleira) {
		this.posicaoPrateleira = posicaoPrateleira;
	}

}
