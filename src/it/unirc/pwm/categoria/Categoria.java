package it.unirc.pwm.categoria;

public class Categoria implements java.io.Serializable {

	static final long serialVersionUID = 1L;
	private Integer idCategoria;
	private String nome;
	private Boolean tipo;

	public Categoria() {}

	public Categoria(String nome, Boolean tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public Integer getIdCategoria() {
		return this.idCategoria;		
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public Boolean isTipo() {
		return tipo;
	}
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nome=" + nome + ", tipo= " + tipo + "]";
	}	
}