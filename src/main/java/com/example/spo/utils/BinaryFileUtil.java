package com.example.spo.utils;

import com.example.spo.model.Binary;
import com.example.spo.presenter.InputPresenter;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileUtil implements FileUtil<Binary>{

    @Override
    public List<Binary> open(String path) {
        List<Binary> elements = new ArrayList<>();
        File binaryFile = new File(path);
        try (DataInputStream dis = new DataInputStream(new FileInputStream(binaryFile))) {
            while (dis.available()>0){
                Binary e = new Binary();
                e.setLogin(dis.readUTF());
                e.setHashcode(dis.readLong());
                e.setEmail(dis.readUTF());
                elements.add(e);
            }
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        return elements;
    }

    @Override
    public void save(List<Binary> elements, String path) throws IOException {
        File binaryFile = new File(path);
        if(!binaryFile.exists()){
            binaryFile.createNewFile();
        }
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(binaryFile))) {
            for (Binary binary: elements) {
                dos.writeUTF(binary.getLogin());
                dos.writeLong(binary.getHashcode());
                dos.writeUTF(binary.getEmail());
            }
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void add(InputPresenter inputPresenter, TableView tableView, List<Binary> openedBinaryFile){
        Binary element = new Binary();
        element.setLogin(inputPresenter.getFirstField());
        element.setHashcode(Long.parseLong(inputPresenter.getSecondField()));
        element.setEmail(inputPresenter.getThirdField());
        if(element.getLogin() != null && element.getHashcode() != null &&
                element.getEmail() != null) {
            TableColumn<Binary,String> FirstField = new TableColumn<>("First Field");
            TableColumn<Binary,Long> SecondField = new TableColumn<>("Second Field");
            TableColumn<Binary,String> ThirdField = new TableColumn<>("Third Field");
            FirstField.setCellValueFactory(
                    new PropertyValueFactory<>("login")
            );
            SecondField.setCellValueFactory(
                    new PropertyValueFactory<>("hashcode")
            );
            ThirdField.setCellValueFactory(
                    new PropertyValueFactory<>("email")
            );
            tableView.getItems().clear();
            tableView.getColumns().clear();
            tableView.getColumns().addAll(FirstField,SecondField,ThirdField);
            openedBinaryFile.add(element);
            for (int i = 0; i < openedBinaryFile.size(); i++) {
                Binary openedFileElement = openedBinaryFile.get(i);
                int Fixer = i + 1;
                tableView.getItems().add(openedFileElement);
            }
        }
    }
    public void delete(Integer deleteThisNumber, TableView tableView, List<Binary> openedBinaryFile){
        int deleteNumber = deleteThisNumber - 1;
        if (deleteNumber != -1 && deleteNumber < openedBinaryFile.size()){
            openedBinaryFile.remove(deleteNumber);
            TableColumn<Binary,String> FirstField = new TableColumn<>("First Field");
            TableColumn<Binary,Long> SecondField = new TableColumn<>("Second Field");
            TableColumn<Binary,String> ThirdField = new TableColumn<>("Third Field");
            FirstField.setCellValueFactory(
                    new PropertyValueFactory<>("login")
            );
            SecondField.setCellValueFactory(
                    new PropertyValueFactory<>("hashcode")
            );
            ThirdField.setCellValueFactory(
                    new PropertyValueFactory<>("email")
            );
            tableView.getItems().clear();
            tableView.getColumns().clear();
            tableView.getColumns().addAll(FirstField,SecondField,ThirdField);
            for (int i = 0; i < openedBinaryFile.size(); i++) {
                Binary openedFileElement = openedBinaryFile.get(i);
                tableView.getItems().add(openedFileElement);
            }
        }
    }
}
