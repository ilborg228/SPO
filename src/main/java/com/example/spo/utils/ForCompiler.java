package com.example.spo.utils;

import com.example.spo.model.MyCode;
import net.openhft.compiler.CompilerUtils;

public class ForCompiler{

    public static int execute(MyCode code) throws Exception {
        String className = "com.example.spo.utils.MyClass";
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("package com.example.spo.utils;");
        javaCode.append("public class MyClass implements CodeSample {");
        javaCode.append("public int run() {");
        javaCode.append("int k = 0;");
        javaCode.append("for (").append(code.getCondition()).append("){");
        javaCode.append("k++;").append(code.getBody());
        javaCode.append("}return k;}}");

        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode.toString());
        CodeSample runner = (CodeSample) aClass.newInstance();
        return runner.run();
    }
}
