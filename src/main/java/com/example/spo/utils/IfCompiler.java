package com.example.spo.utils;

import net.openhft.compiler.CompilerUtils;

public class IfCompiler {
    public static int execute(String code) throws Exception{
        String className = "com.example.spo.utils.MyClass2";
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("package com.example.spo.utils;");
        javaCode.append("public class MyClass2 implements CodeSample {");
        javaCode.append("public int run() {");
        javaCode.append("int k;");
        javaCode.append("if (").append(code).append("){");
        javaCode.append("k = 1;}").append("else{k=0;}");
        javaCode.append("return k;}}");

        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode.toString());
        CodeSample runner = (CodeSample) aClass.newInstance();
        return runner.run();
    }
}
