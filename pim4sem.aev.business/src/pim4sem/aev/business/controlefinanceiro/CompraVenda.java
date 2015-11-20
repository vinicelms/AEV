package pim4sem.aev.business.controlefinanceiro;

import pim4sem.aev.business.funcionarios.Funcionario;
import pim4sem.aev.business.produto.Produto;

public abstract class CompraVenda {
	private Produto produto;
	private int quantidadeProduto;
	private NotaFiscal nf;
	
	public NotaFiscal getNf() {
		return nf;
	}
	public void setNf(NotaFiscal nf) {
		this.nf = nf;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
}