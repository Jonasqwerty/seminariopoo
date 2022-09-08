package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import control.dao.ClasseDAO;
import model.Pessoa;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.Window.Type;

public class TelaInicial {

	private JFrame frmTelaInicial;
	private JTextField txtEmailLogin;
	private JPasswordField txtSenhaLogin;
	private JTextField txtNomeCadastro;
	private JTextField txtSobrenomeCadastro;
	private JTextField txtEmailCadastro;
	private JPasswordField txtSenhaCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frmTelaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaInicial = new JFrame();
		frmTelaInicial.setType(Type.UTILITY);
		frmTelaInicial.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmTelaInicial.setResizable(false);
		frmTelaInicial.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmTelaInicial.setTitle("Tela inicial");
		frmTelaInicial.setBounds(100, 100, 578, 223);
		
		JLabel lblFacaLogin = new JLabel("Fa\u00E7a login OU Crie uma nova conta!");
		lblFacaLogin.setForeground(Color.BLACK);
		lblFacaLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFacaLogin.setVerticalAlignment(SwingConstants.TOP);
		lblFacaLogin.setToolTipText("");
		
		JLabel lblEmailLogin = new JLabel("Email:");
		lblEmailLogin.setBackground(Color.LIGHT_GRAY);
		lblEmailLogin.setForeground(Color.BLACK);
		lblEmailLogin.setVerticalAlignment(SwingConstants.TOP);
		lblEmailLogin.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		
		JLabel lblSenhaLogin = new JLabel("Senha:");
		lblSenhaLogin.setForeground(Color.BLACK);
		lblSenhaLogin.setVerticalAlignment(SwingConstants.TOP);
		lblSenhaLogin.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		
		txtEmailLogin = new JTextField();
		txtEmailLogin.setColumns(10);
		
		txtSenhaLogin = new JPasswordField();
		txtSenhaLogin.setColumns(10);
		
		JLabel lblNomeCadastro = new JLabel("Nome:");
		lblNomeCadastro.setForeground(Color.BLACK);
		lblNomeCadastro.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		
		JLabel lblSobrenomeCadastro = new JLabel("Sobrenome:");
		lblSobrenomeCadastro.setForeground(Color.BLACK);
		lblSobrenomeCadastro.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		
		JLabel lblEmailCadastro = new JLabel("Email:");
		lblEmailCadastro.setForeground(Color.BLACK);
		lblEmailCadastro.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		
		JLabel lblSenhaCadastro = new JLabel("Senha:");
		lblSenhaCadastro.setForeground(Color.BLACK);
		lblSenhaCadastro.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		
		txtNomeCadastro = new JTextField();
		txtNomeCadastro.setColumns(10);
		
		txtSobrenomeCadastro = new JTextField();
		txtSobrenomeCadastro.setColumns(10);
		
		txtEmailCadastro = new JTextField();
		txtEmailCadastro.setColumns(10);
		
		txtSenhaCadastro = new JPasswordField();
		txtSenhaCadastro.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.main(null);
			}
		});
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.setBackground(Color.WHITE);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setForeground(Color.BLACK);
		btnCriar.setBackground(Color.WHITE);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = new Pessoa();
				ClasseDAO classeDao = new ClasseDAO();
				pessoa.setEmail(txtEmailCadastro.getText());
				pessoa.setNome(txtNomeCadastro.getText());
				pessoa.setSobrenome(txtSobrenomeCadastro.getText());
				pessoa.setSenha(txtSenhaCadastro.getText());
				classeDao.salvarPessoa(pessoa);
				
				txtNomeCadastro.setText(null);
				txtSobrenomeCadastro.setText(null);
				txtEmailCadastro.setText(null);
				txtSenhaCadastro.setText(null);
			}	
		});
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 99, 71));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmTelaInicial.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(lblFacaLogin, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
							.addGap(93)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEmailLogin, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
									.addGap(67))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(67)
									.addComponent(txtSenhaLogin, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSenhaLogin, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
									.addGap(67))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(67)
									.addComponent(txtEmailLogin, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(69)
									.addComponent(txtNomeCadastro, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(69)
									.addComponent(txtSenhaCadastro, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNomeCadastro, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
									.addGap(88))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(lblEmailCadastro, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
									.addGap(91))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(69)
									.addComponent(txtEmailCadastro, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblSenhaCadastro, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
									.addGap(72))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(separator, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
									.addGap(101)))
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSobrenomeCadastro, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
									.addGap(48))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(102)
									.addComponent(txtSobrenomeCadastro, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))))
					.addGap(4))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(165)
					.addComponent(btnCriar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblFacaLogin, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblEmailLogin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtSenhaLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSenhaLogin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(txtNomeCadastro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtSenhaCadastro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNomeCadastro, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addComponent(lblEmailCadastro, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(txtEmailCadastro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(txtEmailLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(lblSenhaCadastro, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(lblSobrenomeCadastro, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtSobrenomeCadastro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(btnCriar))
					.addGap(10))
		);
		frmTelaInicial.getContentPane().setLayout(groupLayout);
	}
}
