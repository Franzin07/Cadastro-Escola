package com.java.sga.model;


public class Funcionario extends Pessoa {
    private String setor;
    private String contrato;

    public Funcionario(String setor, String contrato, String ra, String nome){
        super(nome);

        if (setor != null) {
            this.setor = setor;
        }
        if (contrato != null) {
            this.contrato = contrato;
        }
    }

    public String getSetor() { 
        return setor;
    }

    public String getContrato() {
        return contrato;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {

    return "Funcionario setor=" + getSetor() + ", Contrato=" + getContrato() + ", Nome=" + getNome() + " ";
}//

    public static void add(Funcionario func) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
