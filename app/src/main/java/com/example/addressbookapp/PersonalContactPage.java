package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalContactPage extends AppCompatActivity {

    Button btn_personalPhotoUpload, btn_addNewPersonalContact;
    EditText et_personalCity, et_personalNameEntry, et_personalPhoneEntry, et_personalPhotoName,
    et_personalPhotoDescription, et_personalPhotoDate, et_personalStreetAddress, et_personalState,
    et_personalZipCode, et_personalDateOfBirth, et_personalContactDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_contact);

        btn_addNewPersonalContact = findViewById(R.id.btn_addNewPersonalContact);
        btn_personalPhotoUpload = findViewById(R.id.btn_personalPhotoUpload);

        et_personalCity = findViewById(R.id.et_personalCity);
        et_personalContactDescription = findViewById(R.id.et_personalContactDescription);
        et_personalDateOfBirth = findViewById(R.id.et_personalDateOfBirth);
        et_personalNameEntry = findViewById(R.id.et_personalNameEntry);
        et_personalPhoneEntry = findViewById(R.id.et_personalPhoneEntry);
        et_personalPhotoName = findViewById(R.id.et_personalPhotoName);
        et_personalPhotoDescription = findViewById(R.id.et_personalPhotoDescription);
        et_personalPhotoDate = findViewById(R.id.et_personalPhotoDate);
        et_personalStreetAddress = findViewById(R.id.et_personalStreetAddress);
        et_personalState = findViewById(R.id.et_personalState);
        et_personalZipCode = findViewById(R.id.et_personalZipCode);

        btn_addNewPersonalContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
