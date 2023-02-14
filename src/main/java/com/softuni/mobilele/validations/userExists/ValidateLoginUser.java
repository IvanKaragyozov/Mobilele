package com.softuni.mobilele.validations.userExists;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = LoginUserValidator.class)
public @interface ValidateLoginUser {

    String message() default "Username or password do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
