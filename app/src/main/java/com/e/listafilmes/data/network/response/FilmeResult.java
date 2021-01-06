package com.e.listafilmes.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class FilmeResult {
    //Atributos

    //Pode passar direto o nome ou utilizar a notação "@"
    private List<FilmeResponse> status;

    @Json(name  = "results")
    private List<FilmeResponse> resultadoFilmes;


    //Construtor
    public FilmeResult(List<FilmeResponse> resultadoFilmes) {
        this.resultadoFilmes = resultadoFilmes;
    }


    //getters e setters
    public List<FilmeResponse> getResultadoFilmes() {
        return resultadoFilmes;
    }
    public void setResultadoFilmes(List<FilmeResponse> resultadoFilmes) {
        this.resultadoFilmes = resultadoFilmes;
    }
}
