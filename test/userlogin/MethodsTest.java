/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package userlogin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MethodsTest {
    
    private Methods instance;

    @Before
    public void setUp() {
        instance = new Methods();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testCheckUsername_Valid() {
        instance.userName = "kyl_1"; // Valid username
        assertTrue("Username should be correctly formatted.", instance.checkUsername());
    }

    @Test
    public void testCheckUsername_Invalid() {
        instance.userName = "kyle!!!!!!!"; // Invalid username
        assertFalse("Username should be incorrectly formatted.", instance.checkUsername());
    }

    @Test
    public void testRegisterUser_ValidUsernameAndPassword() {
        instance.userName = "kyl_1"; // Valid username
        instance.password = "Ch&&sec@ke99!"; // Valid password
        String result = instance.registerUser();
        assertEquals("Username successfully captured.\nPassword successfully captured.", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        instance.userName = "kyle!!!!!!!"; // Invalid username
        instance.password = "Ch&&sec@ke99!"; // Valid password
        String result = instance.registerUser();
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        instance.userName = "kyl_1"; // Valid username
        instance.password = "password"; // Invalid password
        String result = instance.registerUser();
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testLoginUser_Success() {
        instance.userName = "kyl_1"; 
        instance.password = "Ch&&sec@ke99!"; 
        instance.enteredUserName = "kyl_1";
        instance.enteredPassword = "Ch&&sec@ke99!";
        assertTrue("Login should be successful.", instance.loginUser());
    }

    @Test
    public void testLoginUser_Failure() {
        instance.userName = "kyl_1"; 
        instance.password = "Ch&&sec@ke99!"; 
        instance.enteredUserName = "wrong_user";
        instance.enteredPassword = "wrong_password";
        assertFalse("Login should fail.", instance.loginUser());
    }
    
    @Test
    public void testReturnLoginStatus_Success() {
        instance.userName = "kyl_1"; 
        instance.password = "Ch&&sec@ke99!"; 
        instance.enteredUserName = "kyl_1";
        instance.enteredPassword = "Ch&&sec@ke99!";
        instance.registerUser(); // Ensure registration passes
        assertEquals("Successful login\nWelcome Test, User, it is great to see you.", instance.returnLoginStatus());
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        instance.userName = "kyl_1"; 
        instance.password = "Ch&&sec@ke99!"; 
        instance.enteredUserName = "wrong_user";
        instance.enteredPassword = "wrong_password";
        assertEquals("A failed login\nUsername or Password incorrect, please try again.", instance.returnLoginStatus());
    }
}
