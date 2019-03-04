package app.in.bluetech.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.LinkedList;
import java.util.List;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

     TextView user_name, user_email;
    private String name;
    private String email;
    private Uri photoUrl;
    ImageView user_image;


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

      // Firebase
        mFirebaseAuth = FirebaseAuth.getInstance();
       mFirebaseUser =mFirebaseAuth.getCurrentUser();
        if(mFirebaseUser!=null)
        {
            name = mFirebaseUser.getDisplayName();
            email = mFirebaseUser.getEmail();
            photoUrl = mFirebaseUser.getPhotoUrl();
        }

       /** user_name = findViewById(R.id.user_name);
        user_email=  findViewById(R.id.user_email);
        user_image = findViewById(R.id.user_photo);

        user_name.setText(name);
        user_email.setText(email);
        user_image.setImageURI(photoUrl);
        **/
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.exame_nav) {
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