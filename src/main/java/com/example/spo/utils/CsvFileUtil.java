package com.example.spo.utils;

import com.example.spo.model.CSV;
import com.example.spo.presenter.InputPresenter;
import com.example.spo.view.InputView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFileUtil implements FileUtil<CSV>{
    @Override
    public List<CSV> open(String path) {
        if(!path.endsWith("csv")){
            return null;
        }
        List<CSV> elements = new ArrayList<>();
        File csvFile = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while (br.ready()) {
                String[] st = br.readLine().split(",");
                CSV e = new CSV();
                e.setFileName(st[0]);
                e.setVersion(st[1]);
                e.setCreation(st[2]);
                elements.add(e);
            }
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        return elements;
    }


    @Override
    public void save(List<CSV> elements, String path) throws IOException {
        if(!path.endsWith("csv")){
            return;
        }
        File csvFile = new File(path);
        if(!csvFile.exists()){
            csvFile.createNewFile();
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(csvFile))) {
            for (CSV csv: elements) {
                String st = String.join(",",csv.getFileName(),csv.getVersion(),csv.getCreation());
                br.write(st);
                br.newLine();
            }
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void add(InputPresenter inputPresenter, TableView tableView, List<CSV> openedCSVFile){
        CSV element = new CSV();
        element.setFileName(inputPresenter.getFirstField());
        element.setVersion(inputPresenter.getSecondField());
        element.setCreation(inputPresenter.getThirdField());
        if(element.getFileName() != null && element.getVersion() != null &&
                element.getCreation() != null){
            TableColumn<CSV,String> FirstField = new TableColumn<>("First Field");
            TableColumn<CSV,String> SecondField = new TableColumn<>("Second Field");
            TableColumn<CSV,String> ThirdField = new TableColumn<>("Third Field");
            FirstField.setCellValueFactory(
                    new PropertyValueFactory<>("fileName")
            );
            SecondField.setCellValueFactory(
                    new PropertyValueFactory<>("version")
            );
            ThirdField.setCellValueFactory(
                    new PropertyValueFactory<>("creation")
            );
            tableView.getItems().clear();
            tableView.getColumns().clear();
            tableView.getColumns().addAll(FirstField,SecondField,ThirdField);
            openedCSVFile.add(element);
            for (int i = 0; i < openedCSVFile.size(); i++) {
                CSV openedFileElement = openedCSVFile.get(i);
                tableView.getItems().add(openedFileElement);
            }
        }
    }
    public void delete(int deleteThisNumber,TableView tableView,List<CSV> openedCSVFile){
        openedCSVFile.remove(deleteThisNumber);
        TableColumn<CSV,String> FirstField = new TableColumn<>("First Field");
        TableColumn<CSV,String> SecondField = new TableColumn<>("Second Field");
        TableColumn<CSV,String> ThirdField = new TableColumn<>("Third Field");
        FirstField.setCellValueFactory(
                new PropertyValueFactory<>("fileName")
        );
        SecondField.setCellValueFactory(
                new PropertyValueFactory<>("version")
        );
        ThirdField.setCellValueFactory(
                new PropertyValueFactory<>("creation")
        );
        tableView.getItems().clear();
        tableView.getColumns().clear();
        tableView.getColumns().addAll(FirstField,SecondField,ThirdField);
        for (int i = 0; i < openedCSVFile.size(); i++) {
            CSV openedFileElement = openedCSVFile.get(i);
            tableView.getItems().add(openedFileElement);
        }
    }
}
