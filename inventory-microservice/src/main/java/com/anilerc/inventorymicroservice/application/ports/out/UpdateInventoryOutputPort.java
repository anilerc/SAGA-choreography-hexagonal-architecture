package com.anilerc.inventorymicroservice.application.ports.out;

import com.anilerc.inventorymicroservice.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {
    void update(Inventory inventory);
}
