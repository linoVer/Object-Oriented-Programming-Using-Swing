package prova1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastrarResultadoDosJogos extends JFrame {

	private JPanel contentPane;
	private JTextField resultado1TextField;
	private JTextField resultado2TextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarResultadoDosJogos frame = new CadastrarResultadoDosJogos();
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
	public CadastrarResultadoDosJogos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 164);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaInicial().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(0, 0, 89, 23);
		contentPane.add(btnVoltar);

		String[] time1 = new String[200];

		for (int i = 0; i < CadastrarTime.listaDeTimes.size(); i++) {
			time1[i] = CadastrarTime.listaDeTimes.get(i).getNome();
		}

		JComboBox time1ComboBox = new JComboBox(time1);
		time1ComboBox.setBounds(54, 52, 130, 20);
		contentPane.add(time1ComboBox);

		JLabel lblTime = new JLabel("Time 1:");
		lblTime.setBounds(10, 55, 67, 14);
		contentPane.add(lblTime);

		resultado1TextField = new JTextField();
		resultado1TextField.setBounds(194, 52, 30, 20);
		contentPane.add(resultado1TextField);
		resultado1TextField.setColumns(10);

		String[] time2 = new String[200];

		for (int i = 0; i < CadastrarTime.listaDeTimes.size(); i++) {
			time2[i] = CadastrarTime.listaDeTimes.get(i).getNome();
		}

		JComboBox time2ComboBox = new JComboBox(time2);
		time2ComboBox.setBounds(282, 52, 130, 20);
		contentPane.add(time2ComboBox);

		JLabel lbltime = new JLabel(":Time 2");
		lbltime.setBounds(422, 55, 67, 14);
		contentPane.add(lbltime);

		resultado2TextField = new JTextField();
		resultado2TextField.setColumns(10);
		resultado2TextField.setBounds(242, 52, 30, 20);
		contentPane.add(resultado2TextField);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int golsTime1 = Integer.parseInt(resultado1TextField.getText());
				int golsTime2 = Integer.parseInt(resultado2TextField.getText());

				for (int i = 0; i < CadastrarTime.listaDeTimes.size(); i++) {
					if (CadastrarTime.listaDeTimes.get(i).getNome().equals(time1ComboBox.getSelectedItem())) {

					}
					if (CadastrarTime.listaDeTimes.get(i).getNome().equals(time2ComboBox.getSelectedItem())) {

					}
				}
			}
		});
		btnSalvar.setBounds(194, 91, 89, 23);
		contentPane.add(btnSalvar);
	}
}
