package app.in.bluetech.myapplication.sinal_temporario;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.in.bluetech.myapplication.*;
import app.in.bluetech.myapplication.contents_signal.SPP_Adapter;
import app.in.bluetech.myapplication.contents_signal.SPerigo;

public class SinaTemporarioActivity extends AppCompatActivity {


    private RecyclerView recyclerView_sp;
    private TextView titulo;
    private SPP_Adapter adapter;
    ArrayList<SPerigo> stList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinaltemporario);

        titulo =findViewById(R.id.st_titulo);
        recyclerView_sp=findViewById(R.id.recyclerview_st);
        stList = new ArrayList<>();
        recyclerView_sp.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SPP_Adapter(getApplicationContext(), stList);
        recyclerView_sp.setAdapter(adapter);

        InitializeData();
    }

    private void InitializeData() {

        TypedArray typedArray = getResources().obtainTypedArray(R.array.st_array_image);
        String signalname []= getResources().getStringArray(R.array.st_array_name);

        stList.clear();

        for (int j =0; j<signalname.length; j++)
        {
            stList.add(new SPerigo(signalname[j], typedArray.getResourceId(j,0)));
            adapter.notifyDataSetChanged();
        }

        typedArray.recycle();
    }
}
