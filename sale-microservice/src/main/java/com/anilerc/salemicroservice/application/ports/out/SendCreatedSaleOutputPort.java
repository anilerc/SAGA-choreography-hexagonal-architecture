package com.anilerc.salemicroservice.application.ports.out;

import com.anilerc.salemicroservice.application.core.domain.Sale;
import com.anilerc.salemicroservice.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);
}
