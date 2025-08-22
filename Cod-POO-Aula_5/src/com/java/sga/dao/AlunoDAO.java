package com.java.sga.dao;

import java.io.*;
import java.util.*;

import com.java.sga.model.Aluno;

public class AlunoDAO {

    // Nome do arquivo onde os dados dos alunos serão salvos e lidos
    private static final String ARQUIVO_ALUNOS = "alunos.csv";

    /**
     * Salva um aluno no arquivo 'alunos.csv'.
     * Cada aluno é salvo numa linha, com os dados separados por vírgula.
     * @param aluno objeto do tipo Aluno que queremos salvar
     */
    public static void salvarAluno(Aluno aluno) {
        // Tenta abrir o arquivo para escrita, adicionando no final (append = true)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_ALUNOS, true))) {
            // Monta a linha com os dados do aluno, separados por vírgula
            String linha = aluno.getNome() + "," + aluno.getCPF() + "," + aluno.getListaNotas() + "," + aluno.getTurma();
            // Escreve a linha no arquivo
            bw.write(linha);
            // Pula para a próxima linha para o próximo aluno
            bw.newLine();
        } catch (IOException e) {
            // Se der erro ao salvar, mostra mensagem na tela
            System.out.println("| INFO | Erro ao salvar aluno: " + e.getMessage());
        }
    }

    /**
     * Lê o arquivo 'alunos.csv' e cria uma lista com todos os alunos salvos.
     * @return uma lista com objetos Aluno lidos do arquivo
     */
    public static List<Aluno> carregarAlunos() {
        // Cria uma lista vazia para colocar os alunos que vamos ler
        List<Aluno> alunos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_ALUNOS))) {
            String linha;
            // Enquanto tiver linha para ler no arquivo
            while ((linha = br.readLine()) != null) {
                // Separa a linha em pedaços divididos por vírgula
                String[] campos = linha.split(",");
                // Se a linha tiver exatamente 4 pedaços (nome, ra, notas, turma)
                if (campos.length == 4) {
                    // Cria um novo aluno usando os dados lidos
                    Aluno aluno = new Aluno(campos[2], campos[3], campos[0], campos[1]);
                    // Adiciona o aluno na lista
                    alunos.add(aluno);
                }
            }
        } catch (IOException e) {
            // Se não encontrar o arquivo ou der erro na leitura, mostra mensagem
            System.out.println("| ERRO | Arquivo de alunos não encontrado ou erro ao carregar.");
        }
        // Retorna a lista com os alunos que foram carregados do arquivo
        return alunos;
    }
}


//Em Java, o padrão Data Access Object (DAO) serve para separar a lógica de acesso aos dados da lógica de negócios da aplicação. Ele atua como uma camada de abstração que permite que a aplicação interaja com diferentes fontes de dados (como bancos de dados, arquivos, etc.) sem precisar conhecer os detalhes de implementação de cada uma.