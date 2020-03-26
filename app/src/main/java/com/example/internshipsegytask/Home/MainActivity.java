package com.example.internshipsegytask.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.internshipsegytask.R;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      FragmentManager mFragmentManager = getSupportFragmentManager();
      mFragmentManager.beginTransaction().replace(R.id.replace,new HomeFragment()).commit();


    }








}
