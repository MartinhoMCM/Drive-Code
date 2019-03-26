package app.in.bluetech.myapplication.quiz_code;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by martinhocorreiamussamba on 25/03/19.
 */

public class QuizCode {

    String Bfirst;
    String Bsecond;
    String Bthird;

    int quiz_image;

    public QuizCode(String bfirst, String bsecond, String bthird, int quiz_image) {
        this.Bfirst = bfirst;
        this.Bsecond = bsecond;
        this.Bthird = bthird;
        this.quiz_image = quiz_image;
    }

    public String getBfirst() {
        return Bfirst;
    }

    public String getBsecond() {
        return Bsecond;
    }

    public String getBthird() {
        return Bthird;
    }

    public int getQuiz_image() {
        return quiz_image;
    }
}
