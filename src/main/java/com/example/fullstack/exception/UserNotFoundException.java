package com.example.fullstack.exception;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException (Integer id){
        super("User not found");
    }
}
