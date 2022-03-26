package com.example.spo.utils;

import com.example.spo.model.MyCode;

public class ForAnalyzer{

    public static MyCode getTargetCode(String baseString) throws Exception{
        int i1 = baseString.indexOf("for(");
        if(i1 == -1){
            throw new Exception("Не корректная строка");
        }
        int i2 = baseString.indexOf("){");
        if(i2 == -1){
            throw new Exception("Не корректная строка");
        }
        int i3 = baseString.indexOf("}");
        if(i3 == -1){
            throw new Exception("Не корректная строка");
        }
        return MyCode.builder().condition(baseString.substring(i1+4,i2-1)).body(baseString.substring(i2+2,i3-1)).build();
    }
}
