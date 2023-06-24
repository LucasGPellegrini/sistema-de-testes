package com.grupo.model.usuarios;

import com.grupo.database.SQLiteDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public abstract class Cliente {
    private String nomeCompleto;
    
    private int id;
    private static int id_count = 0;
    
    private String login;
    private String senha;
    
    // Construtor
    public Cliente(Integer id, String nome, String login, String senha) {
        this.id = id;
        this.nomeCompleto = nome;
        this.login = login;
        this.senha = senha;
    }
    
    // Getters & Setters
    public void setSenha(String senha) {this.senha = senha;}
    public String getNomeCompleto() {return this.nomeCompleto;}
    public String getLogin() {return this.login;}
    public String getSenha() {return this.senha;}
    public long getId() {return this.id;}
    
    /* For Database SQLite */
    
    // do user authentication based on login and password
    public static Cliente doLoginAuth(String userLogin, String userPassword, String clientType) {

        SQLiteDB sqliteConn = new SQLiteDB();

        if( userLogin.trim().length() == 0 || userPassword.trim().length() == 0 ) {
            return null;
        }

        if((!Objects.equals(clientType, "usuario") && !Objects.equals(clientType, "administrador"))){
            System.out.println("Tipo de cliente Inválido");
            return null;
        }

        String query = (
                "SELECT * FROM cliente AS c JOIN " + clientType + " AS ctype ON c.id = ctype.id " +
                        " WHERE c.login = \"" + userLogin + "\" AND c.senha = \"" + userPassword + "\";");
        // get client with login and pass checking
        ResultSet rs = sqliteConn.getByQuery(query);

        // only to avoid duplication in doLoginAuth and getUserOrAdmFromDB
        return getCliente(clientType, sqliteConn, rs);
    }

    // get a client user od admin by id
    public static Cliente getUserOrAdmFromDB(Integer id, String clientType) {

        SQLiteDB sqliteConn = new SQLiteDB();

        if((!Objects.equals(clientType, "usuario") && !Objects.equals(clientType, "administrador"))){
            System.out.println("Tipo de cliente Inválido");
            return null;
        }

        // get client with a specific id
        ResultSet rs = sqliteConn.getByQuery(
                "SELECT * FROM cliente AS c JOIN " + clientType + " as ctype ON c.id = ctype.id " +
                        " WHERE ctype.id = " + id.toString() + ";");

        // only to avoid duplication in doLoginAuth and getUserOrAdmFromDB
        return getCliente(clientType, sqliteConn, rs);
    }

    // parse client class to Usuario or Administrador
    private static Cliente getCliente(String clientType, SQLiteDB sqliteConn, ResultSet rs) {

        Cliente client = null;

        try{
            if (rs.next()) {
                if(Objects.equals(clientType, "usuario")){
                    client = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
                }
                else{
                    client = new Administrador(rs.getInt("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
                }
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            sqliteConn.closeConnection();
            return client;
        }
    }

    // save a user or adm client or returns a String if has creation errors
    public String saveToDB(boolean isUser, boolean isAdm){

        SQLiteDB sqliteConn = new SQLiteDB();

        // check if name or login for each client profile already exists
        ResultSet rs = sqliteConn.getByQuery("SELECT * FROM cliente AS c " +
                (isUser && !isAdm ? " JOIN usuario AS u ON c.id = u.id " : "") +
                (isAdm && !isUser ? " JOIN administrador AS a ON c.id = a.id " : "") +
                " WHERE c.nome = \"" + this.getNomeCompleto() + "\" OR c.login = \"" + this.getLogin() + "\";");
        try{
            if (rs.next()) {
                return "Cliente já existe";
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        // inserts client
        sqliteConn.update("INSERT INTO cliente (nome, login, senha) VALUES (" +
                "\"" + this.getNomeCompleto() + "\", " +
                "\"" + this.getLogin() + "\", " +
                "\"" + this.getSenha() + "\");");
        // get last client autoincrement
        Integer lastClientId = sqliteConn.getLastAutoIncrementId("cliente");

        // inserts user or/and admin
        if(isUser){
            sqliteConn.update("INSERT INTO usuario (id) VALUES (" + lastClientId.toString() + ");" );
        }
        if(isAdm){
            sqliteConn.update("INSERT INTO administrador (id) VALUES (" + lastClientId.toString() + ");" );
        }

        sqliteConn.closeConnection();
        return null;
    }
    /* */
}
