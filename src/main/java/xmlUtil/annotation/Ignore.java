package xmlUtil.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)//生命周期
@Target(ElementType.FIELD)//作用域
@Documented//注解标记
public @interface Ignore {
}
