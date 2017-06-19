package farmacia;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa{
	
	private String matricula;
	private String senha;
	private List<Venda> listaVenda;
	
	
	public Funcionario(String nome, String matricula, String senha) {
		super(nome);
		this.matricula = matricula;
		this.senha = senha;
		this.listaVenda = new ArrayList<>();
	}

	public String getMatricula() {
		return matricula;
	}


	public String getSenha() {
		return senha;
	}

	public List<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

}