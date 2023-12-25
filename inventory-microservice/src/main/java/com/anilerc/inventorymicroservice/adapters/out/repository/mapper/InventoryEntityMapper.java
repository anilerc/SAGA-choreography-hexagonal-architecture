package com.anilerc.inventorymicroservice.adapters.out.repository.mapper;

import com.anilerc.inventorymicroservice.adapters.out.repository.entity.InventoryEntity;
import com.anilerc.inventorymicroservice.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {

    Inventory toInventory(InventoryEntity inventoryEntity);
    InventoryEntity toInventoryEntity(Inventory inventory);

}
