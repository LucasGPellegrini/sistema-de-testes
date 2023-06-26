package com.grupo.model.usuarios;

import com.grupo.database.SQLiteDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario extends Cliente{
    
    private TipoUsuario tipo;
    private ArrayList<Integer> projetos;

    // Constructor with id
    public Usuario(Integer id, String nome, String login, String senha) {
        super(id, nome, login, senha);
        this.projetos = new ArrayList<>();
        this.tipo = tipo;
    }

    // Constructor without id
    public Usuario(String nome, String login, String senha) {
        super(nome, login, senha);
        this.projetos = new ArrayList<>();
        this.tipo = tipo;
    }
    
    public ArrayList<Integer> getProjetos() {return this.projetos;}
    
    //public int criarPlano(String descricao) {}
    //public void criarCaso(CasoDeTeste caso) {}
    //public void gerenciarCaso(int id, CasoDeTeste caso) {}
    //public void alocarCaso(int idCaso, int idPlano) {}
    //public void executarPlano(int idPlano) {}
    
}