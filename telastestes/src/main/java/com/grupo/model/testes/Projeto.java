package com.grupo.model.testes;

import java.util.ArrayList;

public class Projeto {
    private static int id_count = 0;
    private int idProjeto;
    private String descricao;
    private ArrayList<PlanoDeTeste> planos;
    private float completude;
    
    public Projeto(String descricao, ArrayList<PlanoDeTeste> planos) {
        this.idProjeto = Projeto.id_count + 1;
        Projeto.id_count ++;
        this.descricao = descricao;
        this.planos = planos;
        this.completude = 0;
    }
    
    //public void atualizaCompletude() {}
}
