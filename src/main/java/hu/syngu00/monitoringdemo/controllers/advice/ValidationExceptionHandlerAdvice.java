package hu.syngu00.monitoringdemo.controllers.advice;

import hu.syngu00.monitoringdemo.exception.ConstraintViolationsException;
import hu.syngu00.monitoringdemo.exception.SpanishInquisitionException;
import hu.syngu00.monitoringdemo.mappers.ConstraintViolationsMapper;
import hu.syngu00.monitoringdemo.models.dtos.ConstraintViolationsDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ValidationExceptionHandlerAdvice {

    private final ConstraintViolationsMapper mapper;

    @ExceptionHandler({ConstraintViolationsException.class})
    public final ResponseEntity<ConstraintViolationsDto> handleException(Exception ex, WebRequest request) {
        if (!(ex instanceof ConstraintViolationsException)) {
            throw new SpanishInquisitionException("How do you even get here?");
        }
        ConstraintViolationsException cex = (ConstraintViolationsException) ex;

        if (log.isDebugEnabled()) {
            log.debug("ConstraintViolationsException has been handled by ValidationExceptionHandlerAdvice. Details: {}", cex.getViolations());
        }

        return new ResponseEntity<>(mapper.toDto(cex.getViolations()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}