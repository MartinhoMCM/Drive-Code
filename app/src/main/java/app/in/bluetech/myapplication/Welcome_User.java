package app.in.bluetech.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import app.in.bluetech.indices.sampledata.sinais_de_perigo.SlideAdapter;
import app.in.bluetech.myapplication.authentication.LoginActivity;
import app.in.bluetech.myapplication.authentication.RegisterActivity;

public class Welcome_User extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayout dotsLayout;
    private TextView [] dots;
    Intent intent;


    Button btn_next;
    private FirebaseUser user;
    private FirebaseAuth auth;


    public static final String str="user";


    private ViewPager mSliderViewPager;
    private LinearLayout mDotLayout;
    SlideAdapter adapter;

    private Button Btn_next;
    private int currentIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__user);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

     //   Glide.with(this).load(R.drawable.alternativa).into(R.layout.activity_welcome__user).;

        dotsLayout = findViewById(R.id.dotsLinearLayout);

        mSliderViewPager =findViewById(R.id.slideviewpager);

         adapter = new SlideAdapter(this);
         mSliderViewPager.setAdapter(adapter);
         Btn_next = findViewById(R.id.BNext);

        addDotsIndicator(0);

        mSliderViewPager.addOnPageChangeListener(viewListener);

        Btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSliderViewPager.setCurrentItem(currentIndicator+1);
            }
        });
    }

   private  void addDotsIndicator(int position){

       dots = new TextView[3];
       dotsLayout.removeAllViews();
       for (int i=0;i<dots.length; i++)
       {
           dots[i]=new TextView(this);
           dots[i].setText(Html.fromHtml("&#8226;"));
           dots[i].setTextColor(getResources().getColor(R.color.transparent_white));
           dots[i].setTextSize(35);
           dotsLayout.addView(dots[i]);
       }

       if(dots.length>0)
       {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
       }
   }

   ViewPager.OnPageChangeListener viewListener =new ViewPager.OnPageChangeListener() {
       @Override
       public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

       }

       @Override
       public void onPageSelected(int position) {
           addDotsIndicator(position);

           currentIndicator =position;

           if(position==2)
           {
               Proximo();
           }
           else
           {
               Btn_next.setText(R.string.proximo);
           }

       }

       @Override
       public void onPageScrollStateChanged(int state) {

       }
   };

    private void Proximo() {
        Btn_next.setText("INICIAR À ESTUDAR");
        Btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth = FirebaseAuth.getInstance();
                user=auth.getCurrentUser();
                if(user==null)
                {
                    startActivity(new Intent(Welcome_User.this, RegisterActivity.class));
                    finish();
                    return;
                }
                else
                {
                    String  User_name =user.getDisplayName();
                    Intent  intent_login = new Intent(Welcome_User.this, LoginActivity.class);
                    intent_login.putExtra(str, User_name );
                    startActivity(intent_login);
                    finish();
                    return;
                }
            }
        });
    }


}

