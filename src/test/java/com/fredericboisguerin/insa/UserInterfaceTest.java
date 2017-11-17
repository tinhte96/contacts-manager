package com.fredericboisguerin.insa;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

public class UserInterfaceTest extends ContactsManagerMust{

    @Test
    public void type_contact_return_new_contact()throws InvalidContactNameException, InvalidEmailException {

        System.setIn(new ByteArrayInputStream("name\nemail@domain.fr\nphone\n".getBytes()));

        ContactsManager contactsManager = Mockito.mock(ContactsManager.class);
        UserInterface ui = new UserInterface();
        ui.askInfoForContact(contactsManager);

        String name="name";
        String email="email@domain.fr";
        String phoneNumber="phone";
        Mockito.verify(contactsManager).addContact(name,email,phoneNumber);
    }

}
