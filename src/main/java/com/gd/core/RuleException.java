package com.gd.core;

import java.util.Collections;
import java.util.List;

public class RuleException extends RuntimeException {

    private List<ErrorMessage> errorMessages;

    public RuleException(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }


    public RuleException(ErrorMessage errorMessage) {
        this.errorMessages = Collections.singletonList(errorMessage);
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }

}
