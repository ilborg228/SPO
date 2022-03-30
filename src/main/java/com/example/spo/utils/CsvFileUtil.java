package com.example.spo.utils;

import com.example.spo.model.CSV;


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
}
