package com.anilerc.inventorymicroservice.adapters.out;

import com.anilerc.inventorymicroservice.adapters.out.repository.InventoryRepository;
import com.anilerc.inventorymicroservice.adapters.out.repository.mapper.InventoryEntityMapper;
import com.anilerc.inventorymicroservice.application.core.domain.Inventory;
import com.anilerc.inventorymicroservice.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    public UpdateInventoryAdapter(InventoryRepository inventoryRepository, InventoryEntityMapper inventoryEntityMapper) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryEntityMapper = inventoryEntityMapper;
    }

    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
