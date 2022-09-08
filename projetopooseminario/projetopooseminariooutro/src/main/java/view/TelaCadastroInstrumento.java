package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import control.dao.ClasseDAO;
import model.Produto;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TelaCadastroInstrumento {

	private JFrame frmCadastroDeInstrumento;
	private JTextField txtTipo;
	private JTextField txtDescricao;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroInstrumento window = new TelaCadastroInstrumento();
					window.frmCadastroDeInstrumento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroInstrumento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeInstrumento = new JFrame();
		frmCadastroDeInstrumento.setResizable(false);
		frmCadastroDeInstrumento.setTitle("Cadastro de Instrumento");
		frmCadastroDeInstrumento.setBounds(100, 100, 511, 294);
		frmCadastroDeInstrumento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Coloque o tipo de instrumento:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTipo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Preço:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPreco.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.setForeground(SystemColor.menu);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Produto produto = new Produto();
				ClasseDAO classeDao = new ClasseDAO();
				produto.setTipo(txtTipo.getText());
				produto.setDescricao(txtDescricao.getText());
				produto.setPreco(Integer.parseInt(txtPreco.getText()));
				classeDao.salvarProduto(produto);
				
				txtTipo.setText(null);
				txtDescricao.setText(null);
				txtPreco.setText(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.main(null);
				
			}
		});
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(220, 20, 60));
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeInstrumento.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(txtDescricao, 0, 0, Short.MAX_VALUE))
								.addComponent(lblNewLabel))
							.addGap(18)
							.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
					.addGap(101))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(210)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
					.addGap(216))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(421)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(21)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		frmCadastroDeInstrumento.getContentPane().setLayout(groupLayout);
	}
}
