package com.example.spo.analyzer;

import com.example.spo.exception.InvalidCodeFormatException;
import com.example.spo.model.MyCode;
import net.openhft.compiler.CompilerUtils;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ForCompiler{

    public static int execute(MyCode code,int value) throws InvalidCodeFormatException {
        String className = "com.example.spo.utils.MyClass"+value;
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("package com.example.spo.utils;\n");
        javaCode.append("import java.io.*;\n");
        javaCode.append("public class MyClass").append(value).append(" implements Runnable {\n");
        javaCode.append("public void run() {\n");
        javaCode.append("int k = 0;\n");
        javaCode.append("for (").append(code.getCondition()).append("){\n");
        javaCode.append("k++;").append(code.getBody());
        javaCode.append("\n}");
        javaCode.append("\ntry (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(\"data1.txt\")))){\n");
        javaCode.append("dos.writeInt(k);").append("\n}");
        javaCode.append("catch (FileNotFoundException e) {\n");
        javaCode.append("e.printStackTrace();\n").append("\n}");
        javaCode.append("catch (IOException e) {\n");
        javaCode.append("e.printStackTrace();\n}");
        javaCode.append("\n}");
        javaCode.append("\n}");

        try {
            Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode.toString());
            Runnable runner = (Runnable) aClass.newInstance();
            runner.run();
            DataInputStream dos = new DataInputStream(new FileInputStream("data1.txt"));

            return dos.readInt();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new InvalidCodeFormatException();
        }
    }
}
