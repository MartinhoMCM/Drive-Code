package app.in.bluetech.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import java.util.List;

import app.in.bluetech.myapplication.quiz_code.QuizCodeActivity;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser user;

     TextView user_name, user_email;
    private String name;
    private String email;
    private Uri photoUrl;
    ImageView user_image;

    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      RecyclerView recyclerView = findViewById(R.id.recyclerview);
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      recyclerView.setLayoutManager(linearLayoutManager);

      List<IndiceInfo> infoList = DataInstance_Indice.getInstance().getIndice();
      Indice_Adapter adapter = new Indice_Adapter(this, infoList );
      recyclerView.setAdapter(adapter);


       /** user_name = findViewById(R.id.user_name);
        user_email=  findViewById(R.id.user_email);
        user_image = findViewById(R.id.user_photo);

        user_name.setText(name);
        user_email.setText(email);
        user_image.setImageURI(photoUrl);
        **/
       navigationView =findViewById(R.id.nav_view);

       user_name =navigationView.getHeaderView(0).findViewById(R.id.user_name);
       user_email = navigationView.getHeaderView(0).findViewById(R.id.user_email);
       user_image =navigationView.getHeaderView(0).findViewById(R.id.user_photo);


        // Firebase
        mFirebaseAuth = FirebaseAuth.getInstance();
        user =mFirebaseAuth.getCurrentUser();
        if(user !=null)
        {
            for (UserInfo profile: user.getProviderData())
            {
                name=profile.getDisplayName();
                user_name.setText(name);
                email=profile.getEmail();
                user_email.setText(email);
                Uri uri=profile.getPhotoUrl();

         //      Glide.with(this).load(uri.toString()).placeholder(R.drawable.main_image).override(50,50).into(user_image);
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

  
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Intent intent;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.exame_nav) {


            startActivity(new Intent(this, QuizCodeActivity.class   ));

            // Handle the camera action
        } else if (id == R.id.rendimeto_nav) {

        } else if (id == R.id.resultado_nav) {

        } else if (id == R.id.ajuda_nav) {

        } else if (id == R.id.sair_nav) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}