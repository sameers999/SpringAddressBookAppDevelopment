package com.bridgelabz.springaddressbookapp.exception;

public class AddressBookCustomException extends RuntimeException{
    public AddressBookCustomException(String message) {
        super(message);
    }
}
