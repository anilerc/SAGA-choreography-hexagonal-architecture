package com.anilerc.inventorymicroservice.application.ports.in;

import com.anilerc.inventorymicroservice.application.core.domain.Sale;

public interface CreditInventoryInputPort {
    void credit(Sale sale);
}
