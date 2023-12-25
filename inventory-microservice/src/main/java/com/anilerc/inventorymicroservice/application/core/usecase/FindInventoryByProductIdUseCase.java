package com.anilerc.inventorymicroservice.application.core.usecase;

import com.anilerc.inventorymicroservice.application.core.domain.Inventory;
import com.anilerc.inventorymicroservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.anilerc.inventorymicroservice.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }


    @Override
    public Inventory find(Integer productId) {
        return findInventoryByProductIdOutputPort.find(productId).orElseThrow(() -> new RuntimeException("No stock found for this product ID."));
    }
}
