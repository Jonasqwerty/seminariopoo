package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import control.connectionjdbc.SingleConnection;
import model.Pessoa;
import model.Produto;

public class ClasseDAO {
	private Connection connection;
	
	public ClasseDAO() {
		connection = SingleConnection.getConnetion();
	}
	
	public boolean buscarPessoa(String email, String senha) throws Exception {
		String sql = "SELECT email, senha FROM pessoa p WHERE p.email = ? AND p.senha = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, email);
		statement.setString(2, senha);
		
		ResultSet resultado = statement.executeQuery();
		
		String emailBanco = "";
		String senhaBanco = "";
		while (resultado.next()) {
			emailBanco = resultado.getString("email");
			senhaBanco = resultado.getString("senha");

		}
		if(emailBanco.equals(emailBanco) && senhaBanco.equals(senhaBanco)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void salvarPessoa(Pessoa pessoa) {
		try {
			String sql = "INSERT INTO pessoa(email, nome, sobrenome, senha) VALUES (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, pessoa.getEmail());
			statement.setString(2, pessoa.getNome());
			statement.setString(3, pessoa.getSobrenome());
			statement.setString(4, pessoa.getSenha());

			statement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void salvarProduto(Produto instrumento) {
		try {
			String sql = "INSERT INTO instrumento(tipo, descricao, preco) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, instrumento.getTipo());
			statement.setString(2, instrumento.getDescricao());
			statement.setFloat(3, instrumento.getPreco());
			
			statement.execute();
			connection.commit();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<Produto> listar() throws SQLException{
		List<Produto> list = new ArrayList<Produto>();
		
		String sql = "SELECT * FROM instrumento";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		try {

		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			Produto produto = new Produto();
			
			produto.setId(resultado.getInt("id"));
			produto.setTipo(resultado.getString("tipo"));
			produto.setDescricao(resultado.getString("descricao"));
			produto.setPreco(resultado.getFloat("preco"));
			list.add(produto);
		}
		
		}catch (SQLException e){
			e.printStackTrace();
		}
		return list;
		
	}
	
	/*public void atualizar(Produto produto) {
		try {
			String sql = "UPDATE instrumento SET tipo = ?, descricao = ?, preco = ? WHERE id = "+produto.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, produto.getTipo());
			statement.setString(2, produto.getDescricao());
			statement.setFloat(3, (float) produto.getPreco());
			statement.setInt(4, produto.getId());

			statement.executeUpdate();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e);
			try {
				connection.rollback();
			} catch (SQLException e1) { 
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}*/
	
	public void deletar(Produto produto) {
		try {
			String sql = "DELETE FROM instrumento WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, produto.getId());
			
			statement.execute();
			connection.commit();
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
	}
}