package com.example.spo.model;

import com.example.spo.presenter.InputPresenter;
import com.example.spo.utils.BinaryFileUtil;
import com.example.spo.utils.CsvFileUtil;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.List;

public class Binary {
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

    public List<Binary> open(String path) {
        BinaryFileUtil binaryFileUtil = new BinaryFileUtil();
        return binaryFileUtil.open(path);
    }

    public void save(List<Binary> elements, String path) throws IOException {
        BinaryFileUtil binaryFileUtil = new BinaryFileUtil();
        binaryFileUtil.save(elements, path);
    }

    public void add(InputPresenter inputPresenter, TableView tableView, List<Binary> openedBinaryFile) {
        BinaryFileUtil binaryFileUtil = new BinaryFileUtil();
        binaryFileUtil.add(inputPresenter, tableView, openedBinaryFile);
    }

    public void delete(int deleteThisNumber,TableView tableView,List<Binary> openedBinaryFile){
        BinaryFileUtil binaryFileUtil = new BinaryFileUtil();
        binaryFileUtil.delete(deleteThisNumber,tableView,openedBinaryFile);
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
