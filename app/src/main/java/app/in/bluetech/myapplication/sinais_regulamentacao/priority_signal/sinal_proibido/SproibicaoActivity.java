package app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinal_proibido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import app.in.bluetech.myapplication.*;
import app.in.bluetech.myapplication.contents_signal.SPP_Adapter;


public class SproibicaoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SPP_Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sproibicao);

       // recyclerView = findViewById(R.id.rec)


    }

    public void Next(View view) {

        startActivity(new Intent(SproibicaoActivity.this, SROActivity.class));
    }
}
