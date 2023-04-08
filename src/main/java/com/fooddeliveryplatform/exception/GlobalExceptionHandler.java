package com.fooddeliveryplatform.exception;

import com.fooddeliveryplatform.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * global exception handler
 * aop mode
 */

@Slf4j
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {

    /**
     * exception handler method
     * @return
     */
    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException exception){
        log.error(exception.getMessage());
        if (exception.getMessage().contains("Duplicate entry")) {
            String msg = exception.getMessage().split(" ")[2] + "already exist";
            return Result.error(msg);
        }
        return Result.error("unknown error");
    }
}
