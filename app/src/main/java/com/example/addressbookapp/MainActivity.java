package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_addContact, btn_showAllContacts, btn_showContactById, btn_editContactById, btn_searchName,
    btn_searchCity, btn_searchDescription, btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_addContact = findViewById(R.id.btn_addContact);
        btn_showAllContacts = findViewById(R.id.btn_showAllContacts);
        btn_showContactById = findViewById(R.id.btn_showContactById);
        btn_editContactById = findViewById(R.id.btn_editContactById);
        btn_searchName = findViewById(R.id.btn_searchName);
        btn_searchCity = findViewById(R.id.btn_searchCity);
        btn_searchDescription = findViewById(R.id.btn_searchDescription);
        btn_exit = findViewById(R.id.btn_exit);
    }
}
