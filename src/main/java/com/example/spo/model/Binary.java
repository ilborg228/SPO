package com.example.spo.model;

public class Binary{
    /**
     * Login field
     */
    private String login;
    /**
     * Password hashcode
     */
    private Long hashcode;
    /**
     * Email field
     */
    private String email;

    /**
     * All args constructor
     *
     * @param login
     * @param hashcode
     * @param email
     */
    public Binary(String login, Long hashcode, String email) {
        this.login = login;
        this.hashcode = hashcode;
        this.email = email;
    }

    public Binary() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getHashcode() {
        return hashcode;
    }

    public void setHashcode(Long hashcode) {
        this.hashcode = hashcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
