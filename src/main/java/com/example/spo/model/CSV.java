package com.example.spo.model;

import com.example.spo.presenter.InputPresenter;
import com.example.spo.utils.CsvFileUtil;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.List;

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

    public static List<CSV> open(String path){
        CsvFileUtil csvFileUtil = new CsvFileUtil();
        return csvFileUtil.open(path);
    }

    public static void save(List<CSV> elements, String path) throws IOException {
        CsvFileUtil csvFileUtil = new CsvFileUtil();
        csvFileUtil.save(elements,path);
    }

    public static void add(InputPresenter inputPresenter, TextArea ResultTextField, List<CSV> openedCSVFile){
        CsvFileUtil csvFileUtil = new CsvFileUtil();
        csvFileUtil.add(inputPresenter, ResultTextField, openedCSVFile);
    }

    public static void delete(int deleteThisNumber,TextArea ResultTextField,List<CSV> openedCSVFile){
        CsvFileUtil csvFileUtil = new CsvFileUtil();
        csvFileUtil.delete(deleteThisNumber, ResultTextField, openedCSVFile);
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
