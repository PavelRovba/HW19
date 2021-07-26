package com.company.Lesson19.TaskTwo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface SignCode {
    ElementType type();
    int id();
}
