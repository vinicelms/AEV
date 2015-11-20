package pim4sem.aev.business.controlefinanceiro;

import pim4sem.aev.business.produto.Produto;

public class Venda extends CompraVenda{
	private int idVenda;
	private Produto produto;
	private int quantidadeProduto;
	private NotaFiscal nf;
	
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public NotaFiscal getNf() {
		return nf;
	}
	public void setNf(NotaFiscal nf) {
		this.nf = nf;
	}
	
}
