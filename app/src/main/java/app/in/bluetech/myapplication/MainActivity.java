package app.in.bluetech.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView mLogo;
    TextView  mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  mLogo = findViewById(R.id.main_image);
     //   mTitle = findViewById(R.id.mtitle);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
       // mLogo.startAnimation(animation);
        //mTitle.startAnimation(animation);

        final Intent intent = new Intent(this, Welcome_User.class);

        Thread thread = new Thread()
        {
            public void run()
            {
              try {
                  sleep(2000);
              }
              catch (InterruptedException e)
              {
                  e.printStackTrace();
              }
              finally {
                  startActivity(intent);
                  finish();
              }
            }

        };
        thread.start();



    }
}
