package model;

public class Produto {
	private int id;
	private String tipo;
	private String descricao;
	private float preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
	public void setId(String text) {
		// TODO Auto-generated method stub
		
	}
	
	

}
