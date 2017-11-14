package com.fredericboisguerin.insa;

public class Contacts {
    private String name;
    private String email;
    private String phoneNumber;

    public Contacts(String pName, String pEmail, String pPhoneNumber){
        this.name = pName;
        this.email = pEmail;
        this.phoneNumber = pPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
