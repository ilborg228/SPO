package com.example.spo.utils;

import lombok.extern.slf4j.Slf4j;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class MyCompiler {
    public static void compile() throws Exception {
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        if( jc == null) throw new Exception( "Compiler unavailable");

        String code = "public class CustomProcessor {public static void main(String args[]) {\n" +
                "    System.out.println(\"Hello, World\");\n" +
                "  }}";
        JavaSourceFromString jsfs = new JavaSourceFromString( "CustomProcessor", code);

        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList( jsfs);

        List<String> options = new ArrayList<String>();
        options.add("-d");
        options.add( compilationPath);
        options.add( "-classpath");
        URLClassLoader urlClassLoader =
                (URLClassLoader)Thread.currentThread().getContextClassLoader();
        StringBuilder sb = new StringBuilder();
        for (URL url : urlClassLoader.getURLs()) {
            sb.append(url.getFile()).append(File.pathSeparator);
        }
        sb.append( compilationPath);
        options.add(sb.toString());

        StringWriter output = new StringWriter();
        boolean success = jc.getTask( output, null, null, options, null, fileObjects).call();
        if( success) {
            System.out.println("Class has been successfully compiled");
        } else {
            throw new Exception( "Compilation failed :" + output);
        }
    }
}
