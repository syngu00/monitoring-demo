/*
 * Author: VÃ¡ncsodi MÃ¡rk
 * Product owner is: VÃ¡ncsodi MÃ¡rk
 * Contact: vancsodi.mark@rfit.hu
 * Contributors:
 * This file is part of DataCommon project.
 * Copyright RF-IT Hungary Kft.(C) 2018 http://www.rfit.hu
 */
package hu.syngu00.monitoringdemo.models.entities.abstraction;

import hu.syngu00.monitoringdemo.models.AbstractPersistentEntity;
import hu.syngu00.monitoringdemo.models.entities.listeners.AbstractEntityListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
@Setter
@Audited
@EntityListeners(AbstractEntityListener.class)
@MappedSuperclass
public abstract class AbstractEntity<I extends Serializable> implements AbstractPersistentEntity<I> {

    @Version
    @Column(name = "version")
    private short version;

    @Column(name = "created_by", updatable = false, nullable = false)
    private String createdBy;

    @Column(name = "created_at", updatable = false, nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "last_modified_by", nullable = false)
    private String lastModifiedBy;

    @Column(name = "last_modified_at", nullable = false)
    private OffsetDateTime lastModifiedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return getVersion() == that.getVersion() && getIdentifier().equals(that.getIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVersion(), getIdentifier());
    }
}
