package com.test.android.sos_safety.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.test.android.sos_safety.Contacts.Contacts;
import com.test.android.sos_safety.Parameters.Parameters;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper
{
    public DbHandler(Context context)
    {
        super(context, Parameters.DB_NAME, null, Parameters.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String create = "CREATE TABLE " + Parameters.TABLE_NAME + "(" + Parameters.KEY_ID + " INTEGER PRIMARY KEY," + Parameters.KEY_NAME + " TEXT, " + Parameters.KEY_PHONE + " TEXT" + ")";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void addContact(Contacts contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Parameters.KEY_NAME, contact.getName());
        values.put(Parameters.KEY_PHONE, contact.getPhoneNumber());


        db.insert(Parameters.TABLE_NAME, null, values);
        db.close();
    }

    public List<Contacts> getAllContacts(){
        List<Contacts> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generate the query to read from the database
        String select = "SELECT * FROM " + Parameters.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        //Loop through now
        if(cursor.moveToFirst())
        {
            do
            {
                Contacts contact = new Contacts();
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }

            while(cursor.moveToNext());
        }

        cursor.close();

        return contactList;
    }

    public void deleteContact(String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Parameters.TABLE_NAME, Parameters.KEY_PHONE +"=?", new String[]{String.valueOf(phone)});
        db.close();
    }
}
