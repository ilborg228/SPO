package com.example.spo.model;

public class CSV{

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
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
