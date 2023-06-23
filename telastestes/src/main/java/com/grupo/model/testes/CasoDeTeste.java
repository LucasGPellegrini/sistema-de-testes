package com.grupo.model.testes;

import com.grupo.model.usuarios.Usuario;
import java.util.Date;

public class CasoDeTeste {
    private static int id_count = 0;
    private int idCaso;
    private String descricao;
    private int prioridade;
    private Date dataCriacao;
    private Date dataLimite;
    private Date dataPrevista;
    private Usuario responsavel;
    private Requisito requisito;
    private String resultadoEsperado;
    private Estado estado;
    
    public CasoDeTeste() {
        this.idCaso = id_count + 1;
        CasoDeTeste.id_count ++;
    }

    // Getters & Setters
    public int getIdCaso() {return idCaso;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public int getPrioridade() {return prioridade;}
    public void setPrioridade(int prioridade) {this.prioridade = prioridade;}
    public Date getDataCriacao() {return dataCriacao;}
    public void setDataCriacao(Date dataCriacao) {this.dataCriacao = dataCriacao;}
    public Date getDataLimite() {return dataLimite;}
    public void setDataLimite(Date dataLimite) {this.dataLimite = dataLimite;}
    public Date getDataPrevista() {return dataPrevista;}
    public void setDataPrevista(Date dataPrevista) {this.dataPrevista = dataPrevista;}
    public Usuario getResponsavel() {return responsavel;}
    public void setResponsavel(Usuario responsavel) {this.responsavel = responsavel;}
    public Requisito getRequisito() {return requisito;}
    public void setRequisito(Requisito requisito) {this.requisito = requisito;}
    public String getResultadoEsperado() {return resultadoEsperado;}
    public void setResultadoEsperado(String resultadoEsperado) {this.resultadoEsperado = resultadoEsperado;}
    public Estado getEstado() {return this.estado;}
    public void setEstado(Estado estado) {this.estado = estado;}

    
    //public void iniciar() {}
    
    //public void finalizar() {}
}
