package com.nikita.hohunskyi.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultExceptionHandler.class);
    private static final String WRONG_PAGE_MESSAGE = "Wrong page. Use only positive natural numbers, please.";
    private static final String BAD_REQUEST_FROM_USER = "Bad request from user";

    @ExceptionHandler({MethodArgumentTypeMismatchException.class,
            IllegalArgumentException.class,
            IllegalStateException.class,
            ConversionFailedException.class,
            PropertyReferenceException.class,
            MissingServletRequestParameterException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> onServiceException(Exception e) {
        LOG.warn(BAD_REQUEST_FROM_USER, e);
        return ResponseEntity.badRequest().body(BAD_REQUEST_FROM_USER);
    }

}

