package com.gdrider.gd.main.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Favo.db";
    public static final String TABLE_NAME = "favo_table";
    public static final String COL_ID = "ID";
    public static final String COL_TITLE = "TITLE";
    public static final String COL_COLOR = "COLOR";
    public static final String COL_PRICE = "PRICE";
    public static final String COL_IMAGE = "IMAGE";
    public static final String COL_FAVO = "FAVO";
    public static final String COL_CART = "CART";

    //Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        //"create table這裡要空一格" "空一格(ID INTEGER......)"
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, COLOR TEXT, PRICE REAL, IMAGE INTEGER, FAVO INTEGER DEFAULT 0, CART INTEGER DEFAULT 0)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id, String title, String color, int price, int image, int favo, int cart) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_ID, id);
        contentValues.put(COL_TITLE, title);
        contentValues.put(COL_COLOR, color);
        contentValues.put(COL_PRICE, price);
        contentValues.put(COL_IMAGE, image);
        contentValues.put(COL_FAVO, favo);
        contentValues.put(COL_CART, cart);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME, null);
        return res;
    }

    public Cursor getAllTitle() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_title = db.rawQuery("select "+COL_TITLE+" from "+TABLE_NAME, null);
        return res_title;
    }

    public Cursor getAllColor() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_color = db.rawQuery("select "+COL_COLOR+" from "+TABLE_NAME, null);
        return res_color;
    }

    public Cursor getAllPrice() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_price = db.rawQuery("select "+COL_PRICE+" from "+TABLE_NAME, null);
        return res_price;
    }

    public Cursor getAllImage() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_image = db.rawQuery("select "+COL_IMAGE+" from "+TABLE_NAME, null);
        return res_image;
    }

    public Cursor getPrice(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_price = db.rawQuery("select "+COL_PRICE+" from "+TABLE_NAME+" where "+COL_TITLE+" like '"+title+"'", null);
        return res_price;
    }

    public Cursor getAverage() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_ave = db.rawQuery("select avg(PRICE) from "+TABLE_NAME, null);
        return res_ave;
    }

    public Cursor getCount() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_count = db.rawQuery("select count(TITLE) from "+TABLE_NAME+" where TITLE is not null", null);
        return res_count;
    }

    public boolean updateData(String id, String title, String color, int price, int image, int favo, int cart) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_ID, id);
        contentValues.put(COL_TITLE, title);
        contentValues.put(COL_COLOR, color);
        contentValues.put(COL_PRICE, price);
        contentValues.put(COL_IMAGE, image);
        contentValues.put(COL_FAVO, favo);
        contentValues.put(COL_CART, cart);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] { id });
        return true;
    }

    public boolean searchData(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res_search = db.rawQuery("select "+COL_TITLE+" from "+TABLE_NAME+" where "+COL_TITLE+" like '"+title+"'", null);
        res_search.moveToFirst();
        String titleName = new String();

        if(res_search.getCount()==0) {
            titleName = "xyzzz";
        } else {
            titleName = res_search.getString(0);
        }

        if (titleName.equals(title)) {
            return true;
        } else {
            return false;
        }
    }
}