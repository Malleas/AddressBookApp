package com.example.addressbookapp;

import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyContacts {

    List<BaseContact> myContactsList;

    public MyContacts(List<BaseContact> myContactsList) {
        this.myContactsList = myContactsList;
    }

    public MyContacts(InputStream inputStream) throws IOException {
        FileAccessService fileAccessService = new FileAccessService();
        this.myContactsList = fileAccessService.readAllContacts(inputStream);
    }

    private Resources getResources() {
        return null;
    }


    public List<BaseContact> getMyContactsList() {

        if(myContactsList == null){
            myContactsList = new ArrayList<>();
        }
        return myContactsList;
    }

    public void setMyContactsList(List<BaseContact> myContactsList) {
        this.myContactsList = myContactsList;
    }


}
