package hu.syngu00.monitoringdemo.mappers;

import am.ik.yavi.core.ConstraintViolations;
import hu.syngu00.monitoringdemo.exception.SpanishInquisitionException;
import hu.syngu00.monitoringdemo.models.dtos.ConstraintViolationsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConstraintViolationsMapper implements Mapper<ConstraintViolations, ConstraintViolationsDto> {

    private final ConstraintViolationMapper mapper;

    @Autowired
    public ConstraintViolationsMapper(ConstraintViolationMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ConstraintViolationsDto toDto(ConstraintViolations from) {
        if (from == null) {
            return null;
        }

        ConstraintViolationsDto to = new ConstraintViolationsDto();

        to.setValid(from.isValid());
        to.setViolations(from.stream().map(mapper::toDto).collect(Collectors.toList()));

        return to;
    }

    @Override
    public ConstraintViolations toEntity(ConstraintViolationsDto from) {
        throw new SpanishInquisitionException("We should not receive page as an input");
    }
}
