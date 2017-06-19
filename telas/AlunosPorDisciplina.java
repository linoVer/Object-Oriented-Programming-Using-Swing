package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AlunosPorDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField codigoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunosPorDisciplina frame = new AlunosPorDisciplina();
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
	public AlunosPorDisciplina() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDaDisciplina = new JLabel("C\u00F3digo da Disciplina:");
		lblCdigoDaDisciplina.setBounds(10, 26, 137, 14);
		contentPane.add(lblCdigoDaDisciplina);
		
		codigoTextField = new JTextField();
		codigoTextField.setBounds(10, 51, 214, 20);
		contentPane.add(codigoTextField);
		codigoTextField.setColumns(10);
	}

}
