package controller;

import java.util.ArrayList;

import dao.AlunoDAO;
import dao.AlunoTelefoneDAO;
import model.Aluno;
import model.AlunoTelefone;
import view.AlunoView;

public class AlunoController {
	private Aluno aluno;
	private AlunoView alunoView;
	private AlunoDAO alunoDAO;
	private AlunoTelefoneDAO alunoTelefoneDAO;

	public AlunoController() {
		alunoView = new AlunoView();
		alunoDAO = new AlunoDAO();
		alunoTelefoneDAO = new AlunoTelefoneDAO();
		aluno = new Aluno();
	}

	public void adicionarAluno() {
		int id = alunoView.setIdAluno();
		String nome = alunoView.setNome();
		int idade = alunoView.setIdade();
		Aluno aluno = new Aluno(id, nome, idade);
		alunoDAO.inserirAluno(aluno);
	}

	public void adicionarTelefone() {
		int id = alunoView.setIdAluno();
		int idTelefone = alunoView.setIdTelefone();
		String telefone = alunoView.setTelefone();
		Aluno aluno = new Aluno(id);
		AlunoTelefone alunoTele = new AlunoTelefone(idTelefone, aluno, telefone);
		alunoTelefoneDAO.inserirTelefone(aluno, alunoTele);
	}

	public void listarAlunos() {
		alunoView.listaAlunos(alunoDAO.exibir());
	}

	public void exibirAluno() {
		int id = alunoView.setIdAluno();
		alunoView.exibeAluno(alunoDAO.exibirAluno(id));

	}

}
