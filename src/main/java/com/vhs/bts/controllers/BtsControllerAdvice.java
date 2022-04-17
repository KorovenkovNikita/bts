package com.vhs.bts.controllers;

import com.vhs.bts.exceptions.BtsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = UserController.class)
@Slf4j
public class BtsControllerAdvice {

    @ExceptionHandler(BtsException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, BtsException ex) {
        log.warn("Exception during request {}: {}, {}", request.getRequestURI(), ex.getHttpStatus(), ex.getErrorMessage());
        return new ResponseEntity<>(ex.getErrorMessage(), ex.getHttpStatus());
    }
}
