package com.java.sga.dao;

import java.io.*;
import java.util.*;

import com.java.sga.model.Funcionario;
//funciona da mesma forma que o AlunoDAO, mas com os dados do funcionario
public class FuncionarioDAO {

    // Nome do arquivo onde os dados dos funcionarios serão salvos
    private static final String ARQUIVO_FUNCIONARIOS = "funcionarios.csv";

    /**
     * Salva um funcionario no arquivo 'funcionarios.csv'.
     * Cada funcionario é salvo numa linha, com os dados separados por vírgula.
     * @param funcionario objeto do tipo funcionario que queremos salvar
     */
    public static void salvarFuncionario(Funcionario funcionario) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_FUNCIONARIOS, true))) {
            // Monta a linha com os dados do funcionario separados por vírgula
            String linha = funcionario.getNome() + "," + funcionario.getCPF() + "," +  // Nome, RA, Disciplina e Lista de Turmas
            //botei getRA pq da na mesma funcao q a matricula,ja q nao tem getMatricula

            funcionario.getSetor() + "," + funcionario.getContrato();
            bw.write(linha);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("|INFO : | Erro ao salvar funcionario: " + e.getMessage());
        }
    }

    /**
     * Lê o arquivo 'funcionarios.csv' e cria uma lista com todos os funcionarios salvos.
     * @return uma lista com objetos funcionario lidos do arquivo
     */
    public static List<Funcionario> carregarFuncionarios() {
        List<Funcionario> funcionario = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_FUNCIONARIOS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Separa a linha em pedaços divididos por vírgula
                String[] campos = linha.split(",");
                if (campos.length == 4) {
                    // Cria um novo funcionario usando os dados lidos
                    Funcionario func = new Funcionario(campos[2], campos[3], campos[0], campos[1]);
                    Funcionario.add(func);
                }
            }
        } catch (IOException e) {
            System.out.println("| ERRO | Arquivo de funcionarios não encontrado ou erro ao carregar.");
        }
        return funcionario;
    }
}
