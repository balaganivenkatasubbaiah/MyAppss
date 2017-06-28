package com.example.myapp.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.asynch.GetAndPostAsyncTask;
import com.example.myapp.asynch.ResponseListener;
import com.example.myapp.dto.BannerDto;
import com.example.myapp.dto.BannerGroupDto;
import com.example.myapp.utils.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by 2134 on 6/27/2017.
 */

public class HomeFragment extends Fragment implements ResponseListener
{

    ViewPager viewPager;

    GetAndPostAsyncTask getBannerList;

    Context context;
    String session_id, status;

    BannerGroupDto bannerGroupDto;
    ArrayList<BannerDto> bannerlst = new ArrayList<BannerDto>();
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        session_id = sharedPref.getString("session_id", "1");
        status = sharedPref.getString("status", "");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);


        try
        {
            getBannerList = new GetAndPostAsyncTask(getActivity(), new URL(Constants.Banner_images+Constants.SID_url_ll+session_id),HomeFragment.this,false);
        }catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void serverResponse(String response, String path) throws Exception
    {

        if(path.contains(Constants.Banner_images))
        {
            bannerGroupDto = new BannerGroupDto();

            JSONObject jsonObject = new JSONObject(response);

            if(jsonObject.has("images"))
            {
                JSONArray jsonArray = jsonObject.getJSONArray("images");

                for(int i=0;i<jsonArray.length();i++)
                {
                    BannerDto bannerDto = new BannerDto();
                    bannerDto.setImages(""+jsonArray.get(i));

                    bannerlst.add(bannerDto);
                }

                bannerGroupDto.setBannersList(bannerlst);

            }
            if(jsonObject.has("token"))
            {
                bannerGroupDto.setToken(jsonObject.getString("token"));
            }


        }


    }
}
