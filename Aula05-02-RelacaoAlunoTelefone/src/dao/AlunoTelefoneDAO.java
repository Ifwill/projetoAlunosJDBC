package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.AlunoTelefone;

public class AlunoTelefoneDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/banco_aluno";
	private static final String USUARIO = "root";
	private static final String SENHA = "aluno";
	private Connection connection;

	// Metodo para abrir uma conexão com o banco de dados
	public boolean abreConexao() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(URL, USUARIO, SENHA);

			if (connection != null) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	// Método para fechar a conexão com o banco de dados
	public void fechaConexao() throws SQLException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// Lida com erros de fechamento da conexão
				e.printStackTrace();
			}
		}
	}

	// Metodo para inserir um telefone associado a um aluno
	public void inserirTelefone(Aluno aluno, AlunoTelefone alunoTelefone) {
		if (abreConexao()) {
			try (Connection c = DriverManager.getConnection(URL, USUARIO, SENHA)) {
				String sql = "INSERT INTO aluno_telefone(id_telefone,id_aluno,telefone) VALUES(?,?,?)";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, alunoTelefone.getIdTelefone());
				ps.setInt(2, aluno.getIdAluno());
				ps.setString(3, alunoTelefone.getTelefone());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Método para buscar todos os telefones de um aluno por seu ID
	public List<AlunoTelefone> buscaTelefonesPorAluno(int idAluno) throws SQLException {
		List<AlunoTelefone> telefones = new ArrayList<>();

		return telefones;
	}

	// Método para atualizar os telefones de um aluno
	public void atualizaTelefones(int idAluno, List<String> novosTelefones) throws SQLException {

	}

	// Método para excluir os telefones de um aluno
	public void excluiTelefones(int idAluno) throws SQLException {

	}

	// Outros métodos conforme necessário para sua aplicação
}
