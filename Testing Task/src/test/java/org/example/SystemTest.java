package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemTest {

    System system = new System();
    @BeforeEach
    public void initUsers()
    {
        system.addUser(new User("a.hammoda@nu.edu.eg","1234","12345678912345"));
        system.addUser(new User("m.shammss@nu.edu.eg","1235","23456789123456"));
        system.addUser(new User("s.kandeel@nu.edu.eg","2345","34567891234567"));
    }

    @Test
    void loginCorrectly()
    {
        assertTrue(system.logIn("a.hammoda@nu.edu.eg","1234"));
    }
    @Test
    void loginCorrectMailWrongPassword()
    {
        assertFalse(system.logIn("a.hammoda@nu.edu.eg","1254"));
    }
    @Test
    void loginWrongMailCorrectPassword()
    {
        assertFalse(system.logIn("a.hamod@nu.edu.eg","1234"));
    }
    @Test
    void loginWrongMailWrongPassword()
    {
        assertFalse(system.logIn("a.hammd@nu.edu.eg","1284"));
    }
    @Test
    void SignUpWithCorrectCredentials()
    {
        assertTrue(system.signUp("a.hammd@nu.edu.eg","1284"));
    }
    @Test
    void SignUpWithInvalidMail()
    {
        assertFalse(system.signUp("a.hammdnu.edu.eg","1284"));
    }
    @Test
    void SignUpWithExistingMail()
    {
        assertFalse(system.signUp("a.hammoda@nu.edu.eg","1284"));
    }


}