package com.example.spo.model;

public class Binary implements Element{

    private String login;
    private Long hashcode;
    private String email;

    public Binary(String login, Long hashcode, String email) {
        this.login = login;
        this.hashcode = hashcode;
        this.email = email;
    }

    public Binary() {
    }

    @Override
    public Object getFirstField() {
        return login;
    }

    @Override
    public Object getSecondField() {
        return hashcode;
    }

    @Override
    public Object getThirdField() {
        return email;
    }

    @Override
    public void setFirstField(Object e) {
        this.login = (String) e;
    }

    @Override
    public void setSecondField(Object e) {
        this.hashcode = (Long) e;
    }

    @Override
    public void setThirdField(Object e) {
        this.email = (String) e;
    }

    @Override
    public String toString() {
        return "Binary{" +
                "login='" + login + '\'' +
                ", hashcode=" + hashcode +
                ", email='" + email + '\'' +
                '}';
    }
}
