package com.example.androidphpmysql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {

    private TextView textViewUsername, textViewUseremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }
        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewUseremail = (TextView) findViewById(R.id.textViewUseremail);

        textViewUseremail.setText(SharedPrefManager.getInstance(this).getUseremail());
        textViewUsername .setText(SharedPrefManager.getInstance(this).getUsername());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
       if (id == R.id.menuLogout){
           SharedPrefManager.getInstance(this).logout();
           finish();
           startActivity(new Intent(this, LoginActivity.class));
       }
       else if (id == R.id.menuSettings) {
           Toast.makeText(this,"You clicked Settings",Toast.LENGTH_LONG).show();

       }
        return true;
    }
}