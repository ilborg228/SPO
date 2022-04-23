package com.example.spo.exception;

public class InvalidDateException extends Exception{
    public InvalidDateException() {
        super("Дата введенна некорректно (дд/мм/гг)");
    }
}
