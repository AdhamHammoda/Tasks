package org.example;

import java.util.ArrayList;

public class User
{
    String mail;
    String password;
    String nationalID;
    ArrayList<Account> accounts;

    public User(String mail, String password,String nationalID) {
        this.mail = mail;
        this.password = password;
        this.nationalID = nationalID;
        this.accounts=new ArrayList<Account>();
    }
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }



    public String getUsername() {
        return mail;
    }

    public void setUsername(String username) {
        this.mail = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}