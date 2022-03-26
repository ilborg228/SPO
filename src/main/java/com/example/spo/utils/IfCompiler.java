package com.example.spo.utils;

import com.example.spo.model.MyCode;
import net.openhft.compiler.CompilerUtils;

public class IfCompiler {
    public static int execute(MyCode code) throws Exception{
        String className = "com.example.spo.utils.MyClass2";
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("package com.example.spo.utils;");
        javaCode.append("public class MyClass2 implements CodeSample {");
        javaCode.append("public int run() {");
        javaCode.append("int k=-1;");
        javaCode.append("if (").append(code.getCondition()).append("){");
        javaCode.append(code.getBody());
        javaCode.append("k = 1;}");
        if(code.getBodyElse()!=null){
            javaCode.append("else{k=0;").append(code.getBodyElse()).append("}");
        }
        javaCode.append("return k;}}");

        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode.toString());
        CodeSample runner = (CodeSample) aClass.newInstance();
        return runner.run();
    }
}
