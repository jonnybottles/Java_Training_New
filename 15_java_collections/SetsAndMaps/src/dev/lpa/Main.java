package dev.lpa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);

        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        System.out.println(robinHood);
        robinHood.replaceEmailIFExists("RHood@sherwoodforest.com", "Rhood@sherwoodforest.org");
        robinHood.addEmail("Sherwood Forest");
        System.out.println(robinHood);

        //Union provides all elements across both data sets and excludes duplicates
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A ∪ B) Union emails (A) with phones (B)", unionAB);

        // Intersect will provide all elements that are in common only across both data sets
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A ∩ B) Intersect emails (A) with phones (B)", intersectAB);

        // Intersect will provide all elements that are in common only across both data sets
        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B ∩ A) Intersect phones (B) with emails (A)", intersectBA);





//        List<String> teamA = new ArrayList<>(Arrays.asList("Jonny", "Jake", "Allison", "Arianna"));
//        List<String> teamB = new ArrayList<>(Arrays.asList("Jonny", "Jake"));
//        Set<String> unionTeamAB = new HashSet<>();
//        unionTeamAB.addAll(teamA);
//        unionTeamAB.addAll(teamB);
//        unionTeamAB.forEach(System.out::println);



        
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("--------------------------------");
        System.out.println(header);
        System.out.println("--------------------------------");
        contacts.forEach(System.out::println);
    }
}