package com.example.spo.analyzer;

import com.example.spo.exception.InvalidCodeFormatException;
import com.example.spo.model.MyCode;

public class ForAnalyzer{

    public static MyCode getTargetCode(String baseString) throws InvalidCodeFormatException{
        int i1 = baseString.indexOf("for(");
        if(i1 == -1){
            throw new InvalidCodeFormatException();
        }
        int i2 = baseString.indexOf("){");
        if(i2 == -1){
            throw new InvalidCodeFormatException();
        }
        int i3 = baseString.indexOf("}");
        if(i3 == -1){
            throw new InvalidCodeFormatException();
        }
        return MyCode.builder().condition(baseString.substring(i1+4,i2)).body(baseString.substring(i2+2,i3)).build();
    }
}
