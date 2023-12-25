package com.anilerc.inventorymicroservice.adapters.out;

import com.anilerc.inventorymicroservice.adapters.out.repository.InventoryRepository;
import com.anilerc.inventorymicroservice.adapters.out.repository.mapper.InventoryEntityMapper;
import com.anilerc.inventorymicroservice.application.core.domain.Inventory;
import com.anilerc.inventorymicroservice.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {


    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;


    public FindInventoryByProductIdAdapter(InventoryRepository inventoryRepository, InventoryEntityMapper inventoryEntityMapper) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryEntityMapper = inventoryEntityMapper;
    }


    @Override
    public Optional<Inventory> find(Integer productId) {
        var foundInventoryEntity = inventoryRepository.findByProductId(productId);
        return foundInventoryEntity.map(inventoryEntityMapper::toInventory);
    }
}
