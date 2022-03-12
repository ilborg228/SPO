package com.example.spo.jni;

public class JNI {
    static {
        System.loadLibrary("native");
    }

    public native int OR(int a, int b);
    public native int MULTIPLY(int a, int b);
}
