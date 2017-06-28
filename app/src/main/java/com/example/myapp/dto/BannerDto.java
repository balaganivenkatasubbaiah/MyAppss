package com.example.myapp.dto;

import java.util.ArrayList;

/**
 * Created by 2134 on 6/28/2017.
 */

public class BannerDto
{
    private String images;
    private ArrayList<BannerDto> bannerList;

    public void setBannerList(ArrayList<BannerDto> bannerList) {
        this.bannerList = bannerList;
    }

    public ArrayList<BannerDto> getBannerList() {
        return bannerList;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
