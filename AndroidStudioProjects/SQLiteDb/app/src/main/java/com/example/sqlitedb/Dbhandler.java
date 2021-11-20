package com.example.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Dbhandler extends SQLiteOpenHelper {
    public Dbhandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create;
        create = "CREATE TABLE myemployee(sno INTEGER PRIMARY KEY,name TEXT,increment TEXT)" ;
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"employee"});
        onCreate(db);
    }

    public void addEmployee(Employee emp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", emp.getName());
        values.put("increment", emp.getName());
        long k = db.insert("myemployee", null, values);
        Log.d("mytag", Long.toString(k));
        db.close();
    }

    public void getEmployee(int sno) {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("myemployee",new String[]{"sno","name","increment"},"sno",new String[]{"sno"},null,null,null  );
        if(cursor!=null && cursor.moveToFirst()){
            Log.d("mytag",cursor.getString(1));
            Log.d("mytag",cursor.getString(2));
        }
        else{
            Log.d("mytag","Some error occured");
        }
}}
