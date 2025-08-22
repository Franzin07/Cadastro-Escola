package com.java.sga.model;

public class Pessoa{
    protected String nome;
    protected String cpf;

    //Construtores
    protected Pessoa(String nome, String cpf) {
            if (nome != null) {
                this.nome = nome;
            }
            // Se o nome não for nulo, atribui o valor à variável nome mesma parada da classe professor
            if (cpf != null) {
                this.cpf = cpf;
            }
    }
    // Construtor que recebe só o nome (útil para super(nome) em Professor) para evitar erros ja
    protected Pessoa(String nome) {
        this(nome, null); // chama o outro construtor
    }


    // Getters
    public String getNome() {
    return nome;}

    public String getCPF() {
        return cpf;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
}
