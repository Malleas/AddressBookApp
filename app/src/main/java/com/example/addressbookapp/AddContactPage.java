package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddContactPage extends AppCompatActivity {

    Button btn_addPersonalContact, btn_addBusinessContact, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact_page);

        btn_addBusinessContact = findViewById(R.id.btn_addBusinessContact);
        btn_addPersonalContact = findViewById(R.id.btn_addPersonalContact);
        btn_back = findViewById(R.id.btn_back);

        btn_addPersonalContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PersonalContactPage.class);
                startActivity(intent);
            }
        });

        btn_addBusinessContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BusinessContactPage.class);
                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
