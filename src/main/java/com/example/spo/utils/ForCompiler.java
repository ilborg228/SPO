package com.example.spo.utils;

public class ForCompiler implements Compiler{

    @Override
    public int execute(String code) {
        StringBuilder sb =new StringBuilder();
        sb.append("public class CustomProcessor {public static int m(String args[]) {int i=0");
        sb.append("for(");
        sb.append(code);
        sb.append("){");
        sb.append("i++}}}");
        return 0;
    }
}
