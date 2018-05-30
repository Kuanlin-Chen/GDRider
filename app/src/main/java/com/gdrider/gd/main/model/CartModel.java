package com.gdrider.gd.main.model;

import android.database.Cursor;

import com.gdrider.gd.R;

import java.util.ArrayList;

public class CartModel {

    private final String label = "CartModel:";
    private String string;
    private ArrayList<String> productTitle;
    private ArrayList<String> productColor;
    private ArrayList<Integer> productPrice;
    private ArrayList<Integer> productImage;

    public CartModel(){
        this.string = " 購物車測試";
        this.productTitle = new ArrayList<>();
        this.productColor = new ArrayList<>();
        this.productPrice = new ArrayList<>();
        this.productImage = new ArrayList<>();
    }

    public ArrayList<String> getTitle(){
        Cursor cursor = DataBase.getInstance().getDB().getAllTitle();
        if(cursor.getCount()!=0)cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            System.out.println(label+cursor.getString(0));
            productTitle.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return productTitle;
    }

    public ArrayList<String> getColor(){
        Cursor cursor = DataBase.getInstance().getDB().getAllColor();
        if(cursor.getCount()!=0)cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            System.out.println(label+cursor.getString(0));
            productColor.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return productColor;
    }

    public ArrayList<Integer> getPrice(){
        Cursor cursor = DataBase.getInstance().getDB().getAllPrice();
        if(cursor.getCount()!=0)cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            System.out.println(label+cursor.getInt(0));
            productPrice.add(cursor.getInt(0));
            cursor.moveToNext();
        }
        return productPrice;
    }

    public ArrayList<Integer> getImage(){
        Cursor cursor = DataBase.getInstance().getDB().getAllData();
        int count = cursor.getCount();
        for(int i = 0; i < count; i++){
            productImage.add(R.drawable.gdemo_2);
        }
        return productImage;
    }
}
