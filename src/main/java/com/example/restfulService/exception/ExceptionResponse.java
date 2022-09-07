package com.example.restfulService.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

// 예외에 대한 응답 정보를 담고 있는 클래스
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String detail;

}
