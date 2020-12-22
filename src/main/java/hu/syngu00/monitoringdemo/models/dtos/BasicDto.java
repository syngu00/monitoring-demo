package hu.syngu00.monitoringdemo.models.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BasicDto  extends AbstractDto{
    private Long id;
}
