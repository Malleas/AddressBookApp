package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btn_addContact, btn_showAllContacts, btn_searchForContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyContacts myContacts;
        MyApplication myApplication = (MyApplication) this.getApplication();
        myContacts = myApplication.getMyContacts();

       if(myContacts == null){
           InputStream inputStream = getResources().openRawResource(R.raw.contactlist);
           try {
               myContacts = new MyContacts(inputStream);
           } catch (IOException e) {
               e.printStackTrace();
           }
           myApplication.setMyContacts(myContacts);
       }



        btn_addContact = findViewById(R.id.btn_addNewPersonalContact);
        btn_showAllContacts = findViewById(R.id.btn_showAllContacts);
        btn_searchForContacts = findViewById(R.id.btn_searchForContacts);

        btn_addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddContactPage.class);
                startActivity(intent);
            }
        });

        btn_showAllContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ShowAllContacts.class);
                startActivity(intent);
            }
        });

        btn_searchForContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SearchPage.class);
                startActivity(intent);
            }
        });



    }
}
