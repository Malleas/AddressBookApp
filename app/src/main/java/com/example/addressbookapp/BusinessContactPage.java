package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;
import java.util.UUID;

public class BusinessContactPage extends AppCompatActivity {

    Button btn_addNewBusinessContact;

    EditText et_businessZipCode, et_businessState, et_businessCity, et_businessStreetAddress, et_businessPhoneEntry,
    et_businessNameEntry, et_businessOpeningTime, et_businessClosingTime, et_businessWebsiteUrl, et_businessCompanyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_contact);
        final MyApplication myApplication = (MyApplication) this.getApplication();

        btn_addNewBusinessContact = findViewById(R.id.btn_addNewBusinessContact);

        et_businessZipCode = findViewById(R.id.et_businessZipCode);
        et_businessState = findViewById(R.id.et_businessState);
        et_businessCity = findViewById(R.id.et_businessCity);
        et_businessStreetAddress = findViewById(R.id.et_businessStreetAddress);
        et_businessPhoneEntry = findViewById(R.id.et_businessphoneEntry);
        et_businessNameEntry = findViewById(R.id.et_businessNameEntry);
        et_businessOpeningTime = findViewById(R.id.et_businessOpeningTime);
        et_businessClosingTime = findViewById(R.id.et_businessClosingTime);
        et_businessWebsiteUrl = findViewById(R.id.et_businessWebsiteUrl);
        et_businessCompanyName  = findViewById(R.id.et_businessCompanyName);

        btn_addNewBusinessContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                String id = UUID.randomUUID().toString();
                String type = "Personal";
                int photoId = random.nextInt(16);
                String name = et_businessNameEntry.getText().toString();
                String phoneNumber = et_businessPhoneEntry.getText().toString();
                String streetAddress = et_businessStreetAddress.getText().toString();
                String city = et_businessCity.getText().toString();
                String state = et_businessState.getText().toString();
                int zipCode = Integer.parseInt(et_businessZipCode.getText().toString());
                int openTime = Integer.parseInt(et_businessOpeningTime.getText().toString());
                int closeTime = Integer.parseInt(et_businessClosingTime.getText().toString());
                String website = et_businessWebsiteUrl.getText().toString();
                String businessName = et_businessCompanyName.getText().toString();
                Location location = new Location(streetAddress, city, state, zipCode);
                BusinessContact businessContact = new BusinessContact(type, id, name, phoneNumber, photoId, location, openTime, closeTime, website, businessName);
                myApplication.getMyContacts().getMyContactsList().add(businessContact);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
