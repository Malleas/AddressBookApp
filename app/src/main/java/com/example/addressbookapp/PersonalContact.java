package com.example.addressbookapp;

import java.util.ArrayList;
import java.util.List;

public class PersonalContact extends BaseContact {

    private String dateOfBirth;
    private String description;
    private List<PersonalContact> contacts = new ArrayList<>();

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public List<PersonalContact> getContacts() {
        return contacts;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PersonalContact(){}

    public PersonalContact(String type, int contactId, String name, String phoneNumber, int photoId, Location location,  String dateOfBirth, String description) {
        super(contactId, name, phoneNumber, photoId, location, type);
        this.dateOfBirth = dateOfBirth;
        this.description = description;
    }

    @Override
    public String toString() {
        return "PersonContact{" +
                "type=" + getType() +
                ". id=" + getContactId() +
                ", name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", photo=" + getPhotoId() +
                ", location=" + getLocation() +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", description='" + description + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
