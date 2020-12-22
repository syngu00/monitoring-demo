/*
 * Author: VÃ¡ncsodi MÃ¡rk
 * Product owner is: VÃ¡ncsodi MÃ¡rk
 * Contact: vancsodi.mark@rfit.hu
 * Contributors:
 * This file is part of DataCommon project.
 * Copyright RF-IT Hungary Kft.(C) 2018 http://www.rfit.hu
 */
package hu.syngu00.monitoringdemo.models.entities.abstraction;

import hu.syngu00.monitoringdemo.models.BasicPersistentEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@Audited
@MappedSuperclass
public abstract class BasicEntity extends AbstractEntity<Long> implements BasicPersistentEntity {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
