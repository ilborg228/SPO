package com.example.spo.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MyCode {
    private String condition;
    private String body;
    private String bodyElse;
}
