package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import escola.Alunos;
import escola.Disciplinas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastrarAlunoNaDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField matriculaTextField;
	private JTextField discliplinatextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAlunoNaDisciplina frame = new CadastrarAlunoNaDisciplina();
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
	public CadastrarAlunoNaDisciplina() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 279, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		matriculaTextField = new JTextField();
		matriculaTextField.setBounds(10, 54, 248, 20);
		contentPane.add(matriculaTextField);
		matriculaTextField.setColumns(10);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setBounds(10, 22, 100, 14);
		contentPane.add(lblMatrcula);

		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setBounds(10, 105, 115, 14);
		contentPane.add(lblDisciplina);

		discliplinatextField = new JTextField();
		discliplinatextField.setBounds(10, 140, 248, 20);
		contentPane.add(discliplinatextField);
		discliplinatextField.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < CadastrarDisciplinas.getListaDisciplinas().size(); i++) {

					if (CadastrarDisciplinas.getListaDisciplinas().get(i).getCodigo()
							.equalsIgnoreCase(discliplinatextField.getText())) {

						for (int j = 0; j < CadastroAlunos.getListaAlunos().size(); j++) {
							if (CadastroAlunos.getListaAlunos().get(j).getMatricula()
									.equalsIgnoreCase(matriculaTextField.getText())) {

								CadastrarDisciplinas.listaDisciplinas.addAll(i,
										(Collection<? extends Disciplinas>) CadastroAlunos.listaAlunos.get(j));

							} else {
								JOptionPane.showMessageDialog(null, "Aluno não matriculado");
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
					}
				}

			}
		});
		btnConfirmar.setBounds(10, 197, 89, 23);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(169, 197, 89, 23);
		contentPane.add(btnVoltar);

	}

}
