package com.example.myapp.utils;

import com.example.myapp.dto.NewProductsDto;
import com.example.myapp.dto.NewProductsGroupDto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 2134 on 7/3/2017.
 */

public class JsonPrsers
{
    public NewProductsGroupDto getNewProductsList(String response) throws JSONException
    {
        NewProductsGroupDto groupDto = new NewProductsGroupDto();
        JSONObject jsonObject = new JSONObject(response);
        if(jsonObject.has("token"))
        {
            groupDto.setProductToken(jsonObject.getString("token"));
        }
        if(jsonObject.has("products"))
        {
            JSONArray jsonArray = jsonObject.getJSONArray("products");

            for(int i=0; i <jsonArray.length() ; i++)
            {

            }
        }

        return  groupDto;
    }

    public NewProductsDto getNewProductsDetails(JSONObject jsonObject) throws  JSONException
    {
        NewProductsDto newProductsDto = new NewProductsDto();

        if(jsonObject.has("product_id"))
        {
            newProductsDto.setProduct_id(jsonObject.getInt("product_id"));
        }
        if(jsonObject.has("name"))
        {
            newProductsDto.setProductName(jsonObject.getString("name"));
        }
        if(jsonObject.has("sku"))
        {
            newProductsDto.setProductSku(jsonObject.getString("sku"));
        }
        if(jsonObject.has("type"))
        {
            newProductsDto.setProductType(jsonObject.getString("type"));
        }
        if(jsonObject.has("stock"))
        {
            newProductsDto.setProductStock(jsonObject.getInt("stock"));
        }
        if(jsonObject.has("is_in_stock"))
        {
            newProductsDto.setIsInStock(jsonObject.getInt("is_in_stock"));
        }
        if(jsonObject.has("is_saleable"))
        {
            newProductsDto.setIsSalebel(jsonObject.getInt("is_saleable"));
        }

        return null;
    }
}
