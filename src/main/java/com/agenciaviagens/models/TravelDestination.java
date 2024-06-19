package com.agenciaviagens.models;

public class TravelDestination {

    private Integer id;
    private String nome;
    private String localizacao;
    private String descricao;
    private double notaMedia;
    private int numeroDeAvaliacoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public int getNumeroDeAvaliacoes() {
        return numeroDeAvaliacoes;
    }

    public void setNumeroDeAvaliacoes(int numeroDeAvaliacoes) {
        this.numeroDeAvaliacoes = numeroDeAvaliacoes;
    }
}
