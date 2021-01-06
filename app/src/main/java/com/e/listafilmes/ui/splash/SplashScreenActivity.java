package com.e.listafilmes.ui.splash;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import com.e.listafilmes.BaseActivity;
import com.e.listafilmes.R;
import com.e.listafilmes.ui.filme.FilmeActivity;


public class SplashScreenActivity extends BaseActivity {

    //COMPONENTES
    public ProgressBar progressBar;

    //VARIAVEIS COMUNS
    public final int DELAYSEGUNDOS = 3000;
    public String TAG = "SplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }


    //INICIO
    public void configuraTimeout(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abrePrincipal();
                finish();
            }
        }, DELAYSEGUNDOS);
    }


    //ABRE
    public void abrePrincipal(){
        startActivity(
                new Intent(SplashScreenActivity.this, FilmeActivity.class)
        );
    }


    //AUXILIARES


    //SOBRESCRITOS
    @Override
    protected void onResume(){
        super.onResume();

        //CONFIGURA TIMEOUT
        configuraTimeout();

    }
}