package com.example.addressbookapp;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    public List<BaseContact> contacts = new ArrayList<>();

    public AddressBook(List<BaseContact> contacts) {
        this.contacts = contacts;
    }

    public List<BaseContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<BaseContact> contacts) {
        this.contacts = contacts;
    }

    public AddressBook() {
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contacts=" + contacts +
                '}';
    }

    public void showContacts(){
        for(BaseContact contact : getContacts()){
            System.out.println(contact);
        }
    }

    public void updateContact(BaseContact contact){
/**
 * Review and add a list.stream to update based on a filter.
 * Read this
 * https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */

    }


    public void addContact(BaseContact contact) {
        contacts.add(contact);
        System.out.println("Contact " + contact.getName() + " added to Address book successfully");
    }

    public void removeContact(BaseContact contact) {
        System.out.println("Removing contact Number " + contact + "\n");
        contacts.remove(contact);
    }

    public void removeContactById(int contactId) {
        for (BaseContact contact : getContacts()) {
            if (contact.getContactId() == contactId) {
                System.out.println("Removing contact Number " + contactId + "\n");
                contacts.remove(contact);
                return;
            }
        }
    }

    public void displayContactById(int contactId) {
        for (BaseContact contact : getContacts()) {
            if (contact.getContactId() == contactId) {
                System.out.println("Displaying contact by Number " + contact.getContactId());
                System.out.println(contact + "\n");
                return;
            }
        }
    }

    public void searchContacts(String name, String city, String description) {
        for (BaseContact contact : getContacts()) {
            boolean isNameEquals = name == null || contact.getName().equalsIgnoreCase(name);
            boolean isCityEquals = city == null || (contact.getLocation().getCity() != null && contact.getLocation().getCity().equalsIgnoreCase(city));
            boolean isDescription = description == null;
            if (contact instanceof PersonalContact) {
                PersonalContact personContact = (PersonalContact) contact;
                isDescription = description == null || description.equalsIgnoreCase(personContact.getDescription());

            }
            if (isNameEquals && isCityEquals && isDescription ) {
                System.out.println(contact + "\n");
            }
        }
    }

    public void searchByContactName(String name){
        searchContacts(name, null, null);
    }

    public void searchByContactCity(String city){
        searchContacts(null, city, null);
    }

    public void searchByDescription(String description){
        searchContacts(null, null, description);
    }

    public void sortContactsByName() {
        //sort by name
    }
}
