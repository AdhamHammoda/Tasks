package org.example;

public class Account {
    String type;
    int accountID;

    int OwnerID;

    int balance;
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public Account(String type, int accountID, int ownerID,int initialBalance) {
        this.type = type;
        this.accountID = accountID;
        this.OwnerID = ownerID;
        this.balance=initialBalance;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(int OwnerID) {
        this.OwnerID = OwnerID;
    }

}
