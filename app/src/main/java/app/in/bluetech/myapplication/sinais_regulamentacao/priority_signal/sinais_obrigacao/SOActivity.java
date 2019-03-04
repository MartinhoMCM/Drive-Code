package app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinais_obrigacao;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import app.in.bluetech.myapplication.*;
import app.in.bluetech.myapplication.R;
import app.in.bluetech.myapplication.contents_signal.SPP_Adapter;
import app.in.bluetech.myapplication.contents_signal.SPerigo;

public class SOActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SPP_Adapter adapter;
    ArrayList<SPerigo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so);

        recyclerView = findViewById(R.id.recyclerview_obrigacao);
        list = new ArrayList<>();
        adapter = new SPP_Adapter(getApplicationContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

       InitializeData();
    }

    private void InitializeData() {
        TypedArray imageResource =getResources().obtainTypedArray(R.array.image_obrigacao_array);
        String [] getContent = getResources().getStringArray(R.array.content_obrigacao_array);

        list.clear();
        for (int i=0; i<getContent.length; i++)
        {
            list.add(new SPerigo(getContent[i], imageResource.getResourceId(i,0)));
            adapter.notifyDataSetChanged();
        }

        imageResource.recycle();
    }
}
