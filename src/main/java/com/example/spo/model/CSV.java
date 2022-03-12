package com.example.spo.model;

import java.util.Date;

public class CSV implements Element{

    /**
     * Filname field
     */
    private String fileName;
    /**
     * Version field
     */
    private String version;
    /**
     * Creation date field
     */
    private String creation;

    /**
     * @return first field
     */
    @Override
    public String getFirstField() {
        return fileName;
    }

    /**
     * @return second field
     */
    @Override
    public String getSecondField() {
        return version;
    }

    /**
     * @return third field
     */
    @Override
    public String getThirdField() {
        return creation;
    }

    /**
     * Set first field value
     * @param e first field new value
     */
    @Override
    public void setFirstField(Object e) {
        this.fileName = (String) e;
    }

    /**
     * Set second field value
     * @param e second field new value
     */
    @Override
    public void setSecondField(Object e) {
        this.version = (String) e;
    }

    /**
     * Set third field value
     * @param e third field new value
     */
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
