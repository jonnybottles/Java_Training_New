package dev.lpa;

public class Main {
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone("1234567890");

        Contact contact1 = Contact.createContact("Bob", "31415926");
        Contact contact2 = Contact.createContact("Alice", "16180339");
        Contact contact3 = Contact.createContact("Tom", "11235813");
        Contact contact4 = Contact.createContact("Jane", "23571113");

        // Adding contacts
        mobilePhone.addNewContact(contact1);
        mobilePhone.addNewContact(contact2);
        mobilePhone.addNewContact(contact3);
        mobilePhone.addNewContact(contact4);

        // Printing contacts
        mobilePhone.printContacts();

        // Querying a contact
        Contact queriedContact = mobilePhone.queryContact("Alice");
        if (queriedContact != null) {
            System.out.println("Queried Contact: " + queriedContact.getName() + " -> " + queriedContact.getPhoneNumber());
        } else {
            System.out.println("Contact not found.");
        }

        // Updating a contact
        Contact newContact2 = Contact.createContact("Alice", "98765432");
        if (mobilePhone.updateContact(newContact2)) {
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found or update failed.");
        }

        // Printing contacts again to verify the update
        mobilePhone.printContacts();

        // Removing a contact
        if (mobilePhone.removeContact(contact1)) {
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found or removal failed.");
        }

        // Printing contacts again to verify the removal
        mobilePhone.printContacts();
    }

}