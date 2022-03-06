package com.example.spo.utils;

import com.example.spo.model.Element;

import java.io.IOException;
import java.util.List;

public interface FileUtil {

    List<Element> open(String fileName);

    void save(List<Element> elements, String path) throws IOException;

}
