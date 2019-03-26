package app.in.bluetech.myapplication.quiz_code;

import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import app.in.bluetech.myapplication.R;

/**
 * Created by martinhocorreiamussamba on 25/03/19.
 */

public class DataInstanceQuiz_A {

    private List<QuizCode> datalistcode = new ArrayList<>();
    public static DataInstanceQuiz_A ourInstance=null;

    public static DataInstanceQuiz_A getInstance()
    {

        if(ourInstance==null) {
            ourInstance = new DataInstanceQuiz_A();
            ourInstance.initialize();
        }

        return ourInstance;

    }

    private void initialize() {

       datalistcode.add( new QuizCode("Depressão", "Lomba", "Bermas baixas ", R.drawable.lomba));
        datalistcode.add( new QuizCode("Depressão", "Lomba", "Bermas baixas ", R.drawable.lomba));
        datalistcode.add( new QuizCode("Depressão", "Lomba", "Bermas baixas ", R.drawable.lomba));
        datalistcode.add( new QuizCode("Depressão", "Lomba", "Bermas baixas ", R.drawable.lomba));
        datalistcode.add( new QuizCode("Depressão", "Lomba", "Bermas baixas ", R.drawable.lomba));
    }


    public List<QuizCode> getQuestion()
    {
        return datalistcode;
    }

}
