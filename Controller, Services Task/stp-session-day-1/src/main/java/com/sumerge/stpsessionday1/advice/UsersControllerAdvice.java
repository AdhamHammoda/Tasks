package com.sumerge.stpsessionday1.advice;

import com.sumerge.stpsessionday1.exceptions.UsersEmptyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersControllerAdvice {

    @ExceptionHandler(UsersEmptyException.class)
    public ResponseEntity handleUsersEmptyException(UsersEmptyException usersEmptyException)
    {
        return ResponseEntity.noContent().build();
    }
}
