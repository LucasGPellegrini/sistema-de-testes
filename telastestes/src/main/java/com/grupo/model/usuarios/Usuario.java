package com.grupo.model.usuarios;

import java.util.ArrayList;

public class Usuario extends Cliente{
    
    private TipoUsuario tipo;
    private ArrayList<Integer> projetos;
    
    public Usuario(String nome, String login, String senha/*, TipoUsuario tipo*/) {
        super(nome, login, senha);
        this.projetos = new ArrayList<>();
        //this.tipo = tipo
    }
    
    public ArrayList<Integer> getProjetos() {return this.projetos;}
    
    //public int criarPlano(String descricao) {}
    //public void criarCaso(CasoDeTeste caso) {}
    //public void gerenciarCaso(int id, CasoDeTeste caso) {}
    //public void alocarCaso(int idCaso, int idPlano) {}
    //public void executarPlano(int idPlano) {}
    
}
