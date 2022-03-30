package com.example.spo.utils;

import java.io.IOException;
import java.util.List;

public interface FileUtil<E> {

    List<E> open(String path);

    void save(List<E> elements, String path) throws IOException;
}
