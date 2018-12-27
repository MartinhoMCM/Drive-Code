package app.in.bluetech.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Welcome_User extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> item_list;
    private LinearLayout dotsLayout;
    private TextView [] dots;
    Intent intent;

    Button blogin, bregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__user);

        blogin = findViewById(R.id.button_login);
        bregister=findViewById(R.id.button_register);
        Intent intent;


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        dotsLayout = (LinearLayout) findViewById(R.id.dotsLinearLayout);
        item_list = new ArrayList<>();
        for (int i=0; i<3; i++)
        {
            switch (i)
            {
                case 0:
                    ListItem listItem0 =new ListItem(getString(R.string.easyOk), getString(R.string.easy_desc));
                    item_list.add(listItem0);
                    break;

                case 1: ListItem listItem1 = new ListItem(getString(R.string.everywhere), getString(R.string.everywhere_desc));
                item_list.add(listItem1);
                break;

                case 2: ListItem listItem2 = new ListItem(getString(R.string.Prepare), getString(R.string.Prepare_desc));
                item_list.add(listItem2);
                break;
            }
        }
        adapter = new ListItemAdapter(this, item_list);
        recyclerView.setAdapter(adapter);
        dotsIndicator();

    }

    public void dotsIndicator(){

        dots = new TextView[3];
        for (int i=0; i<dots.length;i++)
        {
           dots[i]= new TextView(this);
           dots[i].setText(Html.fromHtml("&#8226;"));
           dots[i].setTextSize(40);
           dots[i].setTextColor(getResources().getColor(R.color.transparent_gray_color));
           dotsLayout.addView(dots[i]);
        }
    }


    public void LoginSection(View view) {
        intent= new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    public  void RegisterSection(View view)
    {
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
        finish();

    }
}

