package mutrix.prepa.app.demo.formRequest.Validators;


import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ExistDatabaseValidator.class)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistDatabase {
    String message() default "Aucun élément correspondant n'a été trouvé avec cet ID";;
    Class<?>[] groups() default {};

    Class<? extends jakarta.validation.Payload>[] payload() default {};

    Class<?> entity();

    boolean required() default true;
}
