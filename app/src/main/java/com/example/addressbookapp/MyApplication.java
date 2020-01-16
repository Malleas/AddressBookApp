package com.example.addressbookapp;

import android.app.Application;

import java.io.IOException;

public class MyApplication extends Application {

    private MyContacts myContacts = new MyContacts();


    public MyApplication() throws IOException {
    }

    public MyContacts getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(MyContacts myContacts) {
        this.myContacts = myContacts;
    }
}
