package com.example.addressbookapp;

public class BusinessContact extends BaseContact {
    private int openingHour;
    private int closingHour;
    private String websiteURL;
    private String businessName;

    public BusinessContact(String type, String contactId, String name, String phoneNumber, int photoId, Location location, int openingHour, int closingHour, String websiteURL, String businessName) {
        super(contactId, name, phoneNumber, photoId, location, type);
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.websiteURL = websiteURL;
        this.businessName = businessName;
    }

    public BusinessContact(){}

    public int getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "BusinessContact{" +
                "type=" + getType() +
                ", id=" + getContactId() +
                ", name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", photo=" + getPhotoId() +
                ", location=" + getLocation() +
                ", openingHour=" + openingHour +
                ", closingHour=" + closingHour +
                ", websiteURL='" + websiteURL + '\'' +
                ", Business Name='" + businessName + '\'' +
                '}';
    }
}
