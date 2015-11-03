package pim4sem.aev.business.funcionarios;

public class Usuario {
	
	private int login;
	private String senha;
	private String nome;
	private boolean funcionario;
	private String funcao;
	private String status;	
	
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isFuncionario() {
		return funcionario;
	}
	public void setFuncionario(boolean funcionario) {
		this.funcionario = funcionario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
