package com.example.addressbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btn_addContact, btn_showAllContacts, btn_searchForContacts, btn_email, btn_text, btn_map,
    btn_call;


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
        btn_email = findViewById(R.id.btn_email);
        btn_text = findViewById(R.id.btn_text);
        btn_map = findViewById(R.id.btn_map);
        btn_call = findViewById(R.id.btn_call);

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

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        final MyContacts finalMyContacts1 = myContacts;
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeMmsMessage(finalMyContacts1.myContactsList.get(0).getPhoneNumber(), "Hello, I'd like to talk.");
            }
        });

        final MyContacts finalMyContacts = myContacts;
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapsQuery = "geo:0,0?q=" + finalMyContacts.myContactsList.get(0).getLocation().getCity();
                Uri mapUri = Uri.parse(mapsQuery);
                showMap(mapUri);
            }
        });

        final MyContacts finalMyContacts2 = myContacts;
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(finalMyContacts2.myContactsList.get(0).getPhoneNumber());
            }
        });



    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void composeMmsMessage(String phoneNumber, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
