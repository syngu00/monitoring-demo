package hu.syngu00.monitoringdemo.validators;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validator;
import hu.syngu00.monitoringdemo.models.dtos.ItemDto;
import hu.syngu00.monitoringdemo.models.dtos._ItemDtoMeta;
import org.springframework.stereotype.Component;

@Component
public class ItemValidation implements Validation<ItemDto> {

    @Override
    public ConstraintViolations validate(ItemDto item) {
        Validator<ItemDto> validation = ValidatorBuilder.of(ItemDto.class)
                .constraint(_ItemDtoMeta.NAME, c -> c.notBlank().lessThanOrEqual(255))
                .constraint(_ItemDtoMeta.ITEMID, c -> c.notBlank().lessThanOrEqual(255))
                .constraint(_ItemDtoMeta.QTY, i -> i.notNull().greaterThanOrEqual(0))
                .build();
        return validation.validate(item);
    }
}
