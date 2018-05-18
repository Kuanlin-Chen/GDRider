package com.gdrider.gd.main.model;

import com.gdrider.gd.R;

import java.util.ArrayList;

public class EvenModel {

    private String string;
    private ArrayList<String> productText;
    private ArrayList<Integer> productImage;

    public EvenModel(){
        this.string = " SOL SF3 素色 黑 全罩安全帽 9折";
        this.productText = new ArrayList<>();
        this.productImage = new ArrayList<>();
    }

    public ArrayList<String> getText(){
        for(int i = 0; i < 5; i++){
            productText.add(i + string);
        }
        return productText;
    }

    public ArrayList<Integer> getImage(){
        for(int i = 0; i < 5; i++){
            productImage.add(R.drawable.gdemo_2);
        }
        return productImage;
    }
}