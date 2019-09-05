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


public class OrderDatabase extends SQLiteOpenHelper {

    public OrderDatabase(Context context) {
        super(context, "Order", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Orderlist(Id INTEGER PRIMARY KEY AUTOINCREMENT,Email TEXT,Cappuccino INTEGER,Macchiato INTEGER,Latte INTEGER,Americano INTEGER,Cafemocha INTEGER,Frappe INTEGER,Indonesian_Coffee INTEGER,Ethopian_Coffee INTEGER,Viennese_Coffee INTEGER,Turkish_Coffee INTEGER,Vietnamese INTEGER,Portugal_Coffee INTEGER,Cookies INTEGER,Caremel_Cake INTEGER,Choko_Cake INTEGER,Choco_Bar INTEGER,Milk_Shake INTEGER,Orange_Juice INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Orderlist");
        onCreate(db);


    }
    void insertRegisterDataInTable(String email){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO Orderlist(Email) VALUES('"+email+"');");


    }

    public Cursor getalldata(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from Orderlist",null);
        return res;
    }


    public Cursor getalldatarow(String em){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();


        Cursor  cursor = sqLiteDatabase.rawQuery("SELECT * FROM Orderlist WHERE Email = ? LIMIT 1",
                new String[]{em});

        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }







    public Boolean checkEmailAlready(String email) {

        // array of columns to fetch
        String[] columns = {
                "Email"
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = "Email" + " = ?";

        // selection arguments
        String[] selectionArgs = {email};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query("Orderlist", //Table to query
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


    public void updatevalueitembyId(int id, String itnm,String qnt) {

        ContentValues cvv = new ContentValues();
        cvv.put(itnm,qnt); //These Fields should be your String values of actual column names
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.update("Orderlist",cvv,"Id="+id, null);
    }
    public void clearall(int id) {

        ContentValues cvv = new ContentValues();
        cvv.putNull("Cappuccino");
        cvv.putNull("Macchiato");
        cvv.putNull("Latte");
        cvv.putNull("Americano");
        cvv.putNull("Cafemocha");
        cvv.putNull("Frappe");
        cvv.putNull("Indonesian_Coffee");
        cvv.putNull("Ethopian_Coffee");
        cvv.putNull("Viennese_Coffee");
        cvv.putNull("Turkish_Coffee");
        cvv.putNull("Vietnamese");
        cvv.putNull("Portugal_Coffee");
        cvv.putNull("Cookies");
        cvv.putNull("Caremel_Cake");
        cvv.putNull("Choko_Cake");
        cvv.putNull("Choco_Bar");
        cvv.putNull("Milk_Shake");
        cvv.putNull("Orange_Juice");
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.update("Orderlist",cvv,"Id="+id, null);
    }
}
