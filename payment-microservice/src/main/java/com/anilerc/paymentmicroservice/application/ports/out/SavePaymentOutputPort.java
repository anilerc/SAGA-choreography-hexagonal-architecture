package com.anilerc.paymentmicroservice.application.ports.out;

import com.anilerc.paymentmicroservice.application.core.domain.Payment;

public interface SavePaymentOutputPort {
    void save(Payment payment);
}
