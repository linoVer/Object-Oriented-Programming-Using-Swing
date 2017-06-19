package prova1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCadastrarJogadores = new JButton("Cadastrar Jogadores");
		btnCadastrarJogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new CadastrarJogadores().setVisible(true);
				dispose();

			}
		});
		btnCadastrarJogadores.setBounds(233, 40, 191, 62);
		contentPane.add(btnCadastrarJogadores);

		JButton btnCadastrarTimes = new JButton("Cadastrar Times");
		btnCadastrarTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastrarTime().setVisible(true);
				dispose();
			}
		});
		btnCadastrarTimes.setBounds(10, 40, 191, 62);
		contentPane.add(btnCadastrarTimes);

		JButton btnListarTabelaDo = new JButton("Listar Tabela  \r\n ");
		btnListarTabelaDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 700, 380);

				JTable listarTabela = new javax.swing.JTable();
				listarTabela.setBounds(10, 11, 544, 259);
				getContentPane().add(listarTabela);

				List<Object[]> lista = new ArrayList<Object[]>();

				for (int i = 0; i < CadastrarTime.listaDeTimes.size(); i++) {

					String nome = CadastrarTime.listaDeTimes.get(i).getNome();
					int pontos = CadastrarTime.listaDeTimes.get(i).getPontos();
					int saldoDeGols = CadastrarTime.listaDeTimes.get(i).getSaldoDeGols();
					int golsFeitos = CadastrarTime.listaDeTimes.get(i).getGolsFeitos();
					int golsSofridos = CadastrarTime.listaDeTimes.get(i).getGolsSofridos();

					lista.add(new Object[] { nome, pontos, saldoDeGols, golsFeitos, golsSofridos });

				}

				listarTabela.setModel(new DefaultTableModel(lista.toArray(new Object[][] {}),
						new String[] { "Time", "Pontos", "Saldo de Gols", "Gols Feitos", "Gols Sofridos" }));

				JScrollPane scrollPane = new JScrollPane(listarTabela);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
				frame.setSize(720, 380);
				frame.setVisible(true);

			}
		});
		btnListarTabelaDo.setBounds(10, 131, 191, 62);
		contentPane.add(btnListarTabelaDo);

		JButton btnTransferirJogador = new JButton("Transferir Jogador");
		btnTransferirJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTransferirJogador.setBounds(233, 131, 191, 62);
		contentPane.add(btnTransferirJogador);

		JButton btnResultado = new JButton("Cadastrar Resultados dos Jogos");
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new CadastrarResultadoDosJogos().setVisible(true);
				dispose();

			}
		});
		btnResultado.setBounds(100, 225, 238, 62);
		contentPane.add(btnResultado);
	}
}
