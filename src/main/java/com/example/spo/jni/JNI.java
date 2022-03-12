package com.example.spo.jni;

public class JNI {
    static {
        System.loadLibrary("native");
    }

    private native int OR(int a, int b);
    private native int MULTIPLY(int a, int b);
}
