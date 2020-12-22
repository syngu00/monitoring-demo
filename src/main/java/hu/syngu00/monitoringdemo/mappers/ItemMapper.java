package hu.syngu00.monitoringdemo.mappers;

import hu.syngu00.monitoringdemo.models.dtos.ItemDto;
import hu.syngu00.monitoringdemo.models.entities.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements Mapper<Item, ItemDto> {


    @Override
    public Item toEntity(ItemDto from) {
        if (from == null) {
            return null;
        }

        Item to = new Item();

        to.setId(from.getId());
        to.setVersion(from.getVersion());
        to.setCreatedBy(from.getCreatedBy());
        to.setCreatedAt(from.getCreatedAt());
        to.setLastModifiedBy(from.getLastModifiedBy());
        to.setLastModifiedAt(from.getLastModifiedAt());
        to.setName(from.getName());
        to.setItemID(from.getItemID());
        to.setQty(from.getQty());

        return to;
    }

    @Override
    public ItemDto toDto(Item from) {
        if (from == null) {
            return null;
        }

        ItemDto to = new ItemDto();

        to.setId(from.getId());
        to.setVersion(from.getVersion());
        to.setCreatedBy(from.getCreatedBy());
        to.setCreatedAt(from.getCreatedAt());
        to.setLastModifiedBy(from.getLastModifiedBy());
        to.setLastModifiedAt(from.getLastModifiedAt());
        to.setName(from.getName());
        to.setItemID(from.getItemID());
        to.setQty(from.getQty());

        return to;
    }
}
