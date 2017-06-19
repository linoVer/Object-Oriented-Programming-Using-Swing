package locadora;


import java.util.ArrayList;
import java.util.List;

public class Itens {

	private String descricao;
	private double valor;
	private String date;
	private String midia;
	private int codigo;
	List<Midia> listaMidias;
	private char situacao;

	static int cod = 0;

	public Itens(String descricao, double valor, String date, String midia) {
		this.codigo = cod;
		this.descricao = descricao;
		this.valor = valor;
		this.date = date;
		this.midia = midia;
		this.situacao = 'D';
		this.listaMidias = new ArrayList<>();
		cod++;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public String getDate() {
		return date;
	}

	public String getMidia() {
		return midia;
	}

	public int getCodigo() {
		return codigo;
	}

	public List<Midia> getListaMidias() {
		return listaMidias;
	}

	public char getSituacao() {
		return situacao;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}

}
