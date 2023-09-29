package com.trip.api.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * code reference from https://tommykim.tistory.com/20
 */
@Documented
// 해당 어노테이션은 메소드, 필드, 파라미터에 적용할 수 있다.
@Target({ METHOD, FIELD, PARAMETER })
// 어노테이션을 런타임까지 유지한다.
@Retention(RetentionPolicy.RUNTIME)
// 해당 어노테이션이 실행할 ConstraintValidator 구현체를 지정한다.
@Constraint(validatedBy = { TypeValidator.class })
public @interface ValidateType {

    Class<? extends Enum<?>> enumClass();

    // 오류 메세지 관리를 위해 설정
    String message() default "올바른 타입이 아닙니다.";

    // 상황별 validation 제어를 위해 사용
    Class<?>[] groups() default {};

    // 심각도, group()보다 더 세밀하게 제어할 수 있으나 거의 사용하지 않음
    Class<? extends Payload>[] payload() default {};

    boolean ignoreCase() default false;
}
