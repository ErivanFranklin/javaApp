package com.example.erivan.marvelapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "total";
    private static final String COLLUMN_ID = "id";
    private static final String TABLE_NAME = "users";
    private static final String COLLUMN_NAME = "name";
    private static final String COLLUMN_EMAIL = "email";
    private static final String COLLUMN_PASSWORD = "password";

    SQLiteDatabase db;

    private static final String CREATE_TABLE = "create table users (id integer primary key not null," +
            "name text not null, email text not null, password text not null)";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        this.db = db;
    }

    public void insertContact(Contact c){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();

        values.put(COLLUMN_ID, count);
        values.put(COLLUMN_NAME, c.getName());
        values.put(COLLUMN_EMAIL, c.getEmail());
        values.put(COLLUMN_PASSWORD, c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchUser(String email){
        db = this.getReadableDatabase();
        String query = "SELECT email, password FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "Not Found";

        if (cursor.moveToFirst()){

            do{

                a = cursor.getString(0);
                if (a.equals(email)){
                    b = cursor.getString(1);
                }

            }while (cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        this.onCreate(db);
        db.execSQL(query);
    }
}
