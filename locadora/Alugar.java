package locadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import prova1.CadastrarTime;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alugar extends JFrame {

	private Singleton singleton = Singleton.getInstance();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alugar frame = new Alugar();
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
	public Alugar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTipoDeMidia = new JLabel("Tipo de Midia:");
		lblTipoDeMidia.setBounds(20, 42, 100, 14);
		contentPane.add(lblTipoDeMidia);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(130, 39, 142, 20);
		comboBox.addItem(" ");
		for (Midia tipo : singleton.getTiposDeMidia()) {
			comboBox.addItem(tipo.getMidia());
		}

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(100, 100, 700, 380);

				JTable listarTabela = new javax.swing.JTable();
				listarTabela.setBounds(10, 11, 544, 259);
				getContentPane().add(listarTabela);

				List<Object[]> lista = new ArrayList<Object[]>();

				for (int i = 0; i < singleton.getItens().size(); i++) {

					if (comboBox.getSelectedItem().equals(singleton.getItens().get(i).getMidia())) {
						int cod = singleton.getItens().get(i).getCodigo();
						String descricao = singleton.getItens().get(i).getDescricao();
						double valor = singleton.getItens().get(i).getValor();
						char situacao = singleton.getItens().get(i).getSituacao();

						lista.add(new Object[] { cod, descricao, valor, situacao });
					}

				}

				listarTabela.setModel(new DefaultTableModel(lista.toArray(new Object[][] {}),
						new String[] { "Código", "Descrição", "Valor", "Situação" }));

				JScrollPane scrollPane = new JScrollPane(listarTabela);
				frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
				frame.setSize(720, 380);
				frame.setVisible(true);
				
			}

		});

		contentPane.add(comboBox);

	}

}
