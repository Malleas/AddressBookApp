package com.example.addressbookapp;

public abstract class BaseContact {

    private int contactId;
    private String name;
    private String phoneNumber;
    private int photoId;
    private Location location = new Location();
    private String type;


    public BaseContact(int contactId, String name, String phoneNumber, int photoId, Location location, String type) {
        this.contactId = contactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.photoId = photoId;
        this.location = location;
        this.type = type;
    }

    public BaseContact(){}

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BaseContact{" +
                "type=" + type +
                ", id=" + contactId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", photo=" + photoId +
                ", location=" + location +
                '}';
    }
}
