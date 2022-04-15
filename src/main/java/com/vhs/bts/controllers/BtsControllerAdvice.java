package com.vhs.bts.controllers;

import com.vhs.bts.exceptions.BtsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = UserController.class)
public class BtsControllerAdvice {

    @ExceptionHandler(BtsException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, BtsException ex) {
        return new ResponseEntity<>(ex.getErrorMessage(), ex.getHttpStatus());
    }
}
