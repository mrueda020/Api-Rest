package com.example.demo.api;

public class ApiError {

    private String error;

    private String status;

    public ApiError(){

    }

    public ApiError(String error, String status){

        this.error = error;

        this.status = status;

    }

}
