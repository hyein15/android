package com.example.logger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE logger (_id INTEGER PRIMARY KEY AUTOINCREMENT, item TEXT, price TEXT, create_at TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String create_at, String item, String price) { //data, item, price
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO logger VALUES(null, '" + item + "', '"  + price + "', '" + create_at + "');");
        db.close();

    }

    public void delete(String item) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM logger WHERE item='" + item + "';");
        db.close();
    }

    public String getResult() {

        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM logger", null);
        while (cursor.moveToNext()) {
            result +=
                     cursor.getString(3) +"\n"//날짜
                    + " 위치 : "
                    + cursor.getString(2)+"\n" //위치
                    + " 내용 : "
                    + cursor.getString(1)+"\n" //내용
                    + "\n"
                    + "--------------------------------------" +"\n";

        }

        return result;
    }
}


