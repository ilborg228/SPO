package com.example.spo.exception;

public class InvalidEmailException extends Exception{
    public InvalidEmailException() {
        super("Email введен некорректно");
    }
}
