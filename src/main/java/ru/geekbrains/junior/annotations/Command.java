package ru.geekbrains.junior.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {

    String name();

    String args();

    int minArgs() default 0;

    String desc();

    int maxArgs() default Integer.MAX_VALUE;

    boolean showInHelp() default true;

    String[] aliases();
}
