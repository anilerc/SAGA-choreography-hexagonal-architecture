package com.anilerc.inventorymicroservice.application.ports.in;

import com.anilerc.inventorymicroservice.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);
}
