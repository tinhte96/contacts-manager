package com.fredericboisguerin.insa;

import java.util.ArrayList;

public class ContactsManager {

    private ArrayList<Contact> contactsList;

    public ContactsManager() {
        this.contactsList = new ArrayList<Contact>();
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

        this.contactsList.add(new Contact(name,email,phoneNumber));
    }

    public void printAllContacts() {
        for (Contact c : contactsList){
            System.out.println(c.toString());
        }

    }

    public void searchContactByName(String name) {
        for (Contact c : contactsList){
            if (c.getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(c.toString());
            }
        }
    }

    public void editContact (String name, String email, String phoneNumber)
            throws InvalidContactNameException, InvalidEmailException{

        boolean existedContact = false;
        for (Contact c : contactsList){
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
        for (Contact c : contactsList){
            if (c.getName().equals(name)){
                this.contactsList.remove(c);
                existedContact = true;
                break;
            }
        }
        if (!existedContact){
            throw new InvalidContactNameException();
        }
    }

    public String toString(){
        String contactsQuery = new String();

        for (int i = 0; i < contactsList.size();i++){
            contactsQuery += contactsList.get(i).toString() + "\n";


        }
        return contactsQuery;
    }
}
