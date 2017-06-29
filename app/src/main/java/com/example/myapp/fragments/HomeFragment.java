package com.example.myapp.fragments;


import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.adapter.ViewPageAdapter;
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
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 2134 on 6/27/2017.
 */

public class HomeFragment extends Fragment implements ResponseListener
{

    ViewPager viewPager;

    GetAndPostAsyncTask getBannerListTask;

    Context context;
    String session_id, status;

    BannerGroupDto bannerGroupDto;
    ArrayList<BannerDto> bannerlst = new ArrayList<BannerDto>();
    private int currentPage;
    private ViewPageAdapter viewPagerAdapter;
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        session_id = sharedPref.getString("session_id", "1");
        status = sharedPref.getString("status", "");
    }

    public HomeFragment(Context context)
    {
        this.context =context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position) {

                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
                if(state == ViewPager.SCROLL_STATE_IDLE)
                {
                    //int pageCount = viewPagerAdapter.getCount();

                    /*if(currentPage == 0)
                    {
                        viewPager.setCurrentItem(pageCount-1,false);
                    }
                    else if(currentPage == pageCount-1)
                    {
                        viewPager.setCurrentItem(1,false);
                    }*/
                }

            }
        });

        try
        {
            getBannerListTask = new GetAndPostAsyncTask(context, new URL(Constants.Banner_images+Constants.SID_url_ll+session_id),HomeFragment.this,false);
            getBannerListTask.execute("");
        }catch (MalformedURLException e)
        {
            e.printStackTrace();
        }



        return view;
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
                Toast.makeText(context, "Banner size"+bannerGroupDto.getBannersList().size(), Toast.LENGTH_SHORT).show();

                viewPagerAdapter = new ViewPageAdapter(context,bannerGroupDto.getBannersList());
                viewPager.setAdapter(viewPagerAdapter);
                // Auto start of viewpager
                final Handler handler = new Handler();
                final Runnable Update = new Runnable() {
                    public void run() {
                        if (currentPage == bannerGroupDto.getBannersList().size()) {
                            currentPage = 0;
                        }
                        viewPager.setCurrentItem(currentPage++, true);
                    }
                };
                Timer swipeTimer = new Timer();
                swipeTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(Update);
                    }
                }, 3000, 3000);



            }
            if(jsonObject.has("token"))
            {
                bannerGroupDto.setToken(jsonObject.getString("token"));
            }


        }


    }
}
