package com.notebookApp.utils.validators;

public class UserDetailValidator {
//    a-zA-Z0-9(@#$!_)]{8,20}
    public static boolean isValidPassword(String password){
        return password.matches("^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");
//        return password.matches("[a-zA-Z0-9(@#$!_)]{8,20}");
    }

    public static boolean isValidUserName(String userName){

        return userName.matches("[a-zA-Z0-9(@#$_)]{8,20}");
    }
    public static boolean isValidEmail(String email){
        return email.contains("@");

    }

    public static boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber.length() == 11;
    }
}
