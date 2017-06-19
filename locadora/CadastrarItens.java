package locadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastrarItens extends JFrame {

	private Singleton singleton = Singleton.getInstance();
	private JPanel contentPane;
	private JTextField textFieldDes;
	private JTextField textFieldValor;
	private JTextField textFieldData;

	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarItens frame = new CadastrarItens();
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
	public CadastrarItens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 43, 71, 14);
		contentPane.add(lblDescrio);
		
		textFieldDes = new JTextField();
		textFieldDes.setBounds(111, 43, 237, 20);
		contentPane.add(textFieldDes);
		textFieldDes.setColumns(10);
		
		JLabel lblDataDaCompra = new JLabel("Data da Compra:");
		lblDataDaCompra.setBounds(10, 94, 91, 14);
		contentPane.add(lblDataDaCompra);
		
		JLabel lblValorDoItem = new JLabel("Valor do Item:");
		lblValorDoItem.setBounds(10, 141, 80, 14);
		contentPane.add(lblValorDoItem);
		
		JLabel lblTipoDeMidia = new JLabel("Tipo de Midia:");
		lblTipoDeMidia.setBounds(10, 188, 91, 14);
		contentPane.add(lblTipoDeMidia);
		
		JComboBox comboBox = new JComboBox();		
		comboBox.setBounds(111, 185, 121, 20);
		comboBox.addItem(" ");
		for (Midia tipo : singleton.getTiposDeMidia()) {
			comboBox.addItem(tipo.getMidia());
		}
		
		contentPane.add(comboBox);
		
		
		MaskFormatter mascara = null;
		
		try {
			mascara = new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		textFieldData = new JFormattedTextField(mascara);
		textFieldData.setBounds(111, 91, 237, 20);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String descricao = textFieldDes.getText();
				double valor = Double.parseDouble(textFieldValor.getText());
				String date = textFieldData.getText();
				String midia = comboBox.getSelectedItem().toString();
				
				Itens item = new Itens(descricao, valor, date, midia);
				
				try {
					singleton.cadastrarItens(item);
					textFieldDes.setText(null);
					textFieldData.setText(null);
					textFieldValor.setText(null);
					comboBox.setSelectedItem(" ");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSalvar.setBounds(61, 227, 89, 23);
		contentPane.add(btnSalvar);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(111, 138, 237, 20);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu().setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(227, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		
		
		
		
	}
}
