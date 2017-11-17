package com.fredericboisguerin.insa;

import org.junit.Test;

import javax.naming.InvalidNameException;

public class ContactsManagerShould {

    private static final String SOME_VALID_EMAIL = "toto@titi.fr";
    private static final String SOME_VALID_PHONE_NUMBER = "0123456789";
    private static final String SOME_VALID_NAME = "Toto titi";

    @Test(expected = InvalidContactNameException.class)
    public void fail_if_no_name() throws Exception {
        ContactsManager contactsManager = new ContactsManager();
        String noName = null;

        contactsManager.addContact(noName, SOME_VALID_EMAIL, SOME_VALID_PHONE_NUMBER);
    }

    @Test(expected = InvalidContactNameException.class)
    public void fail_if_name_is_empty() throws InvalidEmailException, InvalidContactNameException {
        ContactsManager contactsManager = new ContactsManager();
        String emptyName = "";

        contactsManager.addContact(emptyName, SOME_VALID_EMAIL, SOME_VALID_PHONE_NUMBER);
    }

    @Test(expected = InvalidEmailException.class)
    public void fail_if_email_is_not_valid() throws InvalidEmailException, InvalidContactNameException {
        ContactsManager contactsManager = new ContactsManager();
        String invalidEmail = "tototitifr";

        contactsManager.addContact(SOME_VALID_NAME, invalidEmail, SOME_VALID_PHONE_NUMBER);
    }

    @Test(expected = InvalidContactNameException.class)
    public void fail_if_name_is_not_vali_when_edit() throws InvalidContactNameException, InvalidEmailException{

        ContactsManager contactsManager = new ContactsManager();
        contactsManager.addContact(SOME_VALID_NAME,SOME_VALID_EMAIL,SOME_VALID_PHONE_NUMBER);

        String invalidName = "toto";
        contactsManager.editContact(invalidName,SOME_VALID_EMAIL,SOME_VALID_PHONE_NUMBER);
    }

    @Test(expected = InvalidEmailException.class)
    public void fail_if_email_is_not_valid_when_edit() throws InvalidEmailException, InvalidContactNameException{
        ContactsManager contactsManager = new ContactsManager();
        contactsManager.addContact(SOME_VALID_NAME,SOME_VALID_EMAIL,SOME_VALID_PHONE_NUMBER);

        String invalidEmail = "toto.titi";
        contactsManager.editContact(SOME_VALID_NAME,invalidEmail,SOME_VALID_PHONE_NUMBER);
    }

}
