package com.labreporting.labreporting.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueIdentityValidator.class })
public @interface UniqueIdentity {
	String message() default "Identity must be unique";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
