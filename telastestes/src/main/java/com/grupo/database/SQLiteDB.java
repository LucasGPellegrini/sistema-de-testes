package com.grupo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDB {

    // stores sqlite connection
    private Connection sqliteConn;

    public SQLiteDB(){

        this.sqliteConn = null;

        // creates sqlite connection to src/main/java/com/grupo/database/database.db
        try{
            this.sqliteConn = DriverManager.getConnection("jdbc:sqlite:src/main/java/com/grupo/database/database.db");
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // closes sqlite connection
    public void closeConnection(){

        try {
            if(this.sqliteConn != null) this.sqliteConn.close();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // used when started a new project or database deletion
    public void createTablesIfNotExists() {

        // does a sql query with 5 second timeout
        try{
            Statement statement = this.sqliteConn.createStatement();
            statement.setQueryTimeout(5);

            // client
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS cliente (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT UNIQUE NOT NULL, " +
                    "login TEXT NOT NULL, " +
                    "senha TEXT NOT NULL)");

            // administrador
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS administrador (" +
                    "id INTEGER PRIMARY KEY, " +
                    "FOREIGN KEY(id) REFERENCES cliente(id) )");

            // tipo_usuario
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tipo_usuario (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT UNIQUE NOT NULL, " +
                    "permissoes TEXT NOT NULL)");

            // usuario
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS usuario (" +
                    "id INTEGER PRIMARY KEY, " +
                    "id_tipo_usuario INTEGER NOT NULL, " +
                    "FOREIGN KEY(id) REFERENCES cliente(id), " +
                    "FOREIGN KEY(id_tipo_usuario) REFERENCES tipo_usuario(id) )");

            // creates default user type if not exists and get its id
            ResultSet rs = statement.executeQuery("SELECT * FROM tipo_usuario AS tu " +
                    " WHERE tu.nome = \"Padrao\";");
            Integer defaultUserTypeId = null;
            if (!rs.next()) {
                statement.executeUpdate("INSERT INTO tipo_usuario (nome, permissoes) VALUES (" +
                        "\"Padrao\", " +
                        "\"criar teste, visualizar teste, editar teste, apagar teste, " +
                        "criar plano, visualizar plano, editar plano, apagar plano, executar plano\");");
                defaultUserTypeId = this.getLastAutoIncrementId("tipo_usuario");
            }
            else {
                defaultUserTypeId = rs.getInt("id");
            }

            // creates default user if not exists
            rs = statement.executeQuery("SELECT * FROM cliente AS c JOIN usuario AS u ON c.id = u.id " +
                    " WHERE c.nome = \"Usuario\";");
            if (!rs.next()) {
                statement.executeUpdate("INSERT INTO cliente (nome, login, senha) VALUES (" +
                        "\"Usuario\", " +
                        "\"usuario@gmail.com\", " +
                        "\"1234\");");
                Integer lastId = this.getLastAutoIncrementId("cliente");
                statement.executeUpdate("INSERT INTO usuario (id, id_tipo_usuario) VALUES " +
                        "(" + lastId.toString() + ", " + defaultUserTypeId.toString() + ");" );
            }

            // creates default admin if not exists
            rs = statement.executeQuery("SELECT * FROM cliente AS c JOIN administrador AS a ON c.id = a.id " +
                    " WHERE c.nome = \"Administrador\";");
            if (!rs.next()) {
                statement.executeUpdate("INSERT INTO cliente (nome, login, senha) VALUES (" +
                        "\"Administrador\", " +
                        "\"administrador@gmail.com\", " +
                        "\"1234\");");
                Integer lastId = this.getLastAutoIncrementId("cliente");
                statement.executeUpdate("INSERT INTO administrador (id) VALUES (" + lastId.toString() + ");" );
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // returns the last autoincrement from a table
    public Integer getLastAutoIncrementId(String tableName){

        try{
            ResultSet rs = this.getByQuery("SELECT seq FROM sqlite_sequence WHERE name=\"" + tableName + "\"");

            if (rs.next()) {
                return rs.getInt("seq");
            }
            else{
                System.out.println("not found incremental id for table " + tableName);
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    // get items from db using a sql query statement
    public ResultSet getByQuery(String sqlQuery){

        ResultSet rs = null;

        // does a sql query with 5 second timeout
        try{
            Statement statement = this.sqliteConn.createStatement();
            statement.setQueryTimeout(5);

            rs = statement.executeQuery(sqlQuery);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return rs;
    }

    // execute an update [INSERT, UPDATE, or DELETE] and returns a boolean indicating if execution is successful
    public boolean update(String sqlStatement){

        // does a sqlite update with 5 second timeout
        try{
            Statement statement = this.sqliteConn.createStatement();
            statement.setQueryTimeout(5);

            statement.executeUpdate(sqlStatement);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}