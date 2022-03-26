package com.example.spo.utils;

import net.openhft.compiler.CompilerUtils;

public class ForCompiler{

    public static int execute(String code) throws Exception {
        String className = "com.example.spo.utils.MyClass";
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("package com.example.spo.utils;");
        javaCode.append("public class MyClass implements CodeSample {");
        javaCode.append("public int run() {");
        javaCode.append("int k = 0;");
        javaCode.append("for (").append(code).append("){");
        javaCode.append("k++;}return k;}}");

        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode.toString());
        CodeSample runner = (CodeSample) aClass.newInstance();
        return runner.run();
    }
}
