package hu.syngu00.monitoringdemo.mappers;

import am.ik.yavi.core.ConstraintViolation;
import hu.syngu00.monitoringdemo.exception.SpanishInquisitionException;
import hu.syngu00.monitoringdemo.models.dtos.ConstraintViolationDto;
import org.springframework.stereotype.Component;

@Component
public class ConstraintViolationMapper implements Mapper<ConstraintViolation, ConstraintViolationDto> {

    @Override
    public ConstraintViolationDto toDto(ConstraintViolation from) {
        if (from == null) {
            return null;
        }

        ConstraintViolationDto to = new ConstraintViolationDto();

        to.setArgs(from.args());
        to.setDefaultMessageFormat(from.defaultMessageFormat());
        to.setMessageKey(from.messageKey());
        to.setName(from.name());

        return to;
    }

    @Override
    public ConstraintViolation toEntity(ConstraintViolationDto from) {
        throw new SpanishInquisitionException("We should not receive ConstraintViolation as an input");
    }
}
