package hu.syngu00.monitoringdemo.models.entities;


import hu.syngu00.monitoringdemo.models.entities.abstraction.BasicEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Audited
@Table(name = "items")
public class Item extends BasicEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "item_id", nullable = false, unique = true)
    private String itemID;

    @Column(name = "qty", nullable = false)
    private Integer qty;
}
