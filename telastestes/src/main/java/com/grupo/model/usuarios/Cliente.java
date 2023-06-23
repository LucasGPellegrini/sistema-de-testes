package com.grupo.model.usuarios;

public abstract class Cliente {
    private String nomeCompleto;
    
    private int id;
    private static int id_count = 0;
    
    private String login;
    private String senha;
    
    // Construtor
    public Cliente(String nome, String login, String senha) {
        this.id = Cliente.id_count+1;
        Cliente.id_count++;
        
        this.nomeCompleto = nome;
        this.login = login+this.id; // Garantir unicidade do login
        this.senha = senha;
    }
    
    // Getters & Setters
    public void setSenha(String senha) {this.senha = senha;}
    public String getNomeCompleto() {return this.nomeCompleto;}
    public String getLogin() {return this.login;}
    public String getSenha() {return this.senha;}
    public long getId() {return this.id;}
    
    
}
