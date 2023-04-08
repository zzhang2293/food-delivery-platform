package com.fooddeliveryplatform.result;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * this is a result class, when service response to front, it will put all data and status
 * int to the result class
 */
@Data
public class Result<T>{
    private Integer code; // status code

    private String msg; // error message

    private T data; // data  entity

    private Map<String, Object> map = new HashMap<>(); // data

    public static <T> Result<T> success(T object){
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 1;
        return result;
    }
    public static <T>Result<T> error(String error){
        Result<T> result = new Result<>();
        result.msg = error;
        result.code = 0;
        return result;
    }

    public Result<T> add(String key, T value){
        Result<T> result = new Result<>();
        result.map.put(key, value);
        return this;

    }
}
