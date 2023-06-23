package com.grupo.model.usuarios;

import java.util.ArrayList;

public class Equipe {
    private ArrayList<Integer> membros;
    private ArrayList<Integer> projetos;
    
    private int idEquipe;
    private static int id_count = 0;
    
    public Equipe() {
        membros  = new ArrayList<>();
        projetos = new ArrayList<>();
        this.idEquipe = Equipe.id_count + 1;
        Equipe.id_count ++;
    }
    
    public int getIdEquipe() {return this.idEquipe;}
    
    
    public void addMembro(int usuarioId) {
        //if (VERIFICA_SE_EXISTE_USUARIO)
        this.membros.add(usuarioId);
    }
    
    public void rmvMembro(int usuarioId) {
        for (int userId : this.membros) {
            if (userId == usuarioId) {
                this.membros.remove(this.membros.indexOf(userId));
            }
        }
    }
    
    public void addProjeto(int projetoId) {
        //if (VERIFICA_SE_EXISTE_PROJETO)
        this.projetos.add(projetoId);
    }
    
    public void rmvProjeto(int projetoId) {
        for (int projId : this.projetos) {
            if (projId == projetoId) {
                this.membros.remove(this.membros.indexOf(projId));
            }
        }
    }
    
    public void desfazerEquipe() {
        for (int userId : this.membros) {
            this.membros.remove(this.membros.indexOf(userId));
            
        }
        
        for (int projId : this.projetos) {
            this.membros.remove(this.membros.indexOf(projId));
            
        }
    }
    
}
