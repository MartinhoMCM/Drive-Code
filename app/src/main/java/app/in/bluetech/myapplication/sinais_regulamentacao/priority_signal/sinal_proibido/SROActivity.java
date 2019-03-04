package app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinal_proibido;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import app.in.bluetech.myapplication.*;
import app.in.bluetech.myapplication.contents_signal.SPP_Adapter;
import app.in.bluetech.myapplication.contents_signal.SPerigo;

public class SROActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SPP_Adapter adapter;
    ArrayList<SPerigo> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sro);

        list = new ArrayList<>();
        recyclerView =findViewById(R.id.recyclerview_proibicao);
        adapter = new SPP_Adapter(getApplicationContext(), list );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        initializeData();

    }

    private void initializeData() {

        TypedArray proibicaoImage=getResources().obtainTypedArray(R.array.image_proibicao_array);
        String [] getcontent =getResources().getStringArray(R.array.content_sproibicao_lista);

        list.clear();

        for (int i=0; i<getcontent.length; i++)
        {
            list.add(new SPerigo(getcontent[i], proibicaoImage.getResourceId(i,0)));
            adapter.notifyDataSetChanged();
        }

        proibicaoImage.recycle();

    }
}
