package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
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
        myContacts = ((MyContacts) this.getApplication()).getMyContacts();
        adapter = new ContactAdapter(ShowAllContacts.this, myContacts);

        lv_contactList.setAdapter(adapter);

        Bundle incomingMessages = getIntent().getExtras();

        if(incomingMessages != null){

            try {
                book.setContacts(fileAccessService.readAllContacts(""));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String type = incomingMessages.getString("type");
            String name = incomingMessages.getString("contactname");
            String businessName = incomingMessages.getString("contactBusinessName");
            String phoneNumber = incomingMessages.getString("contactPhoneNumber");
            String streetAddress = incomingMessages.getString("contactStreetAddress");
            String city = incomingMessages.getString("contactCity");
            String state = incomingMessages.getString("contactState");
            int zipCode = incomingMessages.getInt("contactZipCode");
            String dateOfBirth = incomingMessages.getString("contactDateOfBirth");
            String description = incomingMessages.getString("contactdescription");
            int openHour = incomingMessages.getInt("contactBusinessOpenHour");
            int closeHour = incomingMessages.getInt("contactBusinessCloseHour");
            String website = incomingMessages.getString("contactWebsiteUrl");

            if(type.equals("Personal")){
                Location location = new Location(streetAddress, city, state, zipCode);
                PersonalContact personalContact = new PersonalContact(type, name, phoneNumber, location, dateOfBirth, description);
            }

        }



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
