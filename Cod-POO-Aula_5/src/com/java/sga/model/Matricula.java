package com.java.sga.model;

/**
 * Representa uma matrícula, contendo preço e período (ano de início e fim).
 * 
 * Esta classe garante que:
 * - O preço seja maior que zero.
 * - O ano de fim não seja anterior ao ano de início.
 */
public class Matricula {
    private double preco;     // Valor da matrícula
    private int anoComeco;    // Ano em que a matrícula começa
    private int anoFim;       // Ano em que a matrícula termina

    /**
     * Construtor da classe Matricula.
     * 
     * @param preco      Preço da matrícula (deve ser > 0) // esse param ajuda pra ja definir como vai funcionar cada coisa ex: //@param mesesdoano deve ser menor que 12
     * @param anoComeco  Ano de início
     * @param anoFim     Ano de fim (não pode ser menor que anoComeco)
     * @throws IllegalArgumentException Se os valores forem inválidos
     */
    public Matricula(double preco, int anoComeco, int anoFim) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        // Verifica se o ano de início é válido
        if (anoComeco < 0) {
            throw new IllegalArgumentException("Ano de início não pode ser negativo.");
        }
        if (anoFim < anoComeco) {
            throw new IllegalArgumentException("Ano de fim não pode ser menor que ano de início.");
        }

        this.preco = preco;
        this.anoComeco = anoComeco;
        this.anoFim = anoFim;
    }

    public double getPreco() {
        return preco;// retorna o preço da matrícula
    }
    public int getAnoComeco() {
        return anoComeco;// retorna o ano de início da matrícula
    }
    public int getAnoFim() {
        return anoFim;// retorna o ano de fim da matrícula
    }

    /**
     * Define o preço da matrícula.
     * 
     * @param preco Novo preço (deve ser > 0).
     * @throws IllegalArgumentException Se o preço for menor ou igual a zero.
     */
    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        this.preco = preco;//caso o preco seja maior que zero ele seta o valor da variavel
    }

    /**
     * Define o ano de início da matrícula.
     * 
     * @param anoComeco Novo ano de início.
     * @throws IllegalArgumentException Se o ano de início for maior que o ano de fim (caso já definido).
     */
    public void setAnoComeco(int anoComeco) {
        if (anoFim != 0 && anoComeco > anoFim) {
            throw new IllegalArgumentException("Ano de início não pode ser maior que ano de fim.");
        }
        this.anoComeco = anoComeco;// seta o ano de início da matrícula mesma coisa igual do setPreco
    }

    /**
     * Define o ano de fim da matrícula.
     * 
     * @param anoFim Novo ano de fim.
     * @throws IllegalArgumentException Se o ano de fim for menor que o ano de início.
     */
    public void setAnoFim(int anoFim) {
        if (anoFim < anoComeco) {
            throw new IllegalArgumentException("Ano de fim não pode ser menor que ano de início.");
        }
        this.anoFim = anoFim;// seta o ano de fim da matrícula mesma coisa igual do setPreco e setAnoComeco
    }

    @Override
    public String toString() {
        return "Matricula " +
                "preco=" + preco +
                ", anoComeco=" + anoComeco +
                ", anoFim=" + anoFim +
                ' '; // Retorna uma representação em String da matrícula, incluindo preço, ano de início e fim
    }
}
