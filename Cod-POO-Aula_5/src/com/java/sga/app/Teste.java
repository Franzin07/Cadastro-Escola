package com.java.sga.app;

import com.java.sga.model.Aluno;
import com.java.sga.model.Professor;
import com.java.sga.util.Validacoes;

public class Teste {
    public static void main(String[] args) {
        System.out.println("=============  [ Sistema de Gestão Acadêmica ] ============  Teste Inicial ===\n"); 

        testarValidacoes();
        testarModelos();
    }
    
    // Método para testar as funções de validação de dados
    private static void testarValidacoes() {
        System.out.println("--- Testando Validações ---");
        
        System.out.println("Nome válido? " + Validacoes.isNomeValido("João Silva"));
        System.out.println("Nome inválido (null)? " + Validacoes.isNomeValido(null));
        System.out.println("Nome inválido (vazio)? " + Validacoes.isNomeValido(""));
        
        System.out.println("Matrícula válida? " + Validacoes.isMatriculaValida("2023001"));
        System.out.println("Matrícula inválida (null)? " + Validacoes.isMatriculaValida(null));
        
        System.out.println("Disciplina válida? " + Validacoes.isDisciplinaValida("Programação Orientada a Objetos"));
        System.out.println("Disciplina inválida (vazia)? " + Validacoes.isDisciplinaValida("   "));
        
        System.out.println("Turma válida? " + Validacoes.isTurmaValida("Turma A"));
        System.out.println("Turma inválida (null)? " + Validacoes.isTurmaValida(null));
        
        System.out.println("Nota válida (8.5)? " + Validacoes.isNotaValida(8.5));
        System.out.println("Nota inválida (-1)? " + Validacoes.isNotaValida(-1));
        System.out.println("Nota inválida (11)? " + Validacoes.isNotaValida(11));
        
        System.out.println("Objeto válido? " + Validacoes.isObjetoValido("Teste"));
        System.out.println("Objeto inválido (null)? " + Validacoes.isObjetoValido(null));
        
        System.out.println();
    }
    
    // Método para criar objetos e testar suas funções
    private static void testarModelos() {
        System.out.println("--- Testando Modelos ---");
        
        // Criando um aluno
        System.out.println("Criando aluno...");
        // Atenção: a ordem dos argumentos deve bater com o construtor da classe Aluno!
        Aluno aluno1 = new Aluno("8.5, 9.0, 7.5", "Turma A", "Maria Santos", "2023001");
        System.out.println("Aluno criado: " + aluno1);
        
        // Mostrando dados do aluno
        System.out.println("Nome: " + aluno1.getNome());
        System.out.println("Matrícula: " + aluno1.getCPF());
        System.out.println("Notas: " + aluno1.getListaNotas());
        System.out.println("Turma: " + aluno1.getTurma());
        
        // Alterando dados do aluno
        aluno1.setNome("Maria Silva Santos");
        aluno1.setListaNotas("8.5, 9.0, 7.5, 8.0");
        System.out.println("Aluno após modificação: " + aluno1);
        
        // Criando um professor
        System.out.println("\nCriando professor...");
        // Ajuste a ordem de argumentos para corresponder ao construtor de Professor
        Professor professor1 = new Professor("Programação Orientada a Objetos", "Turma A, Turma B", "Dr. Carlos Oliveira", "PROF001");
        System.out.println("Professor criado: " + professor1);
        
        // Mostrando dados do professor
        System.out.println("Nome: " + professor1.getNome());
        System.out.println("Matrícula: " + professor1.getCPF());
        System.out.println("Disciplina: " + professor1.getDisciplina());
        System.out.println("Turmas: " + professor1.getListaTurmas());
        
        // Alterando dados do professor
        professor1.setDisciplina("POO Avançado");
        professor1.setListaTurmas("Turma A, Turma B, Turma C");
        System.out.println("Professor após modificação: " + professor1);
        
        // Testando igualdade e hashcode
        System.out.println("\nTestando equals e hashCode...");
        
        Aluno aluno2 = new Aluno("8.5, 9.0, 7.5, 8.0", "Turma A", "Maria Silva Santos", "2023001");
        System.out.println("Aluno1 equals Aluno2? " + aluno1.equals(aluno2));
        System.out.println("HashCode Aluno1: " + aluno1.hashCode());
        System.out.println("HashCode Aluno2: " + aluno2.hashCode());
        
        Professor professor2 = new Professor("POO Avançado", "Turma A, Turma B, Turma C", "Dr. Carlos Oliveira", "PROF001");
        System.out.println("Professor1 equals Professor2? " + professor1.equals(professor2));
        System.out.println("HashCode Professor1: " + professor1.hashCode());
        System.out.println("HashCode Professor2: " + professor2.hashCode());
        
        System.out.println("\n=== Testes concluídos com sucesso! ===");
    }
}
