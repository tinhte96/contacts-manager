package com.fredericboisguerin.insa;

public class Contact {

    private String name;
    private String email;
    private String phoneNumber;

    public Contact(String pName, String pEmail, String pPhoneNumber){
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

    public String toString(){
            return (this.name +  ((this.email != null) ? (", " + this.email) : "") + ((this.phoneNumber != null) ? (", " + this.phoneNumber) : ""));
    }
}
