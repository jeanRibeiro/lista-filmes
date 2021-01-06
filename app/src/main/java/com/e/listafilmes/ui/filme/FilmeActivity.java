package com.e.listafilmes.ui.filme;

import android.content.Intent;
import android.os.Bundle;
import com.e.listafilmes.BaseActivity;
import com.e.listafilmes.data.mapper.FilmeMapper;
import com.e.listafilmes.data.model.Filme;
import com.e.listafilmes.data.network.ApiService;
import com.e.listafilmes.data.network.response.FilmeResult;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;
import com.e.listafilmes.R;
import com.e.listafilmes.ui.filmeDetalhe.FilmeDetalheActivity;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmeActivity extends BaseActivity implements FilmeContrato.FilmeContratoView, FilmeAdapter.ItemFilmeClickListener {

    private RecyclerView recyclerView;
    private FilmeAdapter adapter;
    private FilmeContrato.FilmeContratoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);

        configuraToolbar();

        configuraAdapter();

        presenter = new FilmePresenter(this);
        //presenter.setView(this);
        presenter.obtemFilmes();

    }


    private void configuraToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle(R.string.title_activity_filme);
    }
    private void configuraAdapter(){
        recyclerView = (RecyclerView) findViewById(R.id.layout_rec_pad_rvPadrao);

        adapter = new FilmeAdapter(this);

        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void mostraFilmes(List<Filme> lista) {
        adapter.setFilmes(lista);
    }
    @Override
    public void mostraErro(){
        Toast.makeText(this, "Erro ao obter a lista de filmes.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.destruirView();
    }

    @Override
    public void onItemClickListener(Filme filme) {
        startActivity(
                new Intent(this, FilmeDetalheActivity.class)
                .putExtra(FilmeDetalheActivity.EXTRA, filme)
        );
    }
}