package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import escola.Disciplinas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class CadastrarDisciplinas extends JFrame {

	static List<Disciplinas> listaDisciplinas = new ArrayList<>();


	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField quantidadeTextField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarDisciplinas frame = new CadastrarDisciplinas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * limpa os campos preenchidos no formulário
	 */
	public void limpar(){
		nomeTextField.setText(null);

		quantidadeTextField.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public CadastrarDisciplinas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDaDisciplina = new JLabel("Nome da Disciplina:");
		lblNomeDaDisciplina.setBounds(10, 33, 149, 14);
		contentPane.add(lblNomeDaDisciplina);

		nomeTextField = new JTextField();
		nomeTextField.setBounds(10, 58, 217, 20);
		contentPane.add(nomeTextField);
		nomeTextField.setColumns(10);

		JLabel lblQuantidadeDeCrditos = new JLabel("Quantidade de Cr\u00E9ditos:");
		lblQuantidadeDeCrditos.setBounds(10, 89, 149, 14);
		contentPane.add(lblQuantidadeDeCrditos);

		quantidadeTextField = new JTextField();
		quantidadeTextField.setBounds(10, 114, 217, 20);
		contentPane.add(quantidadeTextField);
		quantidadeTextField.setColumns(10);

		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = nomeTextField.getText();

				String codigo = GenerateRandomString.randomString(8);
				
				while(listaDisciplinas.contains(codigo)){
					codigo = GenerateRandomString.randomString(8);
				}

				while(listaDisciplinas.contains(codigo)){
					codigo = Long.toHexString(Double.doubleToLongBits(Math.random()));
				}					

				int quantidadeDeCreditos =  Integer.parseInt(quantidadeTextField.getText());

				Disciplinas disciplinas = new Disciplinas(nome, codigo.toUpperCase(), quantidadeDeCreditos);

				listaDisciplinas.add(disciplinas);
				JOptionPane.showMessageDialog(null, "Cadastradada com Sucesso");
				limpar();

			}
		});
		btnConfirm.setBounds(10, 197, 102, 23);
		contentPane.add(btnConfirm);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Administracao().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(184, 197, 110, 23);
		contentPane.add(btnVoltar);
	}

	public static List<Disciplinas> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public JTextField getQuantidadeTextField() {
		return quantidadeTextField;
	}

	public static class GenerateRandomString {

		public static final String DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		public static Random random = new Random();

		public static String randomString(int len) {
			StringBuilder sb = new StringBuilder(len);

			for (int i = 0; i < len; i++) {
				sb.append(DATA.charAt(random.nextInt(DATA.length())));
			}

			return sb.toString();
		}

	}

}
