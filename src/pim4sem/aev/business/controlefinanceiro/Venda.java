package pim4sem.aev.business.controlefinanceiro;

import pim4sem.aev.business.produto.Produto;

public class Venda extends CompraVenda{
	private int idVenda;

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public Venda(){
		super();
	}
}
