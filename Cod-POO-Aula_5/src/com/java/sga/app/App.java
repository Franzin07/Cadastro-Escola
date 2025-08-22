package com.java.sga.app;

import com.java.sga.dao.*;
import com.java.sga.model.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();

    // carregar arquivo csv alunos
    static {/**
             * devemos usar o static pq é executado antes do main, assim ja carrega os
             * alunos e professores antes de executar o menu
             * evitando erros
             **/
        System.out.println("==========  [ Sistema de Gestão Acadêmica ] ==========  Carregando dados iniciais ===\n");
        alunos = AlunoDAO.carregarAlunos();
        System.out.println(alunos.size() + " | INFO : | Alunos carregados do arquivo alunos.csv com sucesso!\n");
    }

    // carregando o arquivo csv dos professores
    static {
        professores = ProfessorDAO.carregarProfessores();
        System.out.println(
                professores.size() + " | INFO : | Professores carregados do arquivo professores.csv com sucesso!\n");
    }

    static {
        funcionarios = FuncionarioDAO.carregarFuncionarios();
        System.out.println(
                funcionarios.size() + "| INFO : | Funcionários carregados do arquivo funcionarios.csv com sucesso!\n");
    }

    // carregar arquivo csv professores
    public static void main(String[] args4) {
        int opcao = 0;// serve pra definir de padrao que a opcao comeca em 0, ou seja,nenhuma

        do {
            System.out.println("============== Menu ==============");
            System.out.println("1 - Cadastrar Aluno"); // Opção 1: cadastrar um novo aluno
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Funcionario"); // Opção 2: cadastrar um novo professor
            System.out.println("4 - Listar Alunos"); // Opção 3: mostra todos os alunos cadastrados
            System.out.println("5 - Listar Professores");
            System.out.println("6 - Listar Funcionarios"); // Opção 4: mostra todos os professores cadastrados
            System.out.println("7 - Buscar Aluno por Matrícula"); // Opção 5: busca um aluno específico pela matrícula
                                                                  // (RA)
            System.out.println("8 - Sair"); // Opção 6: encerra o programa
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine()); // Lê a opção digitada pelo usuário e converte para inteiro

            switch (opcao) {
                case 1:
                    cadastrarAluno(); // Chama o método que cadastra um aluno novo
                    break;

                case 2:
                    cadastrarProfessor(); // Chama o método que cadastra um professor novo
                    break;

                case 3:
                    cadastrarFuncionario();
                    break;

                case 4:
                    listarAlunos(); // Exibe a lista de alunos cadastrados
                    break;

                case 5:
                    listarProfessores(); // Exibe a lista de professores cadastrados
                    break;
                case 6:
                    listarFuncionarios();
                    break;

                case 7:
                    buscarMatriculaAluno(); // Busca e mostra aluno com base na matrícula informada
                    break;

                case 8:
                    System.out.println("Saindo..."); // Mensagem de saída, o programa termina após essa opção
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente."); // Caso o usuário digite um número não
                                                                            // listado
                    break;
            }
        } while (opcao != 8); // Continua repetindo o menu enquanto a opção for diferente de 6 (sair) != 6);
    }

    // Método para cadastrar aluno
    private static void cadastrarAluno() {
        System.out.println("===========  [ Cadastro de Aluno ] =========== ");

        System.out.print("Insira o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Notas (ex: 8.5, 7.0, 9.0): ");
        String listaNotas = scanner.nextLine();

        System.out.print("Turma: ");
        String turma = scanner.nextLine();

        // Cria o aluno usando o construtor
        Aluno aluno = new Aluno(listaNotas, turma, nome, cpf);

        // Adiciona na lista
        alunos.add(aluno);

        // Salva no arquivo csv
        AlunoDAO.salvarAluno(aluno);
        System.out.println("| Cadastro :  | Aluno cadastrado com sucesso!\n");
        return;
    }

    // Método para cadastrar professor
    private static void cadastrarProfessor() {
        System.out.println("==== [ Cadastro de Professor ] ====");

        System.out.print("Insira o nome do professor: ");
        String nome = scanner.nextLine();

        System.out.print("Insira a disciplina que o professor ensina: ");
        String disciplina = scanner.nextLine();

        System.out.print("Insira a lista de turmas que o professor leciona/Ensina (ex: Turma A, Turma B): ");
        String listaTurmas = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        // Cria o professor usando o construtor
        Professor professor = new Professor(disciplina, listaTurmas, nome, cpf);
        // Adiciona na lista
        professores.add(professor);

        // salvar professor
        ProfessorDAO.salvarProfessor(professor);
        // Exibe mensagem de sucesso
        System.out.println("| Cadastro :  | Professor cadastrado com sucesso!\n");
        return;
    }

    // método para criar funcionario
    private static void cadastrarFuncionario() {
        System.out.println("==== [ Cadastro de Funcionario ] ====");

        System.out.print("Insira o nome do funcionario: ");
        String nome = scanner.nextLine();

        System.out.print("Insira o setor que o funcionario atua: ");
        String setor = scanner.nextLine();

        System.out.print("Insira o contrato: ");
        String contrato = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        // Cria o professor usando o construtor
        Funcionario funcionario = new Funcionario(setor, contrato, nome, cpf);
        // Adiciona na lista
        Funcionario.add(funcionario);

        // salvar professor
        FuncionarioDAO.salvarFuncionario(funcionario);
        // Exibe mensagem de sucesso
        System.out.println("| Cadastro :  | Funcionario cadastrado com sucesso!\n");
        return;

    }

    // Método para listar alunos
    private static void listarAlunos() {
        System.out.println("=========== [ Lista de Alunos ] =========== ");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno); // Chama o método toString() da classe Aluno pra evitar recriar as funcao dnv
            }
        }
        System.out.println(); // Linha em branco para melhor visualização
        return;

    }

    // Método para listar professores
    private static void listarProfessores() {
        System.out.println("=========== [ Lista de Professores ] =========== ");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        } else {
            for (Professor professor : professores) {
                System.out.println(professor); // Chama o método toString() da classe Professor
            }
        }
        System.out.println(); // Linha em branco para melhor visualização
        return;
    }

    private static void listarFuncionarios() {
        System.out.println("=========== [ Lista de Professores ] =========== ");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
            return;
        } else {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario); // Chama o método toString() da classe Professor
            }
        }
        System.out.println(); // Linha em branco para melhor visualização
        return;
    }

    // Método para buscar aluno pela matrícula (RA)
    private static void buscarMatriculaAluno() {
        System.out.println("===========  [ Buscar Aluno por Matrícula ] =========== ");
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno alunoEncontrado = null; // Variável para armazenar o aluno encontrado

        // Percorre a lista de alunos para encontrar o aluno com a matrícula informada
        for (Aluno aluno : alunos) {
            if (aluno.getCPF().equals(cpf)) {
                alunoEncontrado = aluno; // Se encontrar, armazena o aluno
                break; // Sai do loop se encontrar
            }
        }

        // Verifica se o aluno foi encontrado e exibe os dados
        if (alunoEncontrado != null) {
            System.out.println("Aluno encontrado ! : " + alunoEncontrado);
        } else {
            System.out.println("Nenhum aluno encontrado com a matrícula: " + cpf);
        }
        return;
    }

}
