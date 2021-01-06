package com.e.listafilmes.data.network.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "poster_path")
    private String caminhoPoster;

    @Json(name = "original_title")
    private String tituloOriginal;


    public FilmeResponse(String caminhoPoster, String tituloOriginal) {
        this.caminhoPoster = caminhoPoster;
        this.tituloOriginal = tituloOriginal;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public void setCaminhoPoster(String caminhoPoster) {
        this.caminhoPoster = caminhoPoster;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }
}
