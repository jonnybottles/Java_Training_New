package dev.lpa;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact contact) {
        int index = findContact(contact);
        if (index != -1) {
            myContacts.set(index, contact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index != -1) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index != -1) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

    private int findContact(Contact contact) {
        for (Contact currentContact : myContacts) {
            if (currentContact.getName().equals(contact.getName())) {
                return myContacts.indexOf(currentContact); // Return the index immediately when found
            }
        }
        return -1; // Contact not found
    }

    private int findContact(String name) {
        for (Contact currentContact : myContacts) {
            if (currentContact.getName().equals(name)) {
                return myContacts.indexOf(currentContact);
            }
        }
        return -1;
    }



}
