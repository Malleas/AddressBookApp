package com.example.addressbookapp;

        import android.app.Application;


public class MyApplication extends Application {

    private MyContacts myContacts;


    public MyApplication(){
    }

    public MyContacts getMyContacts(){
        return myContacts;
    }

    public void setMyContacts(MyContacts myContacts){
        this.myContacts = myContacts;
    }

}
