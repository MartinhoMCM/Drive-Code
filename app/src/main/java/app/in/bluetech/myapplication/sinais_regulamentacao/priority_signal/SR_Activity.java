package app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.in.bluetech.myapplication.*;
import app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinais_cedenciaPassagem.SCedenciaPassagemActivity;


public class SR_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regulamentation);

        Button next = findViewById(R.id.next_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SR_Activity.this, SCedenciaPassagemActivity.class));
            }
        });
    }
}
