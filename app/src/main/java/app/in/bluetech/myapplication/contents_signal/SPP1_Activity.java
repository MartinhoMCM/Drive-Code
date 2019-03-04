package app.in.bluetech.myapplication.contents_signal;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import app.in.bluetech.myapplication.R;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.SR_Activity;

public class SPP1_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<SPerigo> sPerigos;
    SPP_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spp1_);


        recyclerView = findViewById(R.id.recyclerview_perigo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sPerigos = new ArrayList<>();

        adapter = new SPP_Adapter(this, sPerigos);
        recyclerView.setAdapter(adapter);
        initializeData();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initializeData() {

        TypedArray perigonImageRes =
                getResources().obtainTypedArray(R.array.image_perigo_array);
        String []  getcontent = getResources().getStringArray(R.array.contents_perigo_array);

        sPerigos.clear();

        for (int i=0; i<getcontent.length; i++)
        {
            String string = perigonImageRes.getString(i);
            sPerigos.add( new SPerigo(getcontent[i], perigonImageRes.getResourceId(i, 0)));
        }

        adapter.notifyDataSetChanged();

        perigonImageRes.recycle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id== R.id.action_next)
        {
            startActivity(new Intent(SPP1_Activity.this, SR_Activity.class));
        }
        else if (id==R.id.action_back)
        {
            startActivity(new Intent(SPP1_Activity.this, SinaisPerigoIntroducaoActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
