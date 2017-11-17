package com.fredericboisguerin.insa;

import java.util.Scanner;

public class UserInterface {

        Scanner sc;

        public UserInterface (){
            sc = new Scanner(System.in);
        }

        public void askInfoForContact(ContactsManager contactsManager) throws InvalidContactNameException, InvalidEmailException{
            System.out.println("Votre information : ");
            String name = sc.nextLine();
            String email = sc.nextLine();
            String phoneNumber = sc.nextLine();
            System.out.println(name+email+phoneNumber);
            contactsManager.addContact(name,email,phoneNumber);
        }
}
