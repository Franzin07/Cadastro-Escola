package com.java.sga.dao;

import java.io.*;
import java.util.*;

import com.java.sga.model.Professor;
//funciona da mesma forma que o AlunoDAO, mas com os dados do professor
public class ProfessorDAO {

    // Nome do arquivo onde os dados dos professores serão salvos
    private static final String ARQUIVO_PROFESSORES = "professores.csv";

    /**
     * Salva um professor no arquivo 'professores.csv'.
     * Cada professor é salvo numa linha, com os dados separados por vírgula.
     * @param professor objeto do tipo Professor que queremos salvar
     */
    public static void salvarProfessor(Professor professor) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_PROFESSORES, true))) {
            // Monta a linha com os dados do professor separados por vírgula
            String linha = professor.getNome() + "," + professor.getCPF() + "," +  // Nome, RA, Disciplina e Lista de Turmas
            //botei getRA pq da na mesma funcao q a matricula,ja q nao tem getMatricula

            professor.getDisciplina() + "," + professor.getListaTurmas();
            bw.write(linha);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("|INFO : | Erro ao salvar professor: " + e.getMessage());
        }
    }

    /**
     * Lê o arquivo 'professores.csv' e cria uma lista com todos os professores salvos.
     * @return uma lista com objetos Professor lidos do arquivo
     */
    public static List<Professor> carregarProfessores() {
        List<Professor> professores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_PROFESSORES))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Separa a linha em pedaços divididos por vírgula
                String[] campos = linha.split(",");
                if (campos.length == 4) {
                    // Cria um novo professor usando os dados lidos
                    Professor professor = new Professor(campos[2], campos[3], campos[0], campos[1]);
                    professores.add(professor);
                }
            }
        } catch (IOException e) {
            System.out.println("| ERRO | Arquivo de professores não encontrado ou erro ao carregar.");
        }
        return professores;
    }
}
