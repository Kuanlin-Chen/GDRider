package com.gdrider.gd.main.presenter;

import android.database.Cursor;

import com.gdrider.gd.main.contract.EvenContract;
import com.gdrider.gd.main.model.DataBase;

import java.util.ArrayList;

public class EvenPresenter implements EvenContract.EvenPresenter{

    private EvenContract.EvenView view;
    private ArrayList<String> title;
    private ArrayList<String> color;
    private ArrayList<Integer> price;
    private ArrayList<Integer> image;

    public EvenPresenter(EvenContract.EvenView view) {
        this.view = view;
        this.title = new ArrayList<>();
        this.color = new ArrayList<>();
        this.price = new ArrayList<>();
        this.image = new ArrayList<>();
    }

    @Override
    public void getNewEvent() {
        Cursor cursor = DataBase.getInstance().getDB().getAllData();
        if(cursor.getCount()!=0)cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            title.add(cursor.getString(1));
            color.add(cursor.getString(2));
            price.add(cursor.getInt(3));
            image.add(cursor.getInt(4));
            cursor.moveToNext();
        }
        view.setNewEvent(title, color, price, image);
    }
}
