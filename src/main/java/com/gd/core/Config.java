package com.gd.core;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class Config {

    private final MessageSource messageSource;

    public Config(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
        return new MessageSourceAccessor(messageSource);
    }

    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean validatorFactoryBean=new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource);
        return validatorFactoryBean;
    }
}
