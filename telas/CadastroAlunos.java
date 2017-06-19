package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import escola.Alunos;
import escola.Professores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastroAlunos extends JFrame {
	
	static List<Alunos> listaAlunos = new ArrayList<>();

	private JPanel contentPane;
	private JTextField nomeTextField;
	private JTextField creditoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAlunos frame = new CadastroAlunos();
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
		creditoTextField.setText(null);
		nomeTextField.setText(null);		
	}


	/**
	 * Create the frame.
	 */
	public CadastroAlunos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 21, 46, 14);
		contentPane.add(lblNome);
		
		nomeTextField = new JTextField();
		nomeTextField.setBounds(10, 44, 320, 20);
		contentPane.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		JLabel lblTotalDeCrditos = new JLabel("Total de Cr\u00E9ditos no Per\u00EDodo Atual:");
		lblTotalDeCrditos.setBounds(10, 75, 239, 14);
		contentPane.add(lblTotalDeCrditos);
		
		creditoTextField = new JTextField();
		creditoTextField.setBounds(10, 100, 320, 20);
		contentPane.add(creditoTextField);
		creditoTextField.setColumns(10);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(110, 142, 109, 23);
		contentPane.add(rdbtnMasculino);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 146, 46, 14);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(221, 142, 109, 23);
		contentPane.add(rdbtnFeminino);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnMasculino);
		grupo.add(rdbtnFeminino);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char sexo = 0;
				String nome = nomeTextField.getText();
				String matricula = Long.toHexString(Double.doubleToLongBits(Math.random()));
				
				while(listaAlunos.contains(matricula) || CadastrarProfessores.listaProfessores.contains(matricula)){
					matricula = Long.toHexString(Double.doubleToLongBits(Math.random()));
				}
				
				int quantideCreditos = Integer.parseInt(creditoTextField.getText());
				
				if(rdbtnFeminino.isSelected()){
					sexo = 'F';
				}else if(rdbtnMasculino.isSelected()){
					sexo = 'M';
				}			
				
				Alunos alunos = new Alunos(matricula.toUpperCase(), nome, sexo, quantideCreditos);
				listaAlunos.add(alunos);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				
				//limpar o form
				limpar();
				//limpa o radioGroup
				grupo.clearSelection(); 
			}
		});
		btnConfirmar.setBounds(10, 208, 115, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Administracao().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(215, 208, 115, 23);
		contentPane.add(btnVoltar);
	}

	public static List<Alunos> getListaAlunos() {
		return listaAlunos;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}


	public JTextField getCreditoTextField() {
		return creditoTextField;
	}

}
