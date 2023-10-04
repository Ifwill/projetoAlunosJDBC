package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/banco_aluno";
	private static final String USUARIO = "root";
	private static final String SENHA = "aluno";
	private Connection connection;

	public AlunoDAO() {

	}

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
	public void fechaConexao() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// Lida com erros de fechamento da conexão
				e.printStackTrace();
			}
		}
	}

	// Metodo para inserir um aluno no banco de dados
	public void inserirAluno(Aluno aluno) {
		if (abreConexao()) {
			try (Connection c = DriverManager.getConnection(URL, USUARIO, SENHA)) {
				String sql = "INSERT INTO aluno(id_aluno,nome,idade) VALUES(?,?,?)";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, aluno.getIdAluno());
				ps.setString(2, aluno.getNome());
				ps.setInt(3, aluno.getIdade());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Aluno> exibir() {
		ArrayList<Aluno> alunos = new ArrayList<>();
		if (abreConexao()) {
			try {
				String sql = "SELECT * FROM aluno;";
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id_aluno");
					String nome = rs.getString("nome");
					int idade = rs.getInt("idade");
					Aluno lista = new Aluno(id, nome, idade);
					alunos.add(lista);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alunos;
	}

	public Aluno exibirAluno(int id) {
		Aluno aluno = null;
		if (abreConexao()) {
			String sql = "SELECT id_aluno,nome,idade FROM aluno WHERE id_aluno = ?;";
			try (PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.setInt(1, id);
				ResultSet resultado = ps.executeQuery();
				if (resultado.next()) {
					aluno = new Aluno(resultado.getInt(1), resultado.getString(2), resultado.getInt(3));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return aluno;
	}

	// Método para buscar um aluno pelo ID (id_aluno) no banco de dados
	public Aluno buscarAlunoPorId(int id) throws SQLException {

		return null;
	}

	// Método para atualizar os dados de um aluno no banco de dados
	public boolean atualizarAluno(Aluno aluno) throws SQLException {

		return false;
	}

	// Método para excluir um aluno pelo ID (id_aluno) no banco de dados
	public boolean excluirAluno(int id) throws SQLException {

		return false;
	}

	// Método para listar todos os alunos no banco de dados
	public List<Aluno> listarAlunos() throws SQLException {
		List<Aluno> alunos = new ArrayList<>();

		return alunos;
	}
}
