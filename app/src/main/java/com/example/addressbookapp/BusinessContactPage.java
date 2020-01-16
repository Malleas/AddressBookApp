package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BusinessContactPage extends AppCompatActivity {

    Button btn_businessPhotoUpload, btn_addNewBusinessContact;

    EditText et_businessZipCode, et_businessState, et_businessCity, et_businessStreetAddress,
    et_businessPhotoDescription, et_businessPhotoDate, et_businessPhotoName, et_businessPhoneEntry,
    et_businessNameEntry, et_businessOpeningTime, et_businessClosingTime, et_businessWebsiteUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_contact);

        btn_addNewBusinessContact = findViewById(R.id.btn_addNewBusinessContact);
        btn_businessPhotoUpload = findViewById(R.id.btn_businessPhotoUpload);

        et_businessZipCode = findViewById(R.id.et_businessZipCode);
        et_businessState = findViewById(R.id.et_businessState);
        et_businessCity = findViewById(R.id.et_businessCity);
        et_businessStreetAddress = findViewById(R.id.et_businessStreetAddress);
        et_businessPhotoDescription = findViewById(R.id.et_businessPhotoDescription);
        et_businessPhotoDate = findViewById(R.id.et_businessPhotoDate);
        et_businessPhotoName = findViewById(R.id.et_businessPhotoName);
        et_businessPhoneEntry = findViewById(R.id.et_businessphoneEntry);
        et_businessNameEntry = findViewById(R.id.et_businessNameEntry);
        et_businessOpeningTime = findViewById(R.id.et_businessOpeningTime);
        et_businessClosingTime = findViewById(R.id.et_businessClosingTime);
        et_businessWebsiteUrl = findViewById(R.id.et_businessWebsiteUrl);

        btn_addNewBusinessContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
