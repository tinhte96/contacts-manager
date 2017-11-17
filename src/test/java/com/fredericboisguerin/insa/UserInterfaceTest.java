package com.fredericboisguerin.insa;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

public class UserInterfaceTest extends ContactsManagerMust{

    @Test
    public void type_contact_return_new_contact()throws InvalidContactNameException, InvalidEmailException {

        ContactsManager contactsManager = Mockito.mock(ContactsManager.class);
        UserInterface ui = new UserInterface();

        System.setIn(new ByteArrayInputStream("name\nemail\nphone\n".getBytes()));
        ui.type_contact();

        String name="";
        String email="";
        String phoneNumber="";
        Mockito.verify(contactsManager).addContact(name,email,phoneNumber);
    }

}
