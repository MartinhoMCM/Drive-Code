package app.in.bluetech.myapplication.quiz_code;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import app.in.bluetech.myapplication.*;

public class LevelQuizActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ListLevelQuiz adapterLevel;
    ArrayList<String> mQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelquiz);


        mQuest =new ArrayList<>(mQuestionario());

        recyclerView = findViewById(R.id.recycler_questionario);
        adapterLevel = new ListLevelQuiz(getApplicationContext(), mQuest );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterLevel);
    }


    public ArrayList<String> mQuestionario()
    {
        ArrayList<String> quest = new ArrayList<>();


        for (int i=0; i<10; i++ )
        {
            int j=i+1;
            quest.add("Questionário "+j);
        }

        return quest;
    }
}
