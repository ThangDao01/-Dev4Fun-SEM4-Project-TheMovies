package com.example.jwttoken.dto;

public class BaseResponse <T>{
    public int status = 1;
    public String message = "success";
    public T data;

    public BaseResponse(){}

    public BaseResponse(T data) {
        this.data = data;
    }
}
