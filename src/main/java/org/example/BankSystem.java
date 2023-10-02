package org.example;

import java.util.ArrayList;

public class BankSystem {
    ArrayList<User> users;

    public static int usersID=0;
    public static void setUsersID(int usersID) {
        BankSystem.usersID = usersID;
    }

    BankSystem()
    {
        this.users= new ArrayList<User>();
    }
    public boolean logIn(String mail,String password) throws InvalidEmailException
    {
        if(!checkMail(mail))
        {
            throw new InvalidEmailException();
        }
        for(User user:users)
        {
            if(user.mail.equals(mail) && user.password.equals(password))
            {
                return true;
            }
        }
        return false;
    }
    boolean checkMail(String mail)
    {
        for(int i=0;i<mail.length();i++)
        {
            if(mail.charAt(i)=='@')
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkString(String s)
    {
        for(int j=0;j<s.length();j++)
        {
            if(Character.isDigit(s.charAt(j)))
            {
                return false;
            }
        }
        return true;
    }
    public boolean checkNationalID(String s)
    {
        for(int j=0;j<s.length();j++)
        {
            if(Character.isAlphabetic(s.charAt(j)))
            {
                return false;
            }
        }
        int sz=s.length();
        return sz==14;
    }
    public boolean signUp(String userMail,String password,String fullName,String nationalID) throws InvalidEmailException
    {
        if(!checkMail(userMail))
        {
            throw new InvalidEmailException();
        }
        for(User user:users)
        {
            if(user.mail.equals(userMail))
            {
                return false;
            }
        }
        return checkString(fullName) && checkNationalID(nationalID);
    }
    public int getUpdatedID()
    {
        usersID++;
        return usersID;
    }
    public void addUser(User user)
    {
        this.users.add(user);
    }


}

