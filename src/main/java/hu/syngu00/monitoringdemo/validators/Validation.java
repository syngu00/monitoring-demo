package hu.syngu00.monitoringdemo.validators;

import am.ik.yavi.core.ConstraintViolations;
import hu.syngu00.monitoringdemo.exception.ConstraintViolationsException;

public interface Validation<T> {

    ConstraintViolations validate(T item);

    default void eagerValidate(T item) {
        ConstraintViolations violations = validate(item);
        if (!violations.isValid()) {
            throw new ConstraintViolationsException(String.format("Validation failed for %s class", item.getClass().getName()), violations, item);
        }
    }

}
