package com.example.spo.model;

import java.util.Date;

public class CSV implements Element{

    private String fileName;
    private String version;
    private String creation;


    @Override
    public String getFirstField() {
        return fileName;
    }

    @Override
    public String getSecondField() {
        return version;
    }

    @Override
    public String getThirdField() {
        return creation;
    }

    @Override
    public void setFirstField(Object e) {
        this.fileName = (String) e;
    }

    @Override
    public void setSecondField(Object e) {
        this.version = (String) e;
    }

    @Override
    public void setThirdField(Object e) {
        this.creation = (String) e;
    }

    @Override
    public String toString() {
        return "CSV{" +
                "fileName='" + fileName + '\'' +
                ", version='" + version + '\'' +
                ", creation='" + creation + '\'' +
                '}';
    }
}
