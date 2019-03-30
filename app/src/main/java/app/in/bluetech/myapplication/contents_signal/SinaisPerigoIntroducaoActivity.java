package app.in.bluetech.myapplication.contents_signal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.in.bluetech.myapplication.R;

public class SinaisPerigoIntroducaoActivity extends AppCompatActivity {

    private TextView title;
    private Button proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinais_perigo_introducao);


        title = findViewById(R.id.titulo);
       // TextView conteudo = findViewById(R.id.content);

       // title.setText(getIntent().getStringExtra("title"));
        Log.d("TITLE ", title.getText().toString());
    }
    public void Proximo(View view) {

        Intent intent = new Intent(this, SPP1_Activity.class);
        startActivity(intent);
    }
}
