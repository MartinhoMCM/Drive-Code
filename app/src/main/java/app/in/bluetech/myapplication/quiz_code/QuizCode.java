package app.in.bluetech.myapplication.quiz_code;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import app.in.bluetech.myapplication.R;

/**
 * Created by martinhocorreiamussamba on 25/03/19.
 */

public class QuizCode {

    public String Question[] =
    {
                    "A sinalização vertical existente adverte-me para:",
                    "Neste local, devo dar particular atenção:",
                    "O sinal de fundo azul, é um sinal de::",
                    "O sinal vertical é um sinal de:",
                        "Que sinal é ? :"

    };

    public String mChoices[][] =
            {
                    {"Aproximação de passagem de nível com guarda.","Aproximação de passagem de nível sem guarda a 300 metros.", "Aproximação de uma via sem saída"},
                    {"À possibilidade de encontrar crianças.","À possibilidade de encontrar idosos.", "À possível forte deslocação de ar."},
                    {"Cedência de passagem.","Informação.", "Perigo."},
                    {"Cedência de passagem.","Indicação.", "Perigo."},
                    {"Sinal de proibição de estacionamento","Proibição de inversão do sentido de marcha.", "Sinal de paragem obrigatória"}


            };

    public String mCurrentAnswer []=
            {
                    "Aproximação de passagem de nível sem guarda a 300 metros.", "À possibilidade de encontrar crianças.",
                    "Informação.", "Perigo.", "Proibição de inversão do sentido de marcha."
            };


    public int Images[]=
            {
                    R.drawable.question_1, R.drawable.question_2, R.drawable.question_4,
                    R.drawable.question_3, R.drawable.proibicao_de_inversao_do_sentido_de_marcha
            };

    public String getQuestion(int a)
    {
        String question =Question[a];

        return question;
    }

    public String getChoice1(int a)
    {
        String choice =mChoices[a][0];
        return choice;
    }
    public String getChoice2(int a)
    {
        String choice =mChoices[a][1];
        return choice;
    }
    public String getChoice3(int a)
    {
        String choice =mChoices[a][2];
        return choice;
    }

    public String getCorrectAnswer(int a)
    {
        String answer =mCurrentAnswer[a];
        return answer;
    };
}
