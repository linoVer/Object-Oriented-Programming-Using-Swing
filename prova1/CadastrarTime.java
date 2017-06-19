package prova1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastrarTime extends JFrame {

	private JPanel contentPane;
	private JTextField nomeTimeTextField;
	private JTextField estadoTextField;

	static List<Time> listaDeTimes = new ArrayList<>();

	public void limpar() {
		nomeTimeTextField.setText(null);
		estadoTextField.setText(null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarTime frame = new CadastrarTime();
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
	public CadastrarTime() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDoTime = new JLabel("Nome do Time:");
		lblNomeDoTime.setBounds(10, 60, 89, 14);
		contentPane.add(lblNomeDoTime);

		nomeTimeTextField = new JTextField();
		nomeTimeTextField.setBounds(102, 57, 156, 20);
		contentPane.add(nomeTimeTextField);
		nomeTimeTextField.setColumns(10);

		JLabel lblEstadouf = new JLabel("Estado (UF):");
		lblEstadouf.setBounds(10, 107, 89, 14);
		contentPane.add(lblEstadouf);

		estadoTextField = new JTextField();
		estadoTextField.setBounds(104, 104, 33, 20);
		contentPane.add(estadoTextField);
		estadoTextField.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new TelaInicial().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(0, 0, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = nomeTimeTextField.getText();
				String estado = estadoTextField.getText();

				Time time = new Time(nome, estado);
				listaDeTimes.add(time);

				limpar();
			}
		});
		btnCadastrar.setBounds(102, 156, 108, 23);
		contentPane.add(btnCadastrar);
	}

}
