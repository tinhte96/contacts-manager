package com.fredericboisguerin.insa;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactsManager {

    private ArrayList<Contact> listContacts;

    public ContactsManager() {
        this.listContacts = new ArrayList<Contact>();
    }

    private boolean validEmail(String email) {
        int nbArobar = 0;
        int nbPoint = 0;
        boolean arobarBeforePoint = false;

        if (email != null) {
            if (email.equals("")) {
                return false;
            }
            else {
                for (int i = 0; i < email.length(); i++) {
                    if (email.charAt(i) == '@') {
                        nbArobar++;
                        arobarBeforePoint = false;
                    }
                    if (email.charAt(i) == '.') {
                        nbPoint++;
                        arobarBeforePoint = true;
                    }
                }
                return nbArobar == 1 && nbPoint == 1 && arobarBeforePoint;
            }
        }
        return true;
    }

    public void addContact(String name, String email, String phoneNumber)
            throws InvalidContactNameException, InvalidEmailException {

        if (name == null || name.equals("")){
            throw new InvalidContactNameException();
        }

        if (!validEmail(email)){
            throw new InvalidEmailException();
        }

        this.listContacts.add(new Contact(name,email,phoneNumber));
    }

    public void printAllContacts() {
        for (Contact c : listContacts){
            System.out.println(c.toString());
        }

    }

    public void searchContactByName(String name) {
        for (Contact c : listContacts){
            if (c.getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(c.toString());
            }
        }
    }

    public void editContact (String name, String email, String phoneNumber)
            throws InvalidContactNameException, InvalidEmailException{
        boolean existedContact = false;
        for (Contact c : listContacts){
            if (c.getName().equals(name)) {

                if (!validEmail(email)) throw new InvalidEmailException();
                else {
                    c.setEmail(email);
                    c.setPhoneNumber(phoneNumber);
                    existedContact = true;
                    break;
                }
            }
        }
        if (!existedContact){
            throw new InvalidContactNameException();
        }
    }

    public void deleteContact(String name)
            throws InvalidContactNameException{
        boolean existedContact = false;
        for (Contact c : listContacts){
            if (c.getName().equals(name)){
                this.listContacts.remove(c);
                existedContact = true;
                break;
            }
        }
        if (!existedContact){
            throw new InvalidContactNameException();
        }
    }
}
