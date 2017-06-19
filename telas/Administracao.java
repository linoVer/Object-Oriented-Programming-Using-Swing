package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LabelUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.Window.Type;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;

public class Administracao extends JFrame {

	TelaInicial tela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administracao frame = new Administracao();
					frame.setSize(700, 380);
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

	public Administracao() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 380);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		JMenuItem mntmCadastrarProfessor = new JMenuItem("Cadastrar Professores");
		mntmCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastrarProfessores().setVisible(true);
				dispose();
			}
		});

		JMenuItem mntmCadastrarAluno = new JMenuItem("Cadastrar Alunos");
		mntmCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new CadastroAlunos().setVisible(true);
				dispose();
			}
		});
		mnCadastro.add(mntmCadastrarAluno);

		JMenuItem mntmCadastraDisciplinas = new JMenuItem("Cadastrar Disciplinas");
		mntmCadastraDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new CadastrarDisciplinas().setVisible(true);
				dispose();

			}
		});
		mnCadastro.add(mntmCadastraDisciplinas);
		mnCadastro.add(mntmCadastrarProfessor);
		
		JMenuItem mntmAdicionarAlunoNa = new JMenuItem("Adicionar Aluno na Disciplina");
		mntmAdicionarAlunoNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CadastrarAlunoNaDisciplina().setVisible(true);
				dispose();
				
			}
		});
		mnCadastro.add(mntmAdicionarAlunoNa);
		
		JMenuItem mntmAdicionarProfessorNa = new JMenuItem("Adicionar Professor na Disciplina");
		mntmAdicionarProfessorNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CadastrarProfessores().setVisible(true);
				dispose();
			}
		});
		mnCadastro.add(mntmAdicionarProfessorNa);

		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);

		JMenuItem mntmListarAlunos = new JMenuItem("Listar Alunos");
		mnListar.add(mntmListarAlunos);

		JMenuItem mntmListarDisciplinas = new JMenuItem("Listar Disciplinas");
		mnListar.add(mntmListarDisciplinas);
		mntmListarDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 700, 380);

				JTable listarDisciplinas = new javax.swing.JTable();
				listarDisciplinas.setBounds(10, 11, 544, 259);
				getContentPane().add(listarDisciplinas);

				List<Object[]> lista = new ArrayList<Object[]>();



				for (int i = 0; i < CadastrarDisciplinas.listaDisciplinas.size(); i++) {

					String nome = CadastrarDisciplinas.listaDisciplinas.get(i).getNome();
					String codigo = CadastrarDisciplinas.listaDisciplinas.get(i).getCodigo();
					int creditos = CadastrarDisciplinas.listaDisciplinas.get(i).getQuantidadeDeCreditos();


					lista.add(new Object[] {nome, codigo, creditos});

				}

				listarDisciplinas.setModel(new DefaultTableModel(lista.toArray(new Object[][] {}), 
						new String[] {"Nome","Código", "Créditos"}));

				JScrollPane scrollPane = new JScrollPane(listarDisciplinas);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
				frame.setSize(720, 380);
				frame.setVisible(true);  

			}
		});

		JMenuItem mntmListarProfessores = new JMenuItem("Listar Professores");
		mnListar.add(mntmListarProfessores);
		
		JMenuItem mntmListarAlunosPor = new JMenuItem("Listar Alunos por Disciplina");
		mntmListarAlunosPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AlunosPorDisciplina().setVisible(true);
				dispose();
			}
		});
		mnListar.add(mntmListarAlunosPor);
		
		JMenuItem mntmListarProfessoresPor = new JMenuItem("Listar Professores por Disciplina");
		mnListar.add(mntmListarProfessoresPor);



		mntmListarProfessores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 700, 380);

				JTable listarProfessores = new javax.swing.JTable();
				listarProfessores.setBounds(10, 11, 544, 400);
				getContentPane().add(listarProfessores);

				List<Object[]> lista = new ArrayList<Object[]>();

				Collections.sort(CadastrarProfessores.listaProfessores);

				for (int i = 0; i < CadastrarProfessores.listaProfessores.size(); i++) {

					String nome = CadastrarProfessores.listaProfessores.get(i).getNome();
					String matricula = CadastrarProfessores.listaProfessores.get(i).getMatricula();
					int creditos = CadastrarProfessores.listaProfessores.get(i).getQuantideCreditos();
					char sexo = CadastrarProfessores.listaProfessores.get(i).getSexo();
					double valorHora = CadastrarProfessores.listaProfessores.get(i).getValorHoraAula();
					double salario = creditos * valorHora;

					lista.add(new Object[] { nome, matricula, creditos, 
							valorHora, sexo, salario });

				}		

				listarProfessores.setModel(new DefaultTableModel(lista.toArray(new Object[][] {}), 
						new String[] {"Nome", "Matrícula", "Créditos", 
								"Valor Hora/Aula", "Sexo", "Salário"}));

				JScrollPane scrollPane = new JScrollPane(listarProfessores);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
				frame.setSize(820, 380);
				frame.setVisible(true);  
			

			}
		});
		mntmListarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 700, 380);

				JTable listarAlunos = new javax.swing.JTable();
				listarAlunos.setBounds(10, 11, 544, 259);
				getContentPane().add(listarAlunos);

				List<Object[]> lista = new ArrayList<Object[]>();

				Collections.sort(CadastroAlunos.listaAlunos);

				for (int i = 0; i < CadastroAlunos.listaAlunos.size(); i++) {

					String nome = CadastroAlunos.listaAlunos.get(i).getNome();
					String matricula = CadastroAlunos.listaAlunos.get(i).getMatricula();
					int creditos = CadastroAlunos.listaAlunos.get(i).getQuantideCreditos();
					char sexo = CadastroAlunos.listaAlunos.get(i).getSexo();


					lista.add(new Object[] {nome, matricula, creditos, sexo});

				}

				listarAlunos.setModel(new DefaultTableModel(lista.toArray(new Object[][] {}), 
						new String[] {"Nome", "Matrícula", "Créditos", "Sexo"}));

				JScrollPane scrollPane = new JScrollPane(listarAlunos);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
				frame.setSize(720, 380);
				frame.setVisible(true);  

			}
		});

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmMudarSenha = new JMenuItem("Mudar Senha");
		mntmMudarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



			}
		});
		mnHelp.add(mntmMudarSenha);

		JMenuItem mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaInicial().setVisible(true);
				dispose();
			}
		});
		mnHelp.add(mntmVoltar);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
	}
}
