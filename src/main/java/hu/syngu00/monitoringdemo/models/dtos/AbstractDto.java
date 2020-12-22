package hu.syngu00.monitoringdemo.models.dtos;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public abstract class AbstractDto {
    private short version;
    private String createdBy;
    private OffsetDateTime createdAt;
    private String lastModifiedBy;
    private OffsetDateTime lastModifiedAt;
}
