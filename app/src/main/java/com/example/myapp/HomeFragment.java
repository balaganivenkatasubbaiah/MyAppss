package com.example.myapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.com.example.myapp.connecttoserver.ResponseListener;

import org.json.JSONException;

/**
 * Created by 2134 on 6/27/2017.
 */

public class HomeFragment extends Fragment implements ResponseListener
{

    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void serverResponse(String response, String path) throws Exception
    {


    }
}
