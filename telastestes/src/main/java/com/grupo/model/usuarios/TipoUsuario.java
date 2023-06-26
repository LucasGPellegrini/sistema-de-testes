package com.grupo.model.usuarios;

import com.grupo.database.SQLiteDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoUsuario {

    private Integer id;
    private String nome;
    private ArrayList<String> permissoes;

    // constructor with id
    public TipoUsuario(Integer id, String nome, ArrayList<String> permissoes) {
        this.id = id;
        this.nome = nome;
        this.permissoes = permissoes;
    }

    // constructor without id
    public TipoUsuario(String nome, ArrayList<String> permissoes) {
        this.nome = nome;
        this.permissoes = permissoes;
    }

    // Getters
    public Integer getId(){
        return this.id;
    }
    public ArrayList<String> getPermissoes() {
        return this.permissoes;
    }
    public static ArrayList<String> getPermissionsArrayFromString(String permissionsStr) {
        ArrayList<String> Permissoes = new ArrayList<>();
        String[] tokens = permissionsStr.split(",");
        for (String token : tokens) {
            Permissoes.add(token.trim());
        }
        return Permissoes;
    }
    public String getPermissoesString() {
        return String.join(", ", this.permissoes);
    }
    public String getNome() {
        return this.nome;
    }
    
    public void atualizaPermissoes(ArrayList<String> permissoes) {
        this.permissoes = permissoes;
    }

    // get a ResultSet to all user types from db
    public static ArrayList<TipoUsuario> getAllUserTypesFromDB(){

        SQLiteDB sqliteConn = new SQLiteDB();
        ArrayList<TipoUsuario> result = new ArrayList<TipoUsuario>();

        try{
            ResultSet rs = sqliteConn.getByQuery("SELECT * FROM tipo_usuario;");

            while (rs.next()) {
                // add current type formated to result
                result.add( new TipoUsuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        getPermissionsArrayFromString(rs.getString("permissoes"))));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        sqliteConn.closeConnection();
        return result;
    }

    // save a user type or returns a String if has creation errors
    public String saveToDB(){

        SQLiteDB sqliteConn = new SQLiteDB();

        // check if nome already exists
        ResultSet rs = sqliteConn.getByQuery("SELECT * FROM tipo_usuario AS tu " +
                " WHERE tu.nome = \"" + this.getNome() + "\";");
        try{
            if (rs.next()) {
                sqliteConn.closeConnection();
                return "Nome do tipo de usuário já existe";
            }

            // inserts tipo_usuario
            sqliteConn.update("INSERT INTO tipo_usuario (nome, permissoes) VALUES (" +
                    "\"" + this.getNome() + "\", " +
                    "\"" + this.getPermissoesString() + "\");");
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        sqliteConn.closeConnection();
        return null;
    }
}
