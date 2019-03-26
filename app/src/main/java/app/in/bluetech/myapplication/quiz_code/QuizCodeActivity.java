package app.in.bluetech.myapplication.quiz_code;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.in.bluetech.myapplication.*;

public class QuizCodeActivity extends AppCompatActivity {


    private List<QuizCode> quizCodeList;
    private QuizCodeAdapter adapter;
    private RecyclerView recyclerViewQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizcode);

        recyclerViewQuiz = findViewById(R.id.quiz_code_recycler_1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewQuiz.setLayoutManager(linearLayoutManager);

        addQuizQuestion();

    }

    private void addQuizQuestion() {

       quizCodeList =DataInstanceQuiz_A.getInstance().getQuestion();
       // adapter = new QuizCodeAdapter();
       // recyclerViewQuiz.setAdapter(adapter);

    }
}
