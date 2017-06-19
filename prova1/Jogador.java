package prova1;

public class Jogador {

	private String nome;
	private int idade;
	private int codigo;
	private Time time;

	private static int cod = 0;

	public Jogador(String nome, int idade, Time time) {
		this.nome = nome;
		this.idade = idade;
		this.codigo = cod;
		cod++;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getIdade() {
		return idade;
	}

	public Time getTime() {
		return time;
	}

}
