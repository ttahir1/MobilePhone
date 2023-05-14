package academy.learningprogramming;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> phoneContacts;

    public MobilePhone() {
        this.phoneContacts = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getContacts() {
        return phoneContacts;
    }

    public void printContacts() {
        System.out.println("You have " + phoneContacts.size() + " contacts saved.");
        for(int i = 0; i < phoneContacts.size(); i++) {
            System.out.println((i+1) + ". " + "Name: " + queryName(phoneContacts.get(i)) + " " + " Phone Number: " + queryNumber(phoneContacts.get(i)));
        }
    }

    public void addContact(String name, String phoneNumber) {
        if((name.isEmpty()) || (phoneNumber.isEmpty()) || !(findContact(name)==null)) {
            System.out.println("Invalid name or number. Please try again.");
        } else {
            Contact newContact = new Contact(name, phoneNumber);
            phoneContacts.add(newContact);
        }
    }
    public boolean modifyContact(Contact oldContact, Contact newContact) {
        if((findContact(oldContact.getName())==null)) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        this.phoneContacts.set(findItem(oldContact), newContact);
        return true;
    }

    private int findItem(Contact contact) {
        return this.phoneContacts.indexOf(contact);
    }

    public boolean removeContact(Contact contact) {
        int position = findItem(contact);
        if(position < 0) {
            System.out.println("Contact was not found.");
            return false;
        }
        this.phoneContacts.remove(position);
        return true;
    }

    public String queryName(Contact contact) {
        return contact.getName();
    }

    public String queryNumber(Contact contact) {
        return contact.getPhoneNumber();
    }

    public int size() {
        return this.phoneContacts.size();
    }

    public Contact findContact(String name) {
        for(int i = 0; i < phoneContacts.size(); i++) {
            if(name.equals(queryName(phoneContacts.get(i)))) {
                return phoneContacts.get(i);
            }
        }
        return null;
    }

    public String queryContact(Contact contact) {
        if(findItem(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }


}