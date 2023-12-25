package com.anilerc.paymentmicroservice.application.ports.in;

import com.anilerc.paymentmicroservice.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void processPayment(Sale sale);
}
