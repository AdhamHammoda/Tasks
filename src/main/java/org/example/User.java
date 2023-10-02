package org.example;

import java.util.*;

public class User
{
    String fullName;
    String mail;
    String password;
    String nationalID;
    public static int accountsID=0;

    int OwnerID;
    ArrayList<Account> accounts;

    public User(String fullName,String mail, String password,String nationalID,int OwnerID) {
        this.fullName=fullName;
        this.mail = mail;
        this.password = password;
        this.nationalID = nationalID;
        this.OwnerID = OwnerID;
        this.accounts=new ArrayList<Account>();
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
    public void listAccounts()
    {
        for(Account account:accounts)
        {
            System.out.printf("%s %s %d",account.getAccountID(),account.getType(),account.getBalance());
        }
    }
    public boolean addAccount(Account account)
    {
        for(Account oldaccount:this.accounts)
        {
            if(oldaccount.getAccountID()==account.getAccountID())
            {
                return false;
            }
        }
        this.accounts.add(account);
        return true;
    }
    public boolean withdrawFromAccount(int accountID,int withdrawnValue)
    {
        for(Account account:this.accounts)
        {
            if(account.getAccountID()==accountID)
            {
                if(account.getBalance()>=withdrawnValue)
                {
                    account.setBalance(account.getBalance()-withdrawnValue);
                    return true;
                }
                else return false;
            }
        }
        return false;
    }
    public boolean depositIntoAccount(int accountID,int addedValue)
    {
        for(Account account:this.accounts)
        {
            if(account.getAccountID()==accountID)
            {
                account.setBalance(account.getBalance()+addedValue);
                return true;
            }
        }
        return false;
    }
    public int getOwnerID() {
        return OwnerID;
    }
    public void setOwnerID(int ownerID) {
        OwnerID = ownerID;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    public static int getUpdatedAccountsID()
    {
        accountsID++;
        return accountsID;
    }
}
