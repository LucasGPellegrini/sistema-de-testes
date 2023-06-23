package com.grupo.model.testes;

public class Requisito {
    private int inicioCodigo;
    private int fimCodigo;
    private String pathCodigo;
    private String descricao;
    
    public Requisito(int ini, int fim, String path, String descricao) {
        this.inicioCodigo = ini;
        this.fimCodigo    = fim;
        this.pathCodigo   = path;
        this.descricao    = descricao;
    }
    
    // Getters & Setters
    public int getInicioCodigo()  {return this.inicioCodigo;}
    public int getFimCodigo()     {return this.fimCodigo;}
    public String getPathCodigo() {return this.pathCodigo;}
    public String getDescricao()  {return this.descricao;}
    
    public void setInicioCodigo(int linha) {this.inicioCodigo = linha;}
    public void setFimCodigo(int linha)    {this.fimCodigo = linha;}
    public void setPathCodigo(String path) {this.pathCodigo = path;}
    public void setDescricao(String desc)  {this.descricao = desc;}
    
}
