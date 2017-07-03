package com.example.myapp.dto;

import java.util.ArrayList;

/**
 * Created by 2134 on 7/3/2017.
 */

public class NewProductsGroupDto
{
    private String productToken;

    private ArrayList<NewProductsDto> productItemsList;
    public String getProductToken() {
        return productToken;
    }

    public void setProductToken(String productToken) {
        this.productToken = productToken;
    }

    public ArrayList<NewProductsDto> getProductItemsList() {
        return productItemsList;
    }

    public void setProductItemsList(ArrayList<NewProductsDto> productItemsList) {
        this.productItemsList = productItemsList;
    }


}
