package pim4sem.aev.business.controlefinanceiro;

import java.util.Date;

public abstract class FluxoCaixa extends CompraVenda{
	private int idConta;
	private double valorConta; 
	private Date dataConta;
	private Date dataFinalizacao;
	private boolean contaFinalizada;
	private String tipoConta;
	private String modalidadeConta;
	private String tipoPagamento;
	
	//Métodos
	
	public abstract void pesquisarConta();
	public abstract void finalizarConta();
	public abstract void adicionarConta();
	public abstract void defineDataFinalizacao();	
}
