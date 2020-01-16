package com.example.addressbookapp;

import java.io.IOException;
import java.util.List;

public class MyContacts {

    List<BaseContact> myContacts;

    public MyContacts(List<BaseContact> myContacts) {
        this.myContacts = myContacts;
    }

    public MyContacts() throws IOException {
        FileAccessService fileAccessService = new FileAccessService();
        this.myContacts = fileAccessService.readAllContacts("/Users/ntqams30/Dropbox/GCU Work/AddressBookApp/app/src/main/java/com/example/addressbookapp/ContactList.txt");
        for(int i = 0; i<this.myContacts.size(); i++){
            if(this.myContacts.get(i).getType().equals("Personal")){
                Location location = new Location(myContacts.get(i).getLocation().getStreetAddress(),
                        myContacts.get(i).getLocation().getCity(),
                        myContacts.get(i).getLocation().getState(),
                        myContacts.get(i).getLocation().getZipCode());
                PersonalContact personalContact = new PersonalContact(
                        myContacts.get(i).getType(),
                        myContacts.get(i).getContactId(),
                        myContacts.get(i).getName(),
                        myContacts.get(i).getPhoneNumber(),
                        myContacts.get(i).getPhotoId(),
                        location,
                        ((PersonalContact) myContacts.get(i)).getDateOfBirth(),
                        ((PersonalContact) myContacts.get(i)).getDescription());
                myContacts.add(personalContact);
            }else if(this.myContacts.get(i).getType().equals("Business")){
                Location location = new Location(
                        myContacts.get(i).getLocation().getStreetAddress(),
                        myContacts.get(i).getLocation().getCity(),
                        myContacts.get(i).getLocation().getState(),
                        myContacts.get(i).getLocation().getZipCode());
                BusinessContact businessContact = new BusinessContact(
                        myContacts.get(i).getType(),
                        myContacts.get(i).getContactId(),
                        myContacts.get(i).getName(),
                        myContacts.get(i).getPhoneNumber(),
                        myContacts.get(i).getPhotoId(),
                        location,
                        ((BusinessContact) myContacts.get(i)).getOpeningHour(),
                        ((BusinessContact) myContacts.get(i)).getClosingHour(),
                        ((BusinessContact) myContacts.get(i)).getWebsiteURL(),
                        ((BusinessContact) myContacts.get(i)).getBusinessName()
                );
                myContacts.add(businessContact);
            }
        }
    }

    public List<BaseContact> getMyContacts() {
        return myContacts;
    }

    public void setMyContacts(List<BaseContact> myContacts) {
        this.myContacts = myContacts;
    }
}
