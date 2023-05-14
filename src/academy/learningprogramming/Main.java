package academy.learningprogramming;

import java.util.Scanner;

public class Main {

    private static MobilePhone phone = new MobilePhone();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    phone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add an new contact.");
        System.out.println("\t 3 - To modify an existing contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To search for a contact.");
        System.out.println("\t 6 - To turn off the phone.");
    }

    public static void addContact() {
        System.out.println("Please enter the name of the new contact: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the phone number of the new contact: ");
        String phoneNumber = scanner.nextLine();
        phone.addContact(name, phoneNumber);
    }

    public static void modifyContact() {
        System.out.println("Enter contact you wish to modify: ");
        Contact currentContact = phone.findContact(scanner.nextLine());
        System.out.println("Enter the new name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter the new phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName, newNumber);
        phone.modifyContact(currentContact, newContact);
    }

    public static void removeContact() {
        System.out.println("Enter contact you wish to remove: ");
        Contact toRemove = phone.findContact(scanner.nextLine());
        phone.removeContact(toRemove);
    }

    public static void queryContact() {
        System.out.println("Enter contact you wish to query: ");
        Contact toQuery = phone.findContact(scanner.nextLine());
        System.out.println(phone.queryContact(toQuery));
    }
}
