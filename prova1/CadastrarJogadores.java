package prova1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastrarJogadores extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField idadeTextField;

	static List<Jogador> listaDeJogadores;
	private JTextField codigoTextField;

	public void limpar() {
		nomeTextField.setText(null);
		idadeTextField.setText(null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarJogadores frame = new CadastrarJogadores();
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
	public CadastrarJogadores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 44, 44, 14);
		contentPane.add(lblNome);

		nomeTextField = new JTextField();
		nomeTextField.setBounds(109, 41, 249, 20);
		contentPane.add(nomeTextField);
		nomeTextField.setColumns(10);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 92, 46, 14);
		contentPane.add(lblIdade);

		idadeTextField = new JTextField();
		idadeTextField.setBounds(109, 89, 69, 20);
		contentPane.add(idadeTextField);
		idadeTextField.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = nomeTextField.getText();
				int idade = Integer.parseInt(idadeTextField.getText());
				int codigo = Integer.parseInt(codigoTextField.getText());

				for (int i = 0; i < CadastrarTime.listaDeTimes.size(); i++) {
					if (CadastrarTime.listaDeTimes.get(i).getCodigo() == codigo) {
						Jogador jogador = new Jogador(nome, idade, CadastrarTime.listaDeTimes.get(i));
						listaDeJogadores.add(jogador);
						limpar();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Time não encontrado");
					}
				}

			}
		});
		btnCadastrar.setBounds(153, 186, 89, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new TelaInicial().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(0, -2, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblTime = new JLabel("C\u00F3digo do Time:");
		lblTime.setBounds(10, 137, 89, 14);
		contentPane.add(lblTime);

		codigoTextField = new JTextField();
		codigoTextField.setBounds(109, 134, 69, 20);
		contentPane.add(codigoTextField);
		codigoTextField.setColumns(10);
	}
}
