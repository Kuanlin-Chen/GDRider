package com.gdrider.gd.main.model;

import com.gdrider.gd.R;

import java.util.ArrayList;

public class CartModel {

    private String string;
    private ArrayList<String> productText;
    private ArrayList<Integer> productImage;

    public CartModel(){
        this.string = " 購物車測試";
        this.productText = new ArrayList<>();
        this.productImage = new ArrayList<>();
    }

    public ArrayList<String> getText(){
        for(int i = 0; i < 2; i++){
            productText.add(i + string);
        }
        return productText;
    }

    public ArrayList<Integer> getImage(){
        for(int i = 0; i < 2; i++){
            productImage.add(R.drawable.gdemo_2);
        }
        return productImage;
    }
}
