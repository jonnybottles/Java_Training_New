package dev.lpa;

public class Person {

    private String name;
    private String id;
    private String contactInfo;
    private static int lastID = 0;

    public Person(String name, String contactInfo) {
        this.name = name;
        this.id = String.valueOf(lastID++);
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person) obj;
        return id != null ? id.equals(person.getID()) : person.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }




}
