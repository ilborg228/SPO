package com.example.spo;

import com.example.spo.jni.JNI;
import com.example.spo.model.Element;
import com.example.spo.utils.BinaryFileUtil;
import com.example.spo.utils.CsvFileUtil;
import com.example.spo.utils.FileUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        JNI jni = new JNI();
        System.out.println(jni.MULTIPLY(3,2));
        System.out.println(jni.OR(3,2));
    }
}
