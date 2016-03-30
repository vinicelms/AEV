package pim4sem.aev.business.seguranca;

import java.util.Date;

import pim4sem.aev.business.funcionarios.Usuario;

public class Log {
	private int codigo;
	private Usuario usuario;
	private String descricao;
	private Date data;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
