package app.in.bluetech.myapplication.quiz_code;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import app.in.bluetech.myapplication.*;

public class QuizCodeActivity extends AppCompatActivity  implements View.OnClickListener{



    private QuizCode quizCode= new QuizCode();

    Button answer1, answer2, answer3;
    private  int mQuestionLength =quizCode.Question.length;
    private TextView question, score;
    private ImageView quiz_image;
    public String answer;
    Random r;

    private int Score=0;
    int quantReal =mQuestionLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizcode);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("Exame - Categoria 1");

        r =new Random();

        answer1 = findViewById(R.id.answer_1);
        answer2 =findViewById(R.id.answer_2);
        answer3 = findViewById(R.id.answer_3);
        question =findViewById(R.id.question_quiz);
        score =findViewById(R.id.score);
        score.setText(Score+ "/"+ "5");


        quiz_image =findViewById(R.id.quiz_img);

        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);


        updateQuestion(r.nextInt(quizCode.Question.length));

    }

    private void PossibleEXITORCONTINUE() {
        if(quantReal>0) {
            updateQuestion(r.nextInt(quizCode.Question.length));
        }
        else
        {
            AlertDialog.Builder  alertdialog = new AlertDialog.Builder(QuizCodeActivity.this);
            alertdialog.setMessage("Fim do Exame! Tua pontuação é de "+Score + " pontos").
            setCancelable(false).setPositiveButton("REPETIR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    startActivity(new Intent(getApplicationContext(), QuizCodeActivity.class));
                    finish();
                }
            })
            .setNegativeButton("SAIR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(getApplicationContext(), DrawerActivity.class));
                    finish();
                }
            });


            AlertDialog dialog =alertdialog.create();
            dialog.show();

        }
    }

    private void updateQuestion(int i) {
        answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

       quiz_image.setImageResource(quizCode.Images[i]);

       String AnswerA=quizCode.getChoice1(i);
        String AnswerB=quizCode.getChoice2(i);
        String AnswerC=quizCode.getChoice3  (i);

       question.setText(quizCode.Question[i]);
       answer1.setText(AnswerA.charAt(0)+AnswerA.substring(1, AnswerA.length()).toLowerCase());
       answer2.setText(AnswerB.charAt(0)+AnswerB.substring(1, AnswerB.length()).toLowerCase());
       answer3.setText(AnswerC.charAt(0)+AnswerC.substring(1, AnswerC.length()).toLowerCase());

       answer =quizCode.mCurrentAnswer[i];

    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.answer_1:
                quantReal--;
                PossibleEXITORCONTINUE();

                if (answer1.getText() == answer)
                {
                    Score++;
                    score.setText(Score+ "/"+ "5");
                    answer1.setBackgroundColor(getResources().getColor(R.color.bg_login));
                    Toast.makeText(getApplicationContext(), "Certo", Toast.LENGTH_SHORT).show();
                    updateQuestion(r.nextInt(quizCode.Question.length));
                }
                else {

                    answer1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    Toast.makeText(getApplicationContext(), "Errado", Toast.LENGTH_SHORT).show();
                    updateQuestion(r.nextInt(quizCode.Question.length));
                }

                break;
            case R.id.answer_2:
                quantReal--;
                PossibleEXITORCONTINUE();

                if (answer2.getText() == answer)
                {
                    Score++;
                    score.setText(Score+ "/"+ "5");
                    answer2.setBackgroundColor(getResources().getColor(R.color.bg_login));


                    Toast.makeText(getApplicationContext(), "Certo", Toast.LENGTH_SHORT).show();
                    updateQuestion(r.nextInt(quizCode.Question.length));
                }
                else {

                    answer2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    Toast.makeText(getApplicationContext(), "Errado", Toast.LENGTH_SHORT).show();
                    updateQuestion(r.nextInt(quizCode.Question.length));
                }

                break;
            case R.id.answer_3:
                quantReal--;
                PossibleEXITORCONTINUE();

                if (answer3.getText() == answer)
                {
                    Score++;
                    score.setText(Score+ "/"+ "5");
                    answer3.setBackgroundColor(getResources().getColor(R.color.bg_login));
                    Toast.makeText(getApplicationContext(), "Certo", Toast.LENGTH_SHORT).show();
                    updateQuestion(r.nextInt(quizCode.Question.length));
                }
                else {

                    answer3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    Toast.makeText(getApplicationContext(), "Errado", Toast.LENGTH_SHORT).show();
                    updateQuestion(r.nextInt(quizCode.Question.length));
                }
                break;
        }
    }
    public int getLastSCore()
    {
           return  Score;
    };
}
