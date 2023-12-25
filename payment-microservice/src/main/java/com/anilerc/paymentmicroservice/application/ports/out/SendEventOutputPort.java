package com.anilerc.paymentmicroservice.application.ports.out;

import com.anilerc.paymentmicroservice.application.core.domain.Sale;
import com.anilerc.paymentmicroservice.application.core.domain.enums.SaleEvent;

public interface SendEventOutputPort {

    void send(Sale sale, SaleEvent saleEvent);
}
