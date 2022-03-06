package com.example.spo.model;

import com.example.spo.utils.CsvFileUtil;
import com.example.spo.utils.FileUtil;

import java.io.IOException;

public class Ma {
    public static void main(String[] args) throws IOException {
        FileUtil util = new CsvFileUtil();
        util.save(util.open("src/main/resources/1.csv"),"src/main/resources/2.csv");
    }
}
