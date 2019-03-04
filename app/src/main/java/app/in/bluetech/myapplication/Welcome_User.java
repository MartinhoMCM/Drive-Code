package app.in.bluetech.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import app.in.bluetech.myapplication.authentication.LoginActivity;
import app.in.bluetech.myapplication.authentication.RegisterActivity;

public class Welcome_User extends AppCompatActivity  {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> item_list;
    private LinearLayout dotsLayout;
    private TextView [] dots;
    Intent intent;

    Button btn_next;
    private FirebaseUser user;
    private FirebaseAuth auth;

    public static final String str="user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__user);


        //Firebase Authentication



        btn_next = findViewById(R.id.btn_next);

       // blogin = findViewById(R.id.button_login);
      //  bregister=findViewById(R.id.button_register);
        Intent intent;


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        dotsLayout = (LinearLayout) findViewById(R.id.dotsLinearLayout);
        item_list = new ArrayList<>();

        adapter = new ListItemAdapter(this, item_list);
        recyclerView.setAdapter(adapter);

        TypedArray getImageRes = getResources().obtainTypedArray(R.array.image_slider_array);
        for (int i=0; i<3; i++)
        {
            switch (i)
            {
                case 0:
                    ListItem listItem0 =new ListItem(getString(R.string.easyOk), getString(R.string.easy_desc), getImageRes.getResourceId(i,0));
                    item_list.add(listItem0);

                    break;

                case 1: ListItem listItem1 = new ListItem(getString(R.string.everywhere), getString(R.string.everywhere_desc), getImageRes.getResourceId(i, 0));
                item_list.add(listItem1);

                break;

                case 2: ListItem listItem2 = new ListItem(getString(R.string.Prepare), getString(R.string.Prepare_desc), getImageRes.getResourceId(i,0));
                item_list.add(listItem2);
                break;
            }
        }


        getImageRes.recycle();

    }

    public void Proximo(View view) {
        auth =FirebaseAuth.getInstance();
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
}

