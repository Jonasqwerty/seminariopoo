package model;

public class Pessoa {
	private String email;
	private String nome;
	private String sobrenome;
	private String senha;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Pessoa [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", senha=" + senha + "]";
	}
	
	
	
	

}
