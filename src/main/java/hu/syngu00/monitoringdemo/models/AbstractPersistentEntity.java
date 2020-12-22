package hu.syngu00.monitoringdemo.models;

import java.io.Serializable;
import java.time.OffsetDateTime;

public interface AbstractPersistentEntity<I extends Serializable> extends PersistentEntity<I> {

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    OffsetDateTime getCreatedAt();

    void setCreatedAt(OffsetDateTime createdDate);

    String getLastModifiedBy();

    void setLastModifiedBy(String updatedBy);

    OffsetDateTime getLastModifiedAt();

    void setLastModifiedAt(OffsetDateTime updatedDate);
}
