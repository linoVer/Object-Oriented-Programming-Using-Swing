package locadora;

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
import java.awt.event.ActionEvent;

public class CadastrarTipoMidia extends JFrame {
	
	private Singleton singleton = Singleton.getInstance();

	private JPanel contentPane;
	private JTextField textFieldTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarTipoMidia frame = new CadastrarTipoMidia();
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
	public CadastrarTipoMidia() {
		setTitle("Cadastrar Tipos de Midias\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescrio = new JLabel("Descrição: ");
		lblDescrio.setBounds(10, 48, 72, 14);
		contentPane.add(lblDescrio);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(86, 45, 238, 20);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String midia = textFieldTipo.getText();
				Midia tipoMidia = new Midia(midia);
				try {
					singleton.cadastrarTipoMidia(tipoMidia);
					textFieldTipo.setText(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(61, 146, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu().setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(222, 146, 89, 23);
		contentPane.add(btnCancelar);
	}
}
