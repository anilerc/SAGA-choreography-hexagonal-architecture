package com.anilerc.inventorymicroservice.application.ports.out;

import com.anilerc.inventorymicroservice.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer productId);
}
