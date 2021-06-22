package com.example.homework5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment, new MainFragment());
        fragmentTransaction.commit();

       bottomNavigationView = findViewById(R.id.bottom_navigation);

       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
               switch (item.getItemId()){
                   case R.id.main_btn:
                       transaction.replace(R.id.fragment, MainFragment.newInstance("value 1", "value 2")).commit();
                       item.setChecked(true);
                       break;
                   case R.id.list_btn:
                       transaction.replace(R.id.fragment, ListFragment.newInstance("value 2", "value 2")).commit();
                       item.setChecked(true);
                       break;
                   case R.id.profile_btn:
                       transaction.replace(R.id.fragment,PersonFragment.newInstance("value 3", "value3")).commit();
                       item.setChecked(true);
                       break;
               }
               return false;
           }
       });
    }
}