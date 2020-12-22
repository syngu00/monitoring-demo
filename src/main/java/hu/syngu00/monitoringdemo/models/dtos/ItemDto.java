package hu.syngu00.monitoringdemo.models.dtos;


import am.ik.yavi.meta.ConstraintTarget;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ItemDto extends BasicDto {
    private String name;
    private String itemID;
    private Integer qty;

    @ConstraintTarget
    public String getName() {
        return name;
    }

    @ConstraintTarget
    public String getItemID() {
        return itemID;
    }

    @ConstraintTarget
    public Integer getQty() {
        return qty;
    }
}
