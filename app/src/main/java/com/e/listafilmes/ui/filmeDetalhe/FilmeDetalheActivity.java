package com.e.listafilmes.ui.filmeDetalhe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.e.listafilmes.BaseActivity;
import com.e.listafilmes.R;
import com.e.listafilmes.data.model.Filme;

public class FilmeDetalheActivity extends BaseActivity {

    public static final String EXTRA = "EXTRA_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detalhe);

        TextView tv = (TextView) findViewById(R.id.fil_det_tvTitulo);

        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA);

        tv.setText(filme.getTitulo());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}