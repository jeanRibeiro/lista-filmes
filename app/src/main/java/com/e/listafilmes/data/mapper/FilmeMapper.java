package com.e.listafilmes.data.mapper;

import com.e.listafilmes.data.model.Filme;
import com.e.listafilmes.data.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmeMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listaFilmeResponse){

        List<Filme> listaFilme = new ArrayList<>();

        for(FilmeResponse filmeResponse : listaFilmeResponse){
            final Filme filme = new Filme(filmeResponse.getTituloOriginal(), filmeResponse.getCaminhoPoster());
            listaFilme.add(filme);
        }

        return listaFilme;
    }


}
