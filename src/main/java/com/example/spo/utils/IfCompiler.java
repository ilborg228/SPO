package com.example.spo.utils;

import com.example.spo.model.MyCode;
import net.openhft.compiler.CompilerUtils;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class IfCompiler {
    public static int execute(MyCode code,int value) throws Exception{
        String className = "com.example.spo.utils.MyClass2"+value;
//        StringBuilder javaCode = new StringBuilder();
//        javaCode.append("package com.example.spo.utils;");
//        javaCode.append("public class MyClass2 implements CodeSample {");
//        javaCode.append("public int run() {");
//        javaCode.append("int k=-1;");
//        javaCode.append("if (").append(code.getCondition()).append("){");
//        javaCode.append(code.getBody());
//        javaCode.append(" k = 1;}");
//        if(code.getBodyElse()!=null){
//            javaCode.append("else{k=0;").append(code.getBodyElse()).append("}");
//        }
//        javaCode.append("return k;}}");
        String bodyElse = "";
        if(code.getBodyElse() != null){
            bodyElse = "else {"+code.getBodyElse()+"k = 1;}";
        }
        String javaCode = "package com.example.spo.utils;\n" +
                "\n" +
                "import java.io.*;\n" +
                "\n" +
                "public class MyClass2"+value+" implements Runnable\n" +
                "{\n" +
                "    public void run() {\n" +
                "        int k=-1;if ("+code.getCondition()+"){"+code.getBody()+"k = 0;}\n" +bodyElse+
                "        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(\"data.txt\")))) {\n" +
                "            dos.writeInt(k);\n" +
                "        } catch (FileNotFoundException e) {\n" +
                "            e.printStackTrace();\n" +
                "        } catch (IOException e) {\n" +
                "            e.printStackTrace();\n" +
                "        }\n" +
                "    }\n" +
                "}\n";

        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode.toString());
        Runnable runner = (Runnable) aClass.newInstance();
        runner.run();

        DataInputStream dos = new DataInputStream(new FileInputStream("data.txt"));

        return dos.readInt();
    }
}
