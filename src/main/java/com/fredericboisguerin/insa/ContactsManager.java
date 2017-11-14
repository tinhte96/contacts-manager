package com.fredericboisguerin.insa;

import javax.naming.InvalidNameException;
import java.util.ArrayList;

public class ContactsManager {

    private ArrayList<Contact> listContacts;

    public void addContact(String name, String email, String phoneNumber)
            throws InvalidContactNameException, InvalidNameException {

        if (name == null || name.equals("")){
            throw new InvalidContactNameException();
        }

        if (email==null || email.equals("")){
            throw new InvalidContactNameException();
        }

        this.listContacts.add(new Contact(name,email,phoneNumber));
    }

    public void printAllContacts() {

    }

    public void searchContactByName(String name) {

    }
}
