package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapp.Adapters.FragmentsAdapter;
import com.example.myapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;
    ActivityMainBinding Binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater() ;
        inflater.inflate(R.menu.menu , menu  );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

         switch(item.getItemId())
         {
             case R.id.settings:
                 Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                 break;

             case R.id.logout:
                 auth.signOut();
                 Intent intent = new Intent(MainActivity.this , SignInActivity.class );
                 startActivity(intent);
                 break;

             case R.id.groupChat:
                 Intent intentt= new Intent(MainActivity.this , GroupChatActivity.class );
                 startActivity(intentt);
                 break;

         }
         return super.onOptionsItemSelected(item);
    }
}