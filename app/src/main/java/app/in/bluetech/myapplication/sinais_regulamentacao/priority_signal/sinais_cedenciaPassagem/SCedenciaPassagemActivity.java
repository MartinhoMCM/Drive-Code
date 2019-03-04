package app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinais_cedenciaPassagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import  app.in.bluetech.myapplication.*;
import app.in.bluetech.myapplication.sinais_cedencia.ScedenciaPassagemActivity;

public class SCedenciaPassagemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scedencia_passagem);
    }

    public void Next(View view) {
       startActivity( new Intent(SCedenciaPassagemActivity.this, ScedenciaPassagemActivity.class ));
    }
}
