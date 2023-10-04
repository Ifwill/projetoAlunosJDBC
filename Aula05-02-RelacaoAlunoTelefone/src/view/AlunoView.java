package view;

import java.util.List;
import java.util.Scanner;

import model.Aluno;
import model.AlunoTelefone;

public class AlunoView {
	Scanner scanner;
	
	public AlunoView() {
		scanner = new Scanner(System.in);
	}
    
    // Metodo para exibir os detalhes de um aluno, incluindo seus telefones
    public void exibeAluno(Aluno aluno) {
        if (aluno != null) {
            System.out.println("Detalhes do Aluno:");
            System.out.println();
            System.out.println("ID: " + aluno.getIdAluno());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Idade: " + aluno.getIdade());
            
            List<AlunoTelefone> telefones = aluno.getTelefones();
            if (telefones != null && !telefones.isEmpty()) {
                System.out.println("Telefones:");
                for (AlunoTelefone telefone : telefones) {
                    System.out.println("   - " + telefone.getTelefone());
                }
            } else {
                System.out.println("O aluno nao possui telefones cadastrados.");
                System.out.println();
            }
        } else {
            System.out.println("Aluno não encontrado.");
            System.out.println();
        }
    }
    
    // Metodo para listar os alunos com ID, Nome e Idade
    public void listaAlunos(List<Aluno> alunos) {
        if (alunos != null && !alunos.isEmpty()) {
            System.out.println("Lista de Alunos:");
            System.out.println();
            for (Aluno aluno : alunos) {
                System.out.println("ID: " + aluno.getIdAluno() + ", Nome: " + aluno.getNome() + ", Idade: " + aluno.getIdade());
                System.out.println();
            }
        } else {
            System.out.println("Nenhum aluno cadastrado.");
        }
    }
    
    
    public int setIdAluno() {
    	System.out.println("Informe o id do aluno:");
    	return scanner.nextInt(); 
    }
    
    public String setNome() {
    	System.out.println("Nome aluno:");
    	scanner.nextLine();
    	return scanner.nextLine();
    }
    
    public int setIdade() {
    	System.out.println("Informe a idade do aluno:");
    	return scanner.nextInt(); 
    }
    
    public int setIdTelefone() {
    	System.out.println("Informe o id do Telefone:");
    	return scanner.nextInt();
    }
    
    public String setTelefone() {
    	System.out.println("Informe o telefone:");
    	scanner.nextLine();
    	return scanner.nextLine();
    }
    
}
