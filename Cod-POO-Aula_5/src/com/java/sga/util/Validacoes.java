package com.java.sga.util;

import com.java.sga.util.Validacoes;


public class Validacoes {

    // Construtor privado para evitar que alguém crie objetos dessa classe utilizando encapsulamento
    private Validacoes() {}

   
    public static boolean isNomeValido(String nome) { /**
        * Verifica se o nome é válido.
        * Nome é válido se não for null e não estiver vazio (após tirar espaços).
        */
        return nome != null && !nome.trim().isEmpty(); //esse trim() meio que corta espaços inúteis no começo e no fim da string
        //e ajuda a fazer validações mais corretas e evitar erros por causa de espaços em branco
    }

    /**
     * Verifica se a matrícula é válida.
     * Válida se não for null e não estiver vazia (após tirar espaços).
     */
    public static boolean isMatriculaValida(String matricula) {
        return matricula != null && !matricula.trim().isEmpty();
    }

    /**
     * Verifica se a disciplina é válida.
     * Válida se não for null e não estiver vazia (após tirar espaços).
     */
    public static boolean isDisciplinaValida(String disciplina) {
        return disciplina != null && !disciplina.trim().isEmpty();
    }

    /**
     * Verifica se a turma é válida.
     * Válida se não for null e não estiver vazia (após tirar espaços).
     */
    public static boolean isTurmaValida(String turma) {
        return turma != null && !turma.trim().isEmpty();
    }

    /**
     * Verifica se uma nota é válida.
     * Válida se estiver entre 0 e 10 (inclusive).
     */
    public static boolean isNotaValida(double nota) {
        return nota >= 0 && nota <= 10;
    }

    /**
     * Verifica se um objeto é válido (não é null).
     */
    public static boolean isObjetoValido(Object obj) {
        return obj != null;
    }
}
