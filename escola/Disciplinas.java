package escola;

import java.util.ArrayList;
import java.util.List;

public class Disciplinas {
	
	private String nome;
	private String codigo;
	private int quantidadeDeCreditos;
	private  static List<Alunos> listaDeAlunos;
	private  static List<Professores> listaDeProfessores;
	
	
	public Disciplinas(String nome, String codigo, int quantidadeDeCreditos) {
	
		this.nome = nome;
		this.codigo = codigo;
		this.quantidadeDeCreditos = quantidadeDeCreditos;
		Disciplinas.listaDeAlunos = new ArrayList<>();
		Disciplinas. listaDeProfessores = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getQuantidadeDeCreditos() {
		return quantidadeDeCreditos;
	}
	public void setQuantidadeDeCreditos(int quantidadeDeCreditos) {
		this.quantidadeDeCreditos = quantidadeDeCreditos;
	}

	public List<Alunos> getListaDeAlunos() {
		return listaDeAlunos;
	}

	public List<Professores> getListaDeProfessores() {
		return listaDeProfessores;
	}

	public void setListaDeAlunos(List<Alunos> listaDeAlunos) {
		Disciplinas.listaDeAlunos = listaDeAlunos;
	}

	public void setListaDeProfessores(List<Professores> listaDeProfessores) {
		Disciplinas.listaDeProfessores = listaDeProfessores;
	}
	
	

}
