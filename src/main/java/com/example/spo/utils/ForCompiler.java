package com.example.spo.utils;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ForCompiler implements Compiler{

    @Override
    public int compile(String code) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int results = compiler.run(null, null, null, "Foo.java");
        System.out.println("Success: " + (results == 0));
        return results;
    }
}
