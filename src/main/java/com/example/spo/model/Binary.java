package com.example.spo.model;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Entity
public class Binary implements Element{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    /**
     * Zero args constructor
     */
    public Binary() {
    }

    /**
     * @return first field
     */
    @Override
    public Object getFirstField() {
        return login;
    }

    /**
     * @return second field
     */
    @Override
    public Object getSecondField() {
        return hashcode;
    }

    /**
     * @return third field
     */
    @Override
    public Object getThirdField() {
        return email;
    }

    /**
     * Set first field value
     * @param e - first field
     */
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
