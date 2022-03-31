package com.example.spo.utils;

import com.example.spo.model.Binary;
import com.example.spo.presenter.InputPresenter;
import javafx.scene.control.TextArea;

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

    public void add(InputPresenter inputPresenter, TextArea ResultTextField, List<Binary> openedBinaryFile){
        Binary element = new Binary();
        element.setLogin(inputPresenter.getFirstField());
        element.setHashcode(Long.parseLong(inputPresenter.getSecondField()));
        element.setEmail(inputPresenter.getThirdField());
        if(element.getLogin() != null && element.getHashcode() != null &&
                element.getEmail() != null) {
            openedBinaryFile.add(element);
            String out = "№|Логин|Хэш-код пароля|email\n";
            for (int i = 0; i < openedBinaryFile.size(); i++) {
                Binary openedFileElement = openedBinaryFile.get(i);
                int Fixer = i + 1;
                out = out + Fixer + "|" + openedFileElement.getLogin() + "|" + openedFileElement.getHashcode() + "|" +
                        openedFileElement.getEmail() + "\n";
            }
            ResultTextField.setText(out);
        }
    }
    public void delete(Integer deleteThisNumber, TextArea ResultTextField, List<Binary> openedBinaryFile){
        openedBinaryFile.remove(deleteThisNumber);
        String out = "№|Логин|Хэш-код пароля|email\n";
        for (int i = 0; i < openedBinaryFile.size(); i++) {
            Binary openedFileElement = openedBinaryFile.get(i);
            int Fixer = i + 1;
            out = out + Fixer + "|" + openedFileElement.getLogin() + "|" + openedFileElement.getHashcode() + "|" +
                    openedFileElement.getEmail() + "\n";
        }
        ResultTextField.setText(out);
    }
}
