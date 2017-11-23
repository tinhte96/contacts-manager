package com.fredericboisguerin.insa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main (String[] arg) throws InvalidEmailException, InvalidContactNameException, IOException {

        final Scanner sc = new Scanner(System.in);
        ContactsManager contactsManager = new ContactsManager();
        UserInterface ui = new UserInterface();

        boolean keep_going = true;
        int chose = 7;
        while (keep_going ) {

            displayMenu();

            try {
                chose = sc.nextInt();
            }
            catch (Exception e){
                System.out.println("Erreur");;
            }

            switch (chose) {
                case 0:
                    break;
                case 1:
                    try {
                        ui.askInfoForAddingContact(contactsManager);
                    }
                    catch(Exception e){
                        System.out.println("email or name error ");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        ui.askInfoForEditingContact(contactsManager);
                    }
                    catch(Exception e){
                        System.out.println("email or name error");
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        ui.askInfoForDeletingContact(contactsManager);
                    }
                    catch (Exception e){
                        System.out.println("username not existed");
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        ui.searchContactByName(contactsManager);
                    }
                    catch (Exception e){
                        System.out.println("username not existed");
                        e.printStackTrace();
                    }
                    break;
                case 5 :
                    String entries = contactsManager.toString();
                    System.out.printf("File name : ");
                    String fileName = sc.next();
                    FileWriter writer = new FileWriter(fileName+".csv");

                    try {
                        writer.append(entries);
                    }
                    catch(Exception e){
                        System.out.println("Error in CsvFileWriter !!!");
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            writer.flush();
                            writer.close();
                        }
                        catch(Exception e){
                            System.out.println("Error while flushing, closing filewriter !!!");
                            e.printStackTrace();
                        }
                    }
                    break;
                case 6 :
                    System.out.println(contactsManager.toString());
                    break;
                default:
                    System.out.println("Erreur, try again");
            }


            if (chose == 0){
                keep_going = false;
            }
        }
    }

    public static void displayMenu () {
        System.out.println () ;
        System.out.println ("MENU") ;
        System.out.println () ;
        System.out.println ("0 - Exit") ;
        System.out.println ("1 - Add new contact") ;
        System.out.println ("2 - Edit contact") ;
        System.out.println ("3 - Delete contact") ;
        System.out.println ("4 - Search contact by name") ;
        System.out.println ("5 - get data as csv file") ;
        System.out.println ("6 - Print contacts list in console for debug") ;
        System.out.println ("") ;

        System.out.print   ("Your choose : ");

        System.out.println () ;
    }
}
