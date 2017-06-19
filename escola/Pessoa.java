package escola;

public abstract class Pessoa {
	
	private String matricula;
	private String nome;
	private char sexo;
	private int quantideCreditos;
	
	
	public Pessoa(String matricula, String nome, char sexo, int quantideCreditos) {
		this.matricula = matricula;
		this.nome = nome;
		this.sexo = sexo;
		this.quantideCreditos = quantideCreditos;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public char getSexo() {
		return sexo;
	}


	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public int getQuantideCreditos() {
		return quantideCreditos;
	}


	public void setQuantideCreditos(int quantideCreditos) {
		this.quantideCreditos = quantideCreditos;
	}
	
	
	
	
	
	

}
