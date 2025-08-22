package com.java.sga.model;

/**
 * Essa classe representa um aluno.
 * Ela guarda as notas que o aluno tem e a turma em que ele está.
 * Também herda o nome e a matrícula (registro) da classe Pessoa.
 */
public class Aluno extends Pessoa {
    private String listaNotas;
    private String turma;    

    /**
     * Cria um novo aluno com as notas, turma, nome e matrícula.
     * 
     * @param listaNotas As notas do aluno (não pode ser vazio)
     * @param turma      A turma em que o aluno está (não pode ser vazio)
     * @param nome       O nome do aluno
     * @param cpf         A matrícula (registro) do aluno
     * 
     * @throws IllegalArgumentException se listaNotas ou turma estiverem vazios, esse throws ja informa que a funcao pode executar  com erro ai caso de o erro a gente usa essa funcao
     */

    //Construtor do aluno
    public Aluno(String listaNotas, String turma, String nome, String cpf) {
        super(nome, cpf); // Isso chama a classe Pessoa para guardar nome e matrícula, ele herda o nome cpf da classe pessoa

        if (listaNotas == null || listaNotas.isEmpty()) {// verifica se a lista de notas é nula ou vazia
            throw new IllegalArgumentException("As notas do aluno não podem ficar vazias.");
        }
        if (turma == null || turma.isEmpty()) {// verifica se a turma é nula ou vazia
            throw new IllegalArgumentException("A turma do aluno não pode ficar vazia.");
        }
        //caso nao for ele seta as variaveis normalmente
        this.listaNotas = listaNotas;
        this.turma = turma;
    }

    // ================= GETTERS =================
    public String getListaNotas() {
        return listaNotas;// retorna a lista de notas do aluno
    }

    public String getTurma() {
        return turma;// retorna a turma do aluno
    }

    public int setListaNotas(String listaNotas) {
        this.listaNotas = listaNotas;// seta a lista de notas do aluno
        return 0;   
    }
    @Override//sobrescrita 
    /***
     * Sem sobrescrever toString(), quando você imprimir um objeto, vai aparecer algo tipo Classe@códigoHexadecimal, que não é legível nem útil.
    Com toString() personalizado, você vê informações claras sobre o conteúdo do objeto, o que facilita muito entender o que está acontecendo no seu programa.
     */
    public String toString() {
    return "Aluno nome=" + getNome() + ", CPF=" + getCPF() + ", notas=" + listaNotas + ", turma=" + turma + " ";
    }

}