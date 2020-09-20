package com.m2mapp.m2mapp.model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private String purchaseOderNo;
    private List<Product> productList;

    public ProductList() {
        this.purchaseOderNo = purchaseOderNo;
        this.productList = productList;
        productList =new ArrayList<>();
    }


    public String getPurchaseOderNo() {
        return purchaseOderNo;
    }

    public void setPurchaseOderNo(String purchaseOderNo) {
        this.purchaseOderNo = purchaseOderNo;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product findByName(String name) {

        for (Product p : productList) {

            if (p.getItem().getName().equals(name))
                return p;
        }
        return null;

    }


    public void addProduct(Product p,Integer quantity){

       Product tempProduct= findByName(p.getItem().getName());
       if(tempProduct==null){
           p.setQuantity(quantity);
           productList.add(p);
       }
       else{

           Integer newQuantity=tempProduct.getQuantity()+quantity;
          tempProduct.setQuantity(newQuantity);

       }

    }

    public void removeProduct(String name){

        for(Product p:productList)

        {
            if(p.getItem().getName().equals("name"))

            {

                productList.remove(p);
                break;
            }
        }
    }
}