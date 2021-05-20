package com.ptit.thuchanh2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler  {
    private static final String DATABASE_NAME = "mydb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "product";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE= "price";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_LOAI = "loai";
    SQLiteDatabase db;
    public DatabaseHandler() {

        SQLiteDatabase db = null;

        try {
            db = SQLiteDatabase.openOrCreateDatabase(Const.LINK_DB, null);
            onCreate(db);
        }
        catch (SQLiteException ex) {
        } finally {
            if(db== null){
            db.close();
            }
        }
    }
    private static DatabaseHandler instance;
    public static DatabaseHandler getInstance(){
        if(instance == null){
            instance=new DatabaseHandler();
        }
        return instance;
    }
    public void onCreate(SQLiteDatabase db) {
        String create_students_table = String.format("CREATE TABLE %s(%s TEXT, %s TEXT, %s TEXT,%s TEXT)", TABLE_NAME, KEY_NAME, KEY_PRICE, KEY_IMAGE,KEY_LOAI);
        db.execSQL(create_students_table);
    }


    public void onUpgrade(int oldVersion, int newVersion) {
    }

    public void onInsert(SanPham sanPham){
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(Const.LINK_DB, null);
        String insert=String.format("Insert into %s values (%s,%s,%s,%s)",TABLE_NAME,sanPham.getName(),sanPham.getGia(),sanPham.getImage(),sanPham.getLoai());
        db.execSQL(insert);
        db.close();
    }
    public List<SanPham> read(){
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(Const.LINK_DB, null);
        List<SanPham> sanPhams=new ArrayList<>();
        String select=String.format("SELECT * FROM %s",TABLE_NAME);
        Cursor cursor = db.rawQuery(select, null);
        if(cursor != null) {
            cursor.moveToFirst();
            while(cursor.isAfterLast() == false) {
               SanPham sanPham=new SanPham(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
               sanPhams.add(sanPham);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return sanPhams;
    }


}
