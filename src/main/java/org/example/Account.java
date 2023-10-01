package org.example;

public class Account {
    String type;
    String accountID;

    String honorID;
    public Account(String type, String accountID, String honorID) {
        this.type = type;
        this.accountID = accountID;
        this.honorID = honorID;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getHonorID() {
        return honorID;
    }

    public void setHonorID(String honorID) {
        this.honorID = honorID;
    }

}
