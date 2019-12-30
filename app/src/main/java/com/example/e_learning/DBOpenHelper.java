package com.example.e_learning;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context,String name, CursorFactory factory,
                        int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table if not exists user_tb(_id integer primary key autoincrement," +
                "userID text not null," +
                "pwd text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}