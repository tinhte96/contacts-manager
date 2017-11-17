package com.fredericboisguerin.insa;

import java.util.Scanner;

public class UserInterface {

        ContactsManager contactsManager = new ContactsManager();
        Scanner sc = new Scanner(System.in);

        public void type_contact() throws InvalidContactNameException, InvalidEmailException{
            System.out.println("Votre information : ");
            String name = sc.nextLine();
            String email = sc.nextLine();
            String phoneNumber = sc.nextLine();
            System.out.println(name+email+phoneNumber);
            contactsManager.addContact(name,email,phoneNumber);
        }
}
