package org.example;

import java.util.ArrayList;

public class System {
    ArrayList<User> users;
    System()
    {
        this.users= new ArrayList<User>();
    }
    public boolean logIn(String mail,String password)
    {
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
    public boolean signUp(String mail,String password)
    {
        if(!checkMail(mail))
        {
            return false;
        }
        for(User user:users)
        {
            if(user.mail.equals(mail))
            {
                return false;
            }
        }
        return true;
    }
    public void addUser(User user)
    {
        this.users.add(user);
    }

}
