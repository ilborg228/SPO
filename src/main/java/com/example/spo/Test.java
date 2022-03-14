package com.example.spo;

import com.example.spo.jni.JNI;

public class Test {
    public static void main(String[] args) {
        JNI jni = new JNI();
        System.out.println(jni.MULTIPLY(3,2));
        System.out.println(jni.OR(3,2));
    }
}
