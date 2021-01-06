package com.e.listafilmes.data.network;

import com.e.listafilmes.data.network.response.FilmeResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeService {

    @GET("movie/popular")
    Call<FilmeResult> obterFilmesPopulares(@Query("api_key") String chaveApi);

}
