package app.in.bluetech.myapplication.sinais_cedencia;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import app.in.bluetech.myapplication.*;
import app.in.bluetech.myapplication.contents_signal.SPP_Adapter;
import app.in.bluetech.myapplication.contents_signal.SPerigo;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.SR_Activity;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinais_cedenciaPassagem.SCedenciaPassagemActivity;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinal_proibido.SproibicaoActivity;

public class ScedenciaPassagemActivity extends AppCompatActivity {

    private ArrayList<SPerigo> scendencia_list;
    private RecyclerView recyclerView;
    private SPP_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinalcedencia);

        scendencia_list = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview_scendia);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SPP_Adapter(this, scendencia_list);

        initializeData();
    }

    private void initializeData() {

        TypedArray list_cedencia =getResources().obtainTypedArray(R.array.image_cedencia_array);
        String [] string_nameCedencia=getResources().getStringArray(R.array.content_scendencia_lista);

        scendencia_list.clear();

        for (int j =0; j<string_nameCedencia.length; j++)
        {
            scendencia_list.add(new SPerigo(string_nameCedencia[j], list_cedencia.getResourceId(j,0)));
        }

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        list_cedencia.recycle();
    }


}
