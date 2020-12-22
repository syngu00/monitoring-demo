package hu.syngu00.monitoringdemo.models.entities.listeners;

import hu.syngu00.monitoringdemo.models.AbstractPersistentEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.OffsetDateTime;

public class AbstractEntityListener {


    private static final String AUDIT_USER = "UNKNOWN";

    @PrePersist
    public void prePersist(Object object) {
        if (!(object instanceof AbstractPersistentEntity)) {
            return;
        }

        AbstractPersistentEntity<?> entity = (AbstractPersistentEntity<?>) object;
        OffsetDateTime now = OffsetDateTime.now();
        entity.setCreatedBy(AUDIT_USER);
        entity.setCreatedAt(now);
        entity.setLastModifiedBy(AUDIT_USER);
        entity.setLastModifiedAt(now);
    }

    @PreUpdate
    public void preUpdate(Object object) {
        if (!(object instanceof AbstractPersistentEntity)) {
            return;
        }

        AbstractPersistentEntity<?> entity = (AbstractPersistentEntity<?>) object;
        entity.setLastModifiedBy(AUDIT_USER);
        entity.setLastModifiedAt(OffsetDateTime.now());
    }


}
