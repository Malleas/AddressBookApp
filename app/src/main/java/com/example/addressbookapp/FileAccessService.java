package com.example.addressbookapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAccessService implements DataAccessService {

    private List<BaseContact> contacts = new ArrayList<>();

    @Override
    public List<BaseContact> readAllContacts(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        ArrayList<BaseContact> contacts = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] items = new String[15];
            items = line.split(",");
            String contactType = items[0];
            int contactId = Integer.valueOf(items[1]);
            String name = items[2];
            String phoneNumber = items[3];
            int photoId = Integer.valueOf(items[4]);
            String locationAddress = items[5];
            String city = items[6];
            String state = items[7];
            int zipCode = Integer.valueOf(items[8]);
            Location location = new Location(locationAddress, city, state, zipCode);
            if (items[0].equalsIgnoreCase( "Personal")) {
                String dateOfBirth = items[9];
                String contactDescription = items[10];
                PersonalContact personContact = new PersonalContact(contactType, contactId, name, phoneNumber, photoId, location,
                        dateOfBirth, contactDescription);
                contacts.add(personContact);
            } else if (items[0].equalsIgnoreCase( "Business")) {
                int openHour = Integer.valueOf(items[9]);
                int closeHour = Integer.valueOf(items[10]);
                String webUrl = items[11];
                String businessName = items[12];
                BusinessContact businessContact = new BusinessContact(contactType, contactId, name, phoneNumber, photoId,
                        location, openHour, closeHour, webUrl, businessName);
                contacts.add(businessContact);
            }
        }
        return contacts;
    }

    @Override
    public void saveAllContacts(String fileName, List<BaseContact> contacts, boolean append) throws IOException {
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, append);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(contactListToString(contacts));
        printWriter.close();

    }
    public String contactListToString(List<BaseContact> contacts){
        String contactString = "";
        for(int i = 0; i<contacts.size();i++){
            if (contacts.get(i).getType().equalsIgnoreCase("Personal")) {
                contactString = contacts.get(i).getType()
                        + "," + Integer.toString(contacts.get(i).getContactId())
                        + "," + contacts.get(i).getName()
                        + "," + contacts.get(i).getPhoneNumber()
                        + "," + Integer.toString(contacts.get(i).getPhotoId())
                        + "," + contacts.get(i).getLocation().getStreetAddress()
                        + "," + contacts.get(i).getLocation().getCity()
                        + "," + contacts.get(i).getLocation().getState()
                        + "," + contacts.get(i).getLocation().getZipCode()
                        + "," + ((PersonalContact) contacts.get(i)).getDateOfBirth()
                        + "," + ((PersonalContact) contacts.get(i)).getDescription()
                        + "\r";
            }else if(contacts.get(i).getType().equalsIgnoreCase("Business")){
                contactString = contacts.get(i).getType()
                        + "," + Integer.toString(contacts.get(i).getContactId())
                        + "," + contacts.get(i).getName()
                        + "," + contacts.get(i).getPhoneNumber() + ","
                        + Integer.toString(contacts.get(i).getPhotoId())
                        + "," + contacts.get(i).getLocation().getStreetAddress()
                        + "," + contacts.get(i).getLocation().getCity()
                        + "," + contacts.get(i).getLocation().getState()
                        + "," + contacts.get(i).getLocation().getZipCode()
                        + "," + Integer.toString(((BusinessContact) contacts.get(i)).getOpeningHour())
                        + "," + Integer.toString(((BusinessContact) contacts.get(i)).getClosingHour())
                        + "," + ((BusinessContact) contacts.get(i)).getWebsiteURL()
                        + "," + ((BusinessContact) contacts.get(i)).getBusinessName()
                        + "\r";
            }
        }
        return contactString;
    }

}
