package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;
import java.util.UUID;

public class PersonalContactPage extends AppCompatActivity {

    Button  btn_addNewPersonalContact;
    EditText et_personalCity, et_personalNameEntry, et_personalPhoneEntry, et_personalStreetAddress, et_personalState,
    et_personalZipCode, et_personalDateOfBirth, et_personalContactDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_contact);
        final MyApplication myApplication = (MyApplication) this.getApplication();

        btn_addNewPersonalContact = findViewById(R.id.btn_addNewPersonalContact);

        et_personalCity = findViewById(R.id.et_personalCity);
        et_personalContactDescription = findViewById(R.id.et_personalContactDescription);
        et_personalDateOfBirth = findViewById(R.id.et_personalDateOfBirth);
        et_personalNameEntry = findViewById(R.id.et_personalNameEntry);
        et_personalPhoneEntry = findViewById(R.id.et_personalPhoneEntry);
        et_personalStreetAddress = findViewById(R.id.et_personalStreetAddress);
        et_personalState = findViewById(R.id.et_personalState);
        et_personalZipCode = findViewById(R.id.et_personalZipCode);


        btn_addNewPersonalContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                String id = UUID.randomUUID().toString();
                String type = "Personal";
                int photoId = random.nextInt(16);
                String name = et_personalNameEntry.getText().toString();
                String phoneNumber = et_personalPhoneEntry.getText().toString();
                String streetAddress = et_personalStreetAddress.getText().toString();
                String city = et_personalCity.getText().toString();
                String state = et_personalState.getText().toString();
                int zipCode = Integer.parseInt(et_personalZipCode.getText().toString());
                String dateOfBirth = et_personalDateOfBirth.getText().toString();
                String description = et_personalContactDescription.getText().toString();
                Location location = new Location(streetAddress, city, state, zipCode);
                PersonalContact personalContact = new PersonalContact(type, id, name, phoneNumber, photoId, location, dateOfBirth, description);
                myApplication.getMyContacts().getMyContactsList().add(personalContact);
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
