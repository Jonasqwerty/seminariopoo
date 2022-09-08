package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import control.dao.ClasseDAO;
import model.Produto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MenuPrincipal {

	private JFrame frmMenuPrincipal;
	private JTable tbDados;
	private JTextField txtDeletar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setResizable(false);
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.getContentPane().setBackground(Color.DARK_GRAY);
		frmMenuPrincipal.setBounds(100, 100, 622, 319);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lbl2 = new JLabel("Escolha o que deseja fazer:");
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JButton btnCadastrar = new JButton("Cadastrar Instrumento");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(new Color(0, 204, 51));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroInstrumento cadastro = new TelaCadastroInstrumento();
				cadastro.main(null);
				
			}
		});
		
		JButton btnDeletar = new JButton("Deletar Instrumento");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setBackground(new Color(204, 51, 51));
		
		JButton btnListar = new JButton("Listar Instrumentos");
		btnListar.setForeground(Color.BLACK);
		btnListar.setBackground(Color.WHITE);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					ClasseDAO classeDao = new ClasseDAO();
					
					List<Produto> list;
					list = classeDao.listar();
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					
					modelo.setNumRows(0);
				
					for(Produto produto:list) {
						Object[] dados = {
								produto.getId(), produto.getTipo(), produto.getDescricao(), produto.getPreco()};
								modelo.addRow(dados);
						}
					}catch(SQLException e1) {
						e1.printStackTrace();
					}

			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtDeletar = new JTextField();
		txtDeletar.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmMenuPrincipal.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lbl2, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
					.addGap(309))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addGap(18)
							.addComponent(btnDeletar)
							.addGap(18)
							.addComponent(btnListar)))
					.addContainerGap(99, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(254)
					.addComponent(txtDeletar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(266, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnDeletar)
						.addComponent(btnListar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDeletar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		
		tbDados = new JTable();
		tbDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "Tipo", "Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tbDados);
		frmMenuPrincipal.getContentPane().setLayout(groupLayout);
		
	}
}
