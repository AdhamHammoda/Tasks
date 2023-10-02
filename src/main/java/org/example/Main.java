package org.example;

import java.util.*;
public class Main {
    static BankSystem bankSystem=new BankSystem();
    static Scanner sc=new Scanner(System.in);
    public static void displayHome()
    {
        System.out.println("Choose the number to decide what to do");
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
    }
    public static void listAccounts(User user)
    {
        if(user.accounts.isEmpty())
        {
            System.out.println("There are no accounts so far");
        }
        else
        {
            System.out.println("Account ID           Account type           Balance");
            for(Account account:user.accounts)
            {
                System.out.println("   "+account.getAccountID()+"                   "+account.getType()+"                "+account.getBalance());
            }
        }
    }
    public static void addAccount(User user)
    {
        System.out.println("Enter type of Account ( Current or Savings ):");
        String type=sc.next();
        System.out.println("Enter Initial deposit:");
        int deposit=sc.nextInt();
        int accountID=User.getUpdatedAccountsID();
        user.addAccount(new Account(type,accountID,user.getOwnerID(),deposit));
    }
    public static void withdraw(User user,int accountID,int amount)
    {
        for(Account account:user.accounts)
        {
            if(account.getAccountID()==accountID)
            {
                if(account.getBalance()>=amount)
                {
                    account.setBalance(account.getBalance()-amount);
                    System.out.println("Amount withdrawn succesfully");
                    System.out.printf("New balance of account is %d\n",account.getBalance());
                    return;
                }
            }
        }
        System.out.println("Can't withdraw the required amount");
    }
    public static void deposit(User user,int accountID,int amount)
    {
        for(Account account:user.accounts)
        {
            if(account.getAccountID()==accountID)
            {
                account.setBalance(account.getBalance()+amount);
                System.out.println("Amount deposited successfully");
                System.out.printf("New balance of account is %d\n",account.getBalance());
                return;
            }
        }
        System.out.println("Can't deposit the required amount");
    }
    public static void displayUserOptions(User user)
    {
        System.out.println("Choose the number to decide what to do");
        System.out.println("1. List available accounts");
        System.out.println("2. Add an Account");
        System.out.println("3. Withdraw from Existing Account");
        System.out.println("4. Deposit into Account");
        System.out.println("5. Log out");
        String input=sc.next();
        switch (input) {
            case "1" -> listAccounts(user);
            case "2" -> addAccount(user);
            case "3" -> {
                System.out.println("Enter the account ID");
                int accountID = sc.nextInt();
                System.out.println("Enter the amount you want to withdraw");
                int amount = sc.nextInt();
                withdraw(user, accountID, amount);
            }
            case "4" -> {
                System.out.println("Enter the account ID");
                int accountID = sc.nextInt();
                System.out.println("Enter the amount you want to deposit");
                int amount = sc.nextInt();
                deposit(user, accountID, amount);
            }
            case "5" -> {
                return;
            }
            default -> System.out.println("Invalid choice try again");
        }
        displayUserOptions(user);
    }
    public static void displayLogin()
    {
        System.out.println("Enter UserMail:");
        String userMail=sc.next();
        System.out.println("Enter password:");
        String password=sc.next();
        try
        {
            bankSystem.logIn(userMail,password);
            for(User user: bankSystem.users)
            {
                if(user.mail.equals(userMail) && user.password.equals(password))
                {
                    displayUserOptions(user);
                    return;
                }
            }
            System.out.println("User credentials are wrong try again");
        }
        catch (InvalidEmailException exe)
        {
            System.out.println(exe.getMessage());
        }

    }
    public static void displaySignup()
    {
        System.out.println("Enter First Name:");
        String firstName=sc.next();
        System.out.println("Enter Last Name:");
        String lastName=sc.next();
        String fullName=firstName+" "+lastName;
        System.out.println("Enter UserNationalID:");
        String nationalID=sc.next();
        System.out.println("Enter UserMail:");
        String userMail=sc.next();
        System.out.println("Enter password:");
        String password=sc.next();
        try
        {
            bankSystem.signUp(userMail,password,fullName,nationalID);
            int OwnerID=bankSystem.getUpdatedID();
            bankSystem.addUser(new User(fullName,userMail,password,nationalID,OwnerID));
            System.out.println("User Credentials Saved");
        }
        catch (InvalidEmailException exe)
        {
            System.out.println(exe.getMessage());
            System.out.println("Can't save user credentials try again");
        }
    }

    public static void main(String[] args)
    {
        while(true)
        {
            displayHome();
            String ans=sc.next();
            switch (ans) {
                case "1" -> displayLogin();
                case "2" -> displaySignup();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }

    }
}