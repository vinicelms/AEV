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
	private String tipoProduto;
	private int quantidadeEstoque;
	private int quantidadeMinima;
	private char posicaoEstoque;
	private int posicaoPrateleira;
	
	public void registraProduto(String recebeNome, String recebeMarca, String recebeCor, double recebeValorCompra,
			double recebeValorVenda, String recebeDescricao, int recebeQuantidade){
		setNome(recebeNome);
		setMarca(recebeMarca);
		setCor(recebeCor);
		setValorCompra(recebeValorCompra);
		setValorVenda(recebeValorVenda);
		setDescricao(recebeDescricao);
		setQuantidadeEstoque(recebeQuantidade);
		
		/*recebeNome = nome;
		recebeMarca = marca;
		recebeCor = cor;
		recebeValorCompra = valorCompra;
		recebeValorVenda = valorVenda;
		recebeDescricao = descricao;
		recebeQuantidade = quantidadeEstoque;*/
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
	
	//Gets e Sets do atributos
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public double getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}


	public double getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getTamanho() {
		return tamanho;
	}


	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}


	public String getTipoProduto() {
		return tipoProduto;
	}


	public void setTipoProduto(String tipoProduto) {
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
