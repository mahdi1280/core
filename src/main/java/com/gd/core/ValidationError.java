package com.gd.core;

public class ValidationError {

    private final String defaultMessage;
    private final String field;
    private final String rejectedValue;
    private final String code;

    private ValidationError(String defaultMessage, String field, String rejectedValue, String code) {
        this.defaultMessage = defaultMessage;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.code = code;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public String getField() {
        return field;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public String getCode() {
        return code;
    }

    static class Builder {

        private String defaultMessage;
        private String field;
        private String rejectedValue;
        private String code;

        private Builder() {
        }

        public Builder setDefaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
            return this;
        }

        public Builder setField(String field) {
            this.field = field;
            return this;
        }

        public Builder setRejectedValue(String rejectedValue) {
            this.rejectedValue = rejectedValue;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public ValidationError build() {
            return new ValidationError(defaultMessage, field, rejectedValue, code);
        }

    }

}
