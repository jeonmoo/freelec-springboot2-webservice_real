package com.jojoldu.book_real.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  //이 어노테이션이 생성될수 있는 위치를 지정.
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    // @interface란 이 파일을 어노테이션 클래스로 지정한다는 뜻.
    // LoginUser 라는 어노테이션이 생겼다고 보면 됨.

}
