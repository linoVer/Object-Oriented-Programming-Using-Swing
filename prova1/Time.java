package prova1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Time {

	private String nome;
	private String estado;
	private int codigo;
	private List<Jogador> listaJogadoresDoTime;

	private int saldoDeGols;
	private int pontos;
	private int golsSofridos;
	private int golsFeitos;

	private static int cod = 0;

	public Time(String nome, String estado) {

		this.nome = nome;
		this.estado = estado;
		this.codigo = cod;
		this.listaJogadoresDoTime = new ArrayList<>();

		cod++;
	}

	public void contratarJogador(Jogador novoJogador) {

		if (!this.listaJogadoresDoTime.contains(novoJogador.getCodigo())) {
			this.listaJogadoresDoTime.add(novoJogador);
		} else {
			for (int i = 0; i < CadastrarJogadores.listaDeJogadores.size(); i++) {
				if (CadastrarJogadores.listaDeJogadores.get(i).getTime() != null) {
					JOptionPane.showMessageDialog(null, "Jogador já possui time");
				}
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public String getEstado() {
		return estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public List<Jogador> getListaJogadoresDoTime() {
		return listaJogadoresDoTime;
	}

	public int getSaldoDeGols() {
		return saldoDeGols;
	}

	public int getPontos() {
		return pontos;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public int getGolsFeitos() {
		return golsFeitos;
	}

}
