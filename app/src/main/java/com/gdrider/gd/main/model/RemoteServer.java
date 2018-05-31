package com.gdrider.gd.main.model;

import com.gdrider.gd.R;

import java.util.ArrayList;

public class RemoteServer {

    /*  This is a template for testing
     *  Simulate that getting data from server
     */

    private final String label = "RemoteServer:";
    private ArrayList<String> productTitle;
    private ArrayList<String> productColor;
    private ArrayList<Integer> productPrice;
    private ArrayList<Integer> productImage;
    private String stringTitle = "SOL 全罩式安全帽";
    private String stringColor = "消光黑";
    private Integer integerPrice = 2700;
    private Integer integerImage = R.drawable.gdemo;
    private int count = 10;

    public RemoteServer(){
        this.productTitle = new ArrayList<>();
        this.productColor = new ArrayList<>();
        this.productPrice = new ArrayList<>();
        this.productImage = new ArrayList<>();
    }

    public ArrayList<String> getTitle(){
        for(int i = 0; i < count; i++){
            productTitle.add(stringTitle);
        }
        return productTitle;
    }

    public ArrayList<String> getColor(){
        for(int i = 0; i < count; i++){
            productColor.add(stringColor);
        }
        return productColor;
    }

    public ArrayList<Integer> getPrice(){
        for(int i = 0; i < count; i++){
            productPrice.add(integerPrice);
        }
        return productPrice;
    }

    public ArrayList<Integer> getImage(){
        for(int i = 0; i < count; i++){
            productImage.add(integerImage);
        }
        return productImage;
    }
}
