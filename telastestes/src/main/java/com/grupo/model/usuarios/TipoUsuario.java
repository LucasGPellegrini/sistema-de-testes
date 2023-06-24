package com.grupo.model.usuarios;

import java.util.ArrayList;

public class TipoUsuario {
    private String nome;
    private ArrayList<String> permissoes;
    
    public TipoUsuario(String nome, ArrayList<String> permissoes) {
        //VERIFICA_SE_JA_EXISTE_NOME
        this.permissoes = new ArrayList<>();
        this.nome = nome;
        this.permissoes = permissoes;
    }
    
    // Getters
    public ArrayList<String> getPermissoes() {return this.permissoes;}
    public String getNome() {return this.nome;}
    
    public void atualizaPermissoes(ArrayList<String> permissoes) {
        this.permissoes = permissoes;
    }
}
