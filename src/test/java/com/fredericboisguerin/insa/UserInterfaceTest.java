package com.fredericboisguerin.insa;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

public class UserInterfaceTest extends ContactsManagerMust{

    @Test
    public void type_contact_return_new_contact()
            throws InvalidContactNameException, InvalidEmailException {

        System.setIn(new ByteArrayInputStream("name\nemail@domain.fr\nphone\n".getBytes()));

        ContactsManager contactsManager = Mockito.mock(ContactsManager.class);
        UserInterface ui = new UserInterface();
        ui.askInfoForAddingContact(contactsManager);

        String name="name";
        String email="email@domain.fr";
        String phoneNumber="phone";
        Mockito.verify(contactsManager).addContact(name,email,phoneNumber);
    }

    @Test
    public void type_contact_return_new_edited_contact()
            throws InvalidEmailException, InvalidContactNameException{

        System.setIn(new ByteArrayInputStream("name\nemail@domain.fr\nphone\n".getBytes()));

        ContactsManager contactsManager = Mockito.mock(ContactsManager.class);
        UserInterface ui = new UserInterface();
        ui.askInfoForEditingContact(contactsManager);

        String name="name";
        String email="email@domain.fr";
        String phoneNumber="phone";
        Mockito.verify(contactsManager).editContact(name,email,phoneNumber);
    }

    @Test
    public void type_contact_and_delete_contact()
            throws InvalidEmailException, InvalidContactNameException{

        System.setIn(new ByteArrayInputStream("name\nY\n".getBytes()));

        ContactsManager contactsManager = Mockito.mock(ContactsManager.class);
        UserInterface ui = new UserInterface();
        ui.askInfoForDeletingContact(contactsManager);

        String name="name";
        Mockito.verify(contactsManager).deleteContact(name);
    }
}
