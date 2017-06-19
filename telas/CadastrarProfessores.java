package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import escola.Professores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class CadastrarProfessores extends JFrame {

	static List<Professores> listaProfessores = new ArrayList<>();

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldCreditos;
	private JTextField textFieldValorHora;	
	private JTable listarProfessores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProfessores frame = new CadastrarProfessores();
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
		textFieldCreditos.setText(null);
		textFieldMatricula.setText(null); 
		textFieldNome.setText(null);
		textFieldValorHora.setText(null);
	}

	/**
	 * Create the frame.
	 */
	public CadastrarProfessores() {
		setTitle("CADASTRO DE PROFESSORES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 24, 46, 14);
		contentPane.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 49, 320, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setBounds(10, 80, 107, 14);
		contentPane.add(lblMatrcula);

		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(10, 107, 320, 20);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);

		JLabel lblTotalDeCrditos = new JLabel("Total de Cr\u00E9ditos no Per\u00EDodo Atual:");
		lblTotalDeCrditos.setBounds(10, 138, 248, 14);
		contentPane.add(lblTotalDeCrditos);

		textFieldCreditos = new JTextField();
		textFieldCreditos.setBounds(10, 166, 100, 20);
		contentPane.add(textFieldCreditos);
		textFieldCreditos.setColumns(10);

		JLabel lblValorDaHora = new JLabel("Valor da Hora Aula:");
		lblValorDaHora.setBounds(10, 197, 170, 14);
		contentPane.add(lblValorDaHora);

		textFieldValorHora = new JTextField();
		textFieldValorHora.setBounds(10, 221, 100, 20);
		contentPane.add(textFieldValorHora);
		textFieldValorHora.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 252, 46, 14);
		contentPane.add(lblSexo);

		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(95, 248, 124, 23);
		contentPane.add(rdbtnMasculino);

		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(221, 248, 109, 23);
		contentPane.add(rdbtnFeminino);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnMasculino);
		grupo.add(rdbtnFeminino);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char sexo = 0;
				String nome = textFieldNome.getText();
				String matricula = Long.toHexString(Double.doubleToLongBits(Math.random()));
				
				while(listaProfessores.contains(matricula) || CadastroAlunos.listaAlunos.contains(matricula)){
					matricula = Long.toHexString(Double.doubleToLongBits(Math.random()));
				}
				
				
				int quantideCreditos = Integer.parseInt(textFieldCreditos.getText());
				double valorHoraAula = Double.parseDouble(textFieldValorHora.getText());
				if(rdbtnFeminino.isSelected()){
					sexo = 'F';
				}else if(rdbtnMasculino.isSelected()){
					sexo = 'M';
				}			

				Professores professores = new Professores(matricula.toUpperCase(), nome, sexo, quantideCreditos, valorHoraAula);
				listaProfessores.add(professores);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				//limpar o form
				limpar();
				//limpa o radioGroup
				grupo.clearSelection(); 		

			}
		});
		btnConfirmar.setBounds(28, 307, 115, 23);
		contentPane.add(btnConfirmar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Administracao().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(215, 307, 115, 23);
		contentPane.add(btnVoltar);


	}
}
