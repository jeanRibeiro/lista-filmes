package com.e.listafilmes.ui.filme;

import com.e.listafilmes.data.model.Filme;

import java.util.List;

public interface FilmeContrato {

    //Contrato dentre a View e o Presenter

    interface  FilmeContratoView{

        void mostraFilmes(List<Filme> lista);

        void mostraErro();

    }

    interface FilmeContratoPresenter {

        void setView(FilmeContratoView view);

        void obtemFilmes();

        void destruirView();

    }

}
