package app.in.bluetech.myapplication.sinais_regulamentacao.priority_signal.sinais_obrigacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.in.bluetech.myapplication.*;

public class SobrigacaoActivity extends AppCompatActivity {

    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobrigacao);

        button = findViewById(R.id.btn_ob_next);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(SobrigacaoActivity.this, SOActivity.class));
                    }
                }
        );
    }
}
