package shindo.Java.corejava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解类
 * Created by shindo on 2017/10/3.
 */

//@Retention 元注解
//Retention元注解有三种取值：RetentionPolicy.SOURCE、RetentionPolicy.CLASS、RetentionPolicy.RUNTIME
// 分别对应：java源文件-->class文件-->内存中的字节码
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ItcastAnnotation {
    String color() default "blue";//接口里面的方法默认是public和abstract的
    String value();
    int[] arrayAttr() default {3,4,4};
}
