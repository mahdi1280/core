package com.gd.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);
    private final MessageSourceAccessor messageSourceAccessor;

    public DefaultExceptionHandler(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler(RuleException.class)
    public ResponseEntity<List<ErrorMessage>> ruleExceptionHandler(RuleException ruleException) {
        List<ErrorMessage> errorMessages = new ArrayList<>();
        for (ErrorMessage errorMessage : ruleException.getErrorMessages()) {
            errorMessages.add(ErrorMessage.error(messageSourceAccessor.getMessage(errorMessage.getMessage()), errorMessage.getCode()));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessages);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<List<ErrorMessage>> illegalArgumentExceptionException(IllegalArgumentException illegalArgumentException) {
        List<ErrorMessage> errorMessages = new ArrayList<>(Collections.singletonList(ErrorMessage.error(messageSourceAccessor.getMessage("data.code.not.valid"), "data.code.not.valid")));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessages);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<ValidationError>> bindExceptionHandler(BindException e) {
        List<ValidationError> validationErrors = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            ValidationError validationError = ValidationError.builder().setCode(fieldError.getCode()).setDefaultMessage(fieldError.getDefaultMessage()).setField(fieldError.getObjectName()).setRejectedValue(String.valueOf(fieldError.getRejectedValue())).build();
            validationErrors.add(validationError);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<List<ErrorMessage>> exceptionHandler(Exception exception) {
        logger.error("This thrown exception handled in default exception handler.", exception);
        List<ErrorMessage> errorMessages = new ArrayList<>();
        errorMessages.add(ErrorMessage.error(messageSourceAccessor.getMessage("exception.error"), "exception.error"));
        return ResponseEntity.ok(errorMessages);
    }
}
