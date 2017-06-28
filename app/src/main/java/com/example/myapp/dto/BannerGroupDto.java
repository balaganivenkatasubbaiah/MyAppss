package com.example.myapp.dto;

import java.util.ArrayList;

/**
 * Created by 2134 on 6/28/2017.
 */

public class BannerGroupDto
{
    private String token;
    private ArrayList<BannerDto> bannersList;

    public ArrayList<BannerDto> getBannersList() {
        return bannersList;
    }

    public void setBannersList(ArrayList<BannerDto> bannersList) {
        this.bannersList = bannersList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}

