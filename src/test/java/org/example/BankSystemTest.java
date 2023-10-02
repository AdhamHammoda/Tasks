package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankSystemTest {

    BankSystem system = new BankSystem();
    @BeforeEach
    public void initUsers()
    {
        system.addUser(new User("Adham","a.hammoda@nu.edu.eg","1234","12345678912345",system.getUpdatedID()));
        system.addUser(new User("Shams","m.shammss@nu.edu.eg","1235","23456789123456",system.getUpdatedID()));
        system.addUser(new User("Saif","s.kandeel@nu.edu.eg","2345","34567891234567",system.getUpdatedID()));
        system.users.get(0).addAccount(new Account("Current",12,system.users.get(0).getOwnerID(),12000));
    }
    @AfterEach
    public void clearUsers()
    {
        system.users.clear();
        BankSystem.setUsersID(0);
    }

    @Test
    void loginCorrectly() throws InvalidEmailException
    {
        assertTrue(system.logIn("a.hammoda@nu.edu.eg","1234"));
    }

    @Test
    void loginWithInvalidEmail() throws InvalidEmailException
    {
        assertThrows(InvalidEmailException.class,
                ()->system.logIn("a.hammodanu.edu.eg","1234"));
    }


    @Test
    void loginCorrectMailWrongPassword() throws InvalidEmailException
    {
        assertFalse(system.logIn("a.hammoda@nu.edu.eg","1254"));
    }

    @Test
    void loginWrongMailCorrectPassword() throws InvalidEmailException
    {
        assertFalse(system.logIn("a.hamod@nu.edu.eg","1234"));
    }

    @Test
    void loginWrongMailWrongPassword() throws InvalidEmailException
    {
        assertFalse(system.logIn("a.hammd@nu.edu.eg","1284"));
    }

    @Test
    void SignUpWithCorrectCredentials() throws InvalidEmailException
    {
        assertTrue(system.signUp("kh.tamer@nu.edu.eg","1234","Khaled Tamer","12345678912345"));
    }

    @Test
    void SignUpWithInvalidMail() throws  InvalidEmailException
    {
        assertThrows(InvalidEmailException.class,
                ()->system.signUp("kh.tamernu.edu.eg","1234","Khaled Tamer","12345678912345"));

    }

    @Test
    void SignUpWithExistingMail() throws  InvalidEmailException
    {
        assertFalse(system.signUp("a.hammoda@nu.edu.eg","1234","Adham Ahmed","12345678912345"));
    }

    @Test
    void SignUpWithWrongNameContainingDigit() throws  InvalidEmailException
    {
        assertFalse(system.signUp("a.hammoda@gmail.com","1234","Adham A2hmed","12345678912345"));
    }

    @Test
    void SignUpWithWrongNationalIDContainingLetter() throws  InvalidEmailException
    {
        assertFalse(system.signUp("a.hammoda@gmail.com","1234","Adham A2hmed","12345678912d45"));
    }
    @Test
    void SignUpWithWrongNationalIDSizeNotEqual14() throws  InvalidEmailException
    {
        assertFalse(system.signUp("a.hammoda@gmail.com","1234","Adham Ahmed","1234567891234"));
    }


}