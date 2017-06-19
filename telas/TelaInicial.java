package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;


import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;

public class TelaInicial extends JFrame {
	private JTextField userTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					
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
	public TelaInicial() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 380);
		getContentPane().setLayout(null);
		
		
		
		
		JLabel labelUser = new JLabel("Usu\u00E1rio:");
		labelUser.setBounds(35, 74, 66, 14);
		getContentPane().add(labelUser);
		
		userTextField = new JTextField();
		userTextField.setColumns(10);
		userTextField.setBounds(34, 99, 314, 20);
		getContentPane().add(userTextField);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(35, 145, 46, 14);
		getContentPane().add(labelSenha);
		
		JButton buttonEntrar = new JButton("Entrar");
		buttonEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String strPass = new String(passwordField.getPassword()).trim();
				
				if(userTextField.getText().equals("admin") && strPass.equals("admin") ){
					
					new Administracao().setVisible(true);
					dispose();
									
				}else{
					JOptionPane.showMessageDialog(null, "Combinação Inválida", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonEntrar.setBounds(116, 282, 130, 23);
		getContentPane().add(buttonEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(35, 171, 313, 20);
		getContentPane().add(passwordField);
		
		JButton buttonRecovery = new JButton("Recuperar Senha");
		buttonRecovery.setBounds(218, 221, 130, 23);
		getContentPane().add(buttonRecovery);
		
		JLabel labelRazao = new JLabel("ESCOLA JAVA\r\n");
		labelRazao.setOpaque(true);
		labelRazao.setHorizontalAlignment(SwingConstants.CENTER);
		labelRazao.setForeground(Color.BLACK);
		labelRazao.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelRazao.setBackground(Color.GREEN);
		labelRazao.setBounds(10, 11, 651, 20);
		getContentPane().add(labelRazao);
		
		JLabel labelImagem = new JLabel("");
		labelImagem.setIcon(new ImageIcon(TelaInicial.class.getResource("/imagens/login.png")));
		labelImagem.setBounds(371, 42, 290, 276);
		getContentPane().add(labelImagem);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(35, 221, 106, 23);
		getContentPane().add(btnCadastrar);
	}
}
