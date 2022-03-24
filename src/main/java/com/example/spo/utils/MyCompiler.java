package com.example.spo.utils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCompiler {
    public static void compile(String code) throws Exception {
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        if( jc == null) throw new Exception( "Compiler unavailable");
        JavaSourceFromString jsfs = new JavaSourceFromString( "CustomProcessor", code);

        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList( jsfs);
        List<String> options = new ArrayList<String>();
        String compilationPath = "/Users/ilia/IdeaProjects/SPO/src";
        options.add("-d");
        options.add(compilationPath);
        StringWriter output = new StringWriter();
        boolean success = jc.getTask( output, null, null, null, null, fileObjects).call();
        if( success) {
            System.out.println("Class has been successfully compiled");
        } else {
            throw new Exception( "Compilation failed :" + output);
        }
    }
}
