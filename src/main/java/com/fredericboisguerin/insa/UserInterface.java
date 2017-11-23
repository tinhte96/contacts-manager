package com.fredericboisguerin.insa;

import java.util.Scanner;

public class UserInterface {

    Scanner sc;

    public UserInterface (){
            sc = new Scanner(System.in);
        }

    public void askInfoForAddingContact(ContactsManager contactsManager)
            throws InvalidContactNameException, InvalidEmailException{
        System.out.println("Your information : ");
        System.out.print("name : ");
        String name = sc.nextLine();
        System.out.print("email : ");
        String email = sc.nextLine();
        System.out.print("phone number : ");
        String phoneNumber = sc.nextLine();
        System.out.println("\n");
        contactsManager.addContact(name,email,phoneNumber);
    }

    public void askInfoForEditingContact(ContactsManager contactsManager)
            throws InvalidContactNameException, InvalidEmailException{
        System.out.println("Your information : ");
        System.out.print("name : ");
        String name = sc.nextLine();
        System.out.print("email : ");
        String email = sc.nextLine();
        System.out.print("phone number : ");
        String phoneNumber = sc.nextLine();
        System.out.println("\n");
        contactsManager.editContact(name,email,phoneNumber);
    }

    public void askInfoForDeletingContact(ContactsManager contactsManager)
            throws InvalidContactNameException, InvalidEmailException{
        System.out.println("Your information : ");
        System.out.print("name : ");
        String name = sc.nextLine();

        while (true) {
            System.out.println("Are you sure you want to delete this user : " + name + " [Y\\N]");
            String confirm = sc.nextLine();
            if (confirm.toLowerCase().equals("y")) {
                contactsManager.deleteContact(name);
                break;
            } else if (confirm.toLowerCase().equals("n")) {
                System.out.println("Nothing done");
                break;
            } else {
                System.out.println("Please tape Y or N ");
            }
        }
    }

    public void searchContactByName(ContactsManager contactsManager){
        System.out.println("Your information : ");
        System.out.print("name : ");
        String name = sc.nextLine();
        System.out.println("\n");

        contactsManager.searchContactByName(name);

    }


}
