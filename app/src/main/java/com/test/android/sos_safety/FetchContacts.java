package com.test.android.sos_safety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.android.sos_safety.Contacts.Contacts;
import com.test.android.sos_safety.Data.DbHandler;

import java.util.ArrayList;
import java.util.List;

public class FetchContacts extends AppCompatActivity {

    DbHandler db = new DbHandler(FetchContacts.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_contacts);

        ArrayList<String> contacts = new ArrayList<>();

        // Get all contacts
        List<Contacts> allContacts = db.getAllContacts();
        ListView listView = findViewById(R.id.listView);

        for(Contacts contact: allContacts)
        {
            contacts.add(contact.getName() + " (" + contact.getPhoneNumber() + ")");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);

        getIntent();
    }

    void setDb(DbHandler db)
    {
        this.db = db;
    }
}
