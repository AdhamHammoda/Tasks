package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user=new User("Adham","a.hammoda@nu.edu.eg","1234","12",2);
    @BeforeEach
    void initUser()
    {
        user.addAccount(new Account("Current",1,2,25));
        user.addAccount(new Account("Current",2,2,30));
    }

    @AfterEach
    void clearUser()
    {
        user.accounts.clear();
    }

    @Test
    void addValidAccount()
    {
        assertTrue(user.addAccount(new Account("Current",3,2,12)));
    }
    @Test
    void addExistingAccount()
    {
        assertFalse(user.addAccount(new Account("Current",1,2,3)));
    }
    @Test
    void depositIntoExistingAccount()
    {
        assertTrue(user.depositIntoAccount(1,12));
    }

    @Test
    void depositIntoNonExistingAccount()
    {
        assertFalse(user.depositIntoAccount(3,12));
    }

    @Test
    void withdrawFromNonExistingAccount()
    {
        assertFalse(user.withdrawFromAccount(3,12));
    }
    @Test
    void withdrawFromExistingAccountWithSufficientBalance()
    {
        assertTrue(user.withdrawFromAccount(1,4));
    }
    @Test
    void withdrawFromExistingAccountWithInsufficientBalance()
    {
        assertFalse(user.withdrawFromAccount(1,200));
    }
}