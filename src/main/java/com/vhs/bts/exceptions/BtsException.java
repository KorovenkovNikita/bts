package com.vhs.bts.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class BtsException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String errorMessage;
}
