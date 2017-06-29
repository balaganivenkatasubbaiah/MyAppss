package com.example.myapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapp.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity
{
    Fragment fragment;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        fragment = new HomeFragment(context);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container, fragment).commit();
        //Hi upadted
        //Hi again updated
    }
}
