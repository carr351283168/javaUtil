package annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented//注解标记
public @interface AliasName {

    public String value() default "";

    public boolean isData() default false;
}
