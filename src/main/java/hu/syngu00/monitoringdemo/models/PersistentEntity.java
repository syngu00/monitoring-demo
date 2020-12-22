/*
 * Author: VÃ¡ncsodi MÃ¡rk
 * Product owner is: VÃ¡ncsodi MÃ¡rk
 * Contact: vancsodi.mark@rfit.hu
 * Contributors:
 * This file is part of DataCommon project.
 * Copyright RF-IT Hungary Kft.(C) 2018 http://www.rfit.hu
 */
package hu.syngu00.monitoringdemo.models;

import java.io.Serializable;

public interface PersistentEntity<I extends Serializable> extends Serializable {

    short getVersion();

    void setVersion(short version);

    I getIdentifier();

    void setIdentifier(I identifier);

    default boolean hasId() {
        return getIdentifier() != null;
    }
}
