package com.example.myapp.dto;

import java.util.ArrayList;

/**
 * Created by 2134 on 7/3/2017.
 */

public class NewProductsDto
{
    private String productName,productType,productSku,productDescription,productShortDescription,producrImage;
    private int product_id;
    private int isInStock;
    private int isSalebel;
    private int productPrice;
    private int finalPrice;
    private int minPrice;
    private int maxPrice;
    private int minimalPrice;

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    private int productStock;

    private ArrayList<NewProductsDto> newProductsList;
    public ArrayList<NewProductsDto> getNewProductsList() {
        return newProductsList;
    }

    public void setNewProductsList(ArrayList<NewProductsDto> newProductsList) {
        this.newProductsList = newProductsList;
    }


    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductShortDescription() {
        return productShortDescription;
    }

    public void setProductShortDescription(String productShortDescription) {
        this.productShortDescription = productShortDescription;
    }

    public String getProducrImage() {
        return producrImage;
    }

    public void setProducrImage(String producrImage) {
        this.producrImage = producrImage;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getIsInStock() {
        return isInStock;
    }

    public void setIsInStock(int isInStock) {
        this.isInStock = isInStock;
    }

    public int getIsSalebel() {
        return isSalebel;
    }

    public void setIsSalebel(int isSalebel) {
        this.isSalebel = isSalebel;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinimalPrice() {
        return minimalPrice;
    }

    public void setMinimalPrice(int minimalPrice) {
        this.minimalPrice = minimalPrice;
    }


}
