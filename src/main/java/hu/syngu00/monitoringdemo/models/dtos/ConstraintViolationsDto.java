package hu.syngu00.monitoringdemo.models.dtos;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class ConstraintViolationsDto {
    private List<ConstraintViolationDto> violations = new ArrayList<>();
    private boolean valid;
}
