package com.gdrider.gd.main.model;

import com.gdrider.gd.R;

import java.util.ArrayList;

public class NewsModel {

    private String string;
    private ArrayList<String> productText;
    private ArrayList<Integer> productImage;

    public NewsModel(){
        this.string = " SOL 迷彩 消光黑";
        this.productText = new ArrayList<>();
        this.productImage = new ArrayList<>();
    }

    public ArrayList<String> getText(){
        for(int i = 0; i < 11; i++){
            productText.add(i + string);
        }
        return productText;
    }

    public ArrayList<Integer> getImage(){
        for(int i = 0; i < 11; i++){
            productImage.add(R.drawable.gdemo);
        }
        return productImage;
    }
}
