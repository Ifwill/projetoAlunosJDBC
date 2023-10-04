package main;

import java.util.Scanner;

import controller.AlunoController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoController alunoController = new AlunoController();

        while (true) {
            System.out.println("Escolha uma opcoes:");
            System.out.println("1 - Adicionar Aluno");
            System.out.println("2 - Adicionar Telefone");
            System.out.println("3 - Listar Alunos");
            System.out.println("4 - Exibir Aluno");
            System.out.println("5 - Atualizar Aluno");
            System.out.println("6 - Excluir Aluno");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha após a leitura do número

            switch (opcao) {
                case 1:
                    alunoController.adicionarAluno();
                    break;
                case 2:
                    alunoController.adicionarTelefone();
                    break;
                case 3:
                    alunoController.listarAlunos();;
                    break;
                case 4:
                    alunoController.exibirAluno();;
                    break;
                case 5:
                    // alunoController.atualizaAluno();
                    break;
                case 6:
                    // alunoController.excluiAluno();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

