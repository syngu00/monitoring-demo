package hu.syngu00.monitoringdemo.models.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ConstraintViolationDto {
    private Object[] args;
    private String defaultMessageFormat;
    private String messageKey;
    private String name;
}
