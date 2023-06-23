package com.grupo.model.testes;

import java.util.ArrayList;

public class PlanoDeTeste {
    private static int id_count = 0;
    private int idPlano;
    private ArrayList<CasoDeTeste> casos;
    private String descricao;
    private Estado estado;
    
    public PlanoDeTeste() {
        this.idPlano = id_count + 1;
        PlanoDeTeste.id_count ++;
    }
    
    // Getters & Setters
    public int getIdPlano() {return this.idPlano;}
    public ArrayList<CasoDeTeste> getCasosDeTeste() {return this.casos;}
    public String getDescricao() {return this.descricao;}
    public Estado getEstado() {return this.estado;}
    
    public void setCasos(ArrayList<CasoDeTeste> casos) {this.casos = casos;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setEstado(Estado estado) {this.estado = estado;}
    
    //public String executar() {}
    //public Relatorio gerarRelatorioAndamento() {}
    //public Relatorio gerarRelatorioAcuracia() {}
}
