package pim4sem.aev.business.controlefinanceiro;

import java.util.Date;

public class Caixa {
	private int codigo;
	private Date data;
	private double saldo;
	private double estoque;
	private double venda;
	private double compra;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getEstoque() {
		return estoque;
	}
	public void setEstoque(double estoque) {
		this.estoque = estoque;
	}
	public double getVenda() {
		return venda;
	}
	public void setVenda(double venda) {
		this.venda = venda;
	}
	public double getCompra() {
		return compra;
	}
	public void setCompra(double compra) {
		this.compra = compra;
	}
}
