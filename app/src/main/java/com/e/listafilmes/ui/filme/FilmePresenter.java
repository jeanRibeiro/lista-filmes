package com.e.listafilmes.ui.filme;

import com.e.listafilmes.data.mapper.FilmeMapper;
import com.e.listafilmes.data.model.Filme;
import com.e.listafilmes.data.network.ApiService;
import com.e.listafilmes.data.network.response.FilmeResult;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmePresenter implements FilmeContrato.FilmeContratoPresenter{

    //Será utilizado para executar os testes

    private FilmeContrato.FilmeContratoView view;

    public FilmePresenter(FilmeContrato.FilmeContratoView view){
        this.view = view;
    }

    @Override
    public void setView(FilmeContrato.FilmeContratoView view) {
        this.view = view;
    }

    @Override
    public void obtemFilmes() {

        ApiService.getInstance()
                .obterFilmesPopulares("792703269b6c71b1377983e8da11f7b6")
                .enqueue(new Callback<FilmeResult>() {
                    @Override
                    public void onResponse(Call<FilmeResult> call, Response<FilmeResult> response) {
                        if(response.isSuccessful()){
                            final List<Filme> listaFilmes = FilmeMapper.deResponseParaDominio(
                                    response.body().getResultadoFilmes()
                            );
                            view.mostraFilmes(listaFilmes);
                        }
                        //tratar os status code 400, 500, etc
                        else{
                            view.mostraErro();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmeResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });

    }

    @Override
    public void destruirView() {
        this.view = null;
    }
}
