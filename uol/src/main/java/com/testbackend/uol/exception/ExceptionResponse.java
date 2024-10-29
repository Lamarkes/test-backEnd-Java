package com.testbackend.uol.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionResponse {


    private Date timestmap;

    private String message;

    private String details;
}
