package com.boardinfinity.coffeetime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(Context context) {
        super(context, "RegisteredUser", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Register(Id INTEGER PRIMARY KEY AUTOINCREMENT,Username TEXT,Email TEXT,Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Regsiter");
        onCreate(db);


    }
    long insertRegisterDataInTable(String uname,String email,String pass){
        ContentValues contentValues=new ContentValues();
        contentValues.put("Username",uname);
        contentValues.put("Email",email);
        contentValues.put("Password",pass);

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        long id=sqLiteDatabase.insert("Register",null,contentValues);
        return  id;
    }

    public Cursor getalldata(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from Register",null);
        return res;
    }

    public Cursor getalldatarow(String em){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();


        Cursor  cursor = sqLiteDatabase.rawQuery("SELECT * FROM Register WHERE Email = ? LIMIT 1",
                new String[]{em});

        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                "Id"
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = "Email" + " = ?" + " AND " + "Password" + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query("Register", //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }



    public boolean checkEmailAlready(String email) {

        // array of columns to fetch
        String[] columns = {
                "Id"
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = "Email" + " = ?";

        // selection arguments
        String[] selectionArgs = {"Id"};

        Cursor cursor = db.query("Register", //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }


}
