package com.example.spo.analyzer;

import com.example.spo.model.MyCode;

public class IfAnalyzer{

    public static MyCode getTargetCode(String baseString) throws Exception {
        int i1 = baseString.indexOf("if(");
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
        int i4 = baseString.indexOf("else{");
        if(i4 == -1){
            return MyCode.builder().condition(baseString.substring(i1+3,i2))
                    .body(baseString.substring(i2+2,i3)).build();
        }
        else {
            int i5 = baseString.indexOf("}",i4);
            if(i5 == -1){
                throw new Exception("Не корректная строка");
            }
            return MyCode.builder().condition(baseString.substring(i1+3,i2))
                    .body(baseString.substring(i2+2,i3)).bodyElse(baseString.substring(i4+5,i5)).build();
        }
    }
}
