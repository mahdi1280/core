package com.gd.core;

public class ValidationError {

    private String defaultMessage;
    private String field;
    private String rejectedValue;
    private String code;

    public ValidationError(String defaultMessage, String field, String rejectedValue, String code) {
        this.defaultMessage = defaultMessage;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.code = code;
    }

    public ValidationError() {
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static Builder builder(){
        return new Builder();
    }

    private static class Builder{

        private String defaultMessage;
        private String field;
        private String rejectedValue;
        private String code;

        private Builder(){}

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

        public ValidationError build(){
            return new ValidationError(defaultMessage,field,rejectedValue,code);
        }
    }
}
