package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ShowAllContacts extends AppCompatActivity {

    Button btn_back;
    ListView lv_contactList;
    AddressBook book = new AddressBook();
    FileAccessService fileAccessService = new FileAccessService();
    ContactAdapter adapter;
    MyContacts myContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_contacts);


        btn_back = findViewById(R.id.btn_back);
        lv_contactList = findViewById(R.id.lv_contactList);
        myContacts = ((MyApplication) this.getApplication()).getMyContacts();
        adapter = new ContactAdapter(ShowAllContacts.this, myContacts);
        lv_contactList.setAdapter(adapter);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
