package com.java.sga.model;
// Define o pacote onde essa classe está localizada
// Pacotes ajudam a organizar o código em grupos de classes relacionadas


// Importa a classe Pessoa do pacote com.java.sga.model
public class Professor extends Pessoa {
    private String disciplina;   // Armazena o nome da disciplina lecionada pelo professor
    private String listaTurmas;    // Armazena uma lista (em String) das turmas que o professor leciona


    //Construtores
    public Professor(String disciplina, String listaTurmas, String nome,String cpf) { 
         /**
     * Construtor da classe Professor.
     * Recebe: disciplina, lista de turmas e nome do professor.
     * Usa 'super(nome)' para chamar o construtor da classe mãe (Pessoa).
     */
      
        super(nome); // Chama o construtor da classe Pessoa com o nome do professor

        if (disciplina != null) {
            this.disciplina = disciplina;
        }
        // Se a lista de turmas não for nula, atribui o valor à variável listaTurmas
        if (listaTurmas != null) {
            this.listaTurmas = listaTurmas;
        }
       
    }
     // ================= GETTERS =================
    /** Retorna a disciplina que o professor leciona */
    public String getDisciplina() { 
        return disciplina;
    }

    /** Retorna a lista de turmas do professor */
    public String getListaTurmas() {
        return listaTurmas;
    }

    // ================= SETTERS =================
    /** Define a disciplina do professor */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /** Define a lista de turmas do professor */
    public void setListaTurmas(String listaTurmas) {
        this.listaTurmas = listaTurmas;
    }

    @Override
    public String toString() {/**@Override ajuda a garantir que você está sobrescrevendo um método existente, evitando erros.
    o toString() é o método que define como seu objeto será mostrado em texto, e você geralmente sobrescreve para mostrar informações legais e úteis.
    ele retorna uma representação em String do objeto Professor, incluindo disciplina, lista de turmas, nome e matrícula (RA).
        mesma coisa serve pra classe Aluno**/

    return "Professor Disciplina=" + getDisciplina() + ", Turma=" + getListaTurmas() + ", Nome=" + getNome() + ", CPF=" + getCPF() + " ";
}//
}

