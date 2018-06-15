package com.gdrider.gd.main.presenter;

import android.database.Cursor;

import com.gdrider.gd.main.contract.Contract;
import com.gdrider.gd.main.model.DataBase;

import java.util.ArrayList;

public class Presenter implements Contract.Presenter{

    private Contract.View view;
    private ArrayList<String> title;
    private ArrayList<String> color;
    private ArrayList<Integer> price;
    private ArrayList<Integer> image;

    public Presenter(Contract.View view) {
        this.view = view;
        this.title = new ArrayList<>();
        this.color = new ArrayList<>();
        this.price = new ArrayList<>();
        this.image = new ArrayList<>();
    }

    @Override
    public void getNews(){
        Cursor cursor = DataBase.getInstance().getDB().getAllData();
        if(cursor.getCount()!=0)cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            title.add(cursor.getString(1));
            color.add(cursor.getString(2));
            price.add(cursor.getInt(3));
            image.add(cursor.getInt(4));
            cursor.moveToNext();
        }
        view.setNews(title, color, price, image);
    }

    @Override
    public void getEven(){
        Cursor cursor = DataBase.getInstance().getDB().getAllData();
        if(cursor.getCount()!=0)cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            title.add(cursor.getString(1));
            color.add(cursor.getString(2));
            price.add(cursor.getInt(3));
            image.add(cursor.getInt(4));
            cursor.moveToNext();
        }
        view.setEven(title, color, price, image);
    }

    @Override
    public void getCart(){
        Cursor cursor = DataBase.getInstance().getDB().getAllData();
        if(cursor.getCount()!=0)cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            title.add(cursor.getString(1));
            color.add(cursor.getString(2));
            price.add(cursor.getInt(3));
            image.add(cursor.getInt(4));
            cursor.moveToNext();
        }
        view.setCart(title, color, price, image);
    }

    @Override
    public void getFavo(){
        Cursor cursor = DataBase.getInstance().getDB().getAllData();
        if(cursor.getCount()!=0)cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            title.add(cursor.getString(1));
            color.add(cursor.getString(2));
            price.add(cursor.getInt(3));
            image.add(cursor.getInt(4));
            cursor.moveToNext();
        }
        view.setFavo(title, color, price, image);
    }

    @Override
    public void showToast(String string){
        view.setToast(string);
    }
}
