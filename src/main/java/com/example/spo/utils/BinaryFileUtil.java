package com.example.spo.utils;

import com.example.spo.model.Binary;

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
}
