package com.example.spo.utils;

import com.example.spo.model.CSV;
import com.example.spo.model.Element;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvFileUtil implements FileUtil{
    @Override
    public List<Element> open(String path) {
        if(!path.endsWith("csv")){
            return null;
        }
        List<Element> elements = new ArrayList<>();
        File csvFile = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while (br.ready()) {
                String[] st = br.readLine().split(",");
                CSV csv = new CSV();
                csv.setFirstField(st[0]);
                csv.setSecondField(st[1]);
                csv.setThirdField(st[2]);
                elements.add(csv);
            }
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        return elements;
    }


    @Override
    public void save(List<Element> elements, String path) throws IOException {
        if(!path.endsWith("csv")){
            return;
        }
        File csvFile = new File(path);
        if(!csvFile.exists()){
            csvFile.createNewFile();
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(csvFile))) {
            for (Element csv: elements) {
                String st = String.join(",",(String)csv.getFirstField(),(String)csv.getSecondField(),(String) csv.getThirdField());
                br.write(st);
                br.newLine();
            }
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
    }
}
