package com.shadi.app.model;

import lombok.Data;
import lombok.RequiredArgsConstructor; //it will give us parameterise and default constructor

@Data
@RequiredArgsConstructor

public class Response {
    private Integer id;
    private String response;
}
