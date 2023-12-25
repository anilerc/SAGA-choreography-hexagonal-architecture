package com.anilerc.inventorymicroservice.application.ports.out;

import com.anilerc.inventorymicroservice.application.core.domain.Sale;
import com.anilerc.inventorymicroservice.application.core.domain.enums.SaleEvent;

public interface SendUpdatedInventoryOutputPort {
    void send(Sale sale, SaleEvent saleEvent);
}
