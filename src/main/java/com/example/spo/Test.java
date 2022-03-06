package com.example.spo;

import com.example.spo.model.Element;
import com.example.spo.utils.BinaryFileUtil;
import com.example.spo.utils.CsvFileUtil;
import com.example.spo.utils.FileUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        FileUtil util = new CsvFileUtil();
        List<Element> elements = util.open("src/main/resources/1.csv");
        System.out.println(Arrays.toString(elements.toArray()));

        util = new BinaryFileUtil();
        elements = util.open("src/main/resources/2.txt");
        System.out.println(Arrays.toString(elements.toArray()));
    }
}
