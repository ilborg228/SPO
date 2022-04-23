package com.example.spo.exception;

public class InvalidCodeFormatException extends Exception{

    public InvalidCodeFormatException() {
        super("Код введен некорректно");
    }
}
