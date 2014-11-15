package com.believe.we.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyHints {
	
	public enum Priority {LOW, MEDIUM, HIGH};
	public enum Status	 {STARTED, NOT_STARTED};
	
	public String author() default "yinr";
	public Priority priority() default Priority.LOW;
	public Status status() default Status.NOT_STARTED;
}
