/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userlogin;

/**
 *
 * @author RC_Student_lab
 */


public class Methods {
    String userName;
    String password;
    String firstName = "Test"; // Default first name for tests
    String surname = "User";    // Default surname for tests
    String enteredUserName;
    String enteredPassword;

    public boolean checkUsername() {
        // Username must contain an underscore and be 5 characters or fewer
        return userName.length() <= 5 && userName.contains("_");
    }

    public boolean checkPasswordComplexity() {
        // Password must contain at least 8 characters, one uppercase, one number, and one special character
        boolean capitalLetter = false;
        boolean number = false;
        boolean special = false;

        if (password.length() >= 8) {
            for (char ch : password.toCharArray()) {
                if (Character.isUpperCase(ch)) capitalLetter = true;
                if (Character.isDigit(ch)) number = true;
                if (!Character.isLetterOrDigit(ch)) special = true;
            }
        }
        return capitalLetter && number && special;
    }

    public String registerUser() {
        StringBuilder response = new StringBuilder();
        
        if (checkUsername()) {
            response.append("Username successfully captured.\n");
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        if (checkPasswordComplexity()) {
            response.append("Password successfully captured.");
        } else {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }

        return response.toString();
    }

    public boolean loginUser() {
        return userName.equals(enteredUserName) && password.equals(enteredPassword);
    }

    public String returnLoginStatus() {
        if (loginUser()) {
            return "Successful login\nWelcome " + firstName + ", " + surname + ", it is great to see you.";
        } else {
            return "A failed login\nUsername or Password incorrect, please try again.";
        }
    }
}

