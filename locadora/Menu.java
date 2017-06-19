package locadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarMidias = new JButton("Cadastrar Midias");
		btnCadastrarMidias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastrarTipoMidia().setVisible(true);
				dispose();
			}
		});
		btnCadastrarMidias.setBounds(28, 22, 150, 100);
		contentPane.add(btnCadastrarMidias);
		
		JButton btnCadastrarItens = new JButton("Cadastrar Itens");
		btnCadastrarItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastrarItens().setVisible(true);
				dispose();
			}
		});
		btnCadastrarItens.setBounds(221, 22, 150, 100);
		contentPane.add(btnCadastrarItens);
		
		JButton btnAlugar = new JButton("Alugar");
		btnAlugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Alugar().setVisible(true);
				dispose();
			}
		});
		btnAlugar.setBounds(28, 150, 150, 100);
		contentPane.add(btnAlugar);
		
		JButton btnDevoluo = new JButton("Devolu\u00E7\u00E3o");
		btnDevoluo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Devolucao().setVisible(true);
				dispose();
			}
		});
		btnDevoluo.setBounds(221, 150, 150, 100);
		contentPane.add(btnDevoluo);
	}

}
