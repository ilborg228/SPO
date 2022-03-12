package com.example.spo.utils;

import com.example.spo.model.Binary;
import com.example.spo.model.Element;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileUtil implements FileUtil{
    @Override
    public List<Element> open(String path) {
        List<Element> elements = new ArrayList<>();
        File binaryFile = new File(path);
        try (DataInputStream dis = new DataInputStream(new FileInputStream(binaryFile))) {
            while (dis.available()>0){
                Element e = new Binary();
                e.setFirstField(dis.readUTF());
                e.setSecondField(dis.readLong());
                e.setThirdField(dis.readUTF());
                elements.add(e);
            }
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        return elements;
    }

    @Override
    public void save(List<Element> elements, String path) throws IOException {
        File binaryFile = new File(path);
        if(!binaryFile.exists()){
            binaryFile.createNewFile();
        }
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(binaryFile))) {
            for (Element csv: elements) {
                dos.writeUTF((String)csv.getFirstField());
                dos.writeLong((Long) csv.getSecondField());
                dos.writeUTF((String)csv.getThirdField());
            }
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
    }
}
