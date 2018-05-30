package com.gdrider.gd.main.model;

import android.content.Context;

public class DataBase {

    private static DatabaseHelper mDataBase;
    private static DataBase instance;

    private DataBase(){}

    public static DataBase getInstance(){
        if(instance == null){
            instance = new DataBase();
        }
        return instance;
    }

    public void initDB(Context context){
        mDataBase = new DatabaseHelper(context);
    }

    public DatabaseHelper getDB() {
        return mDataBase;
    }
}
