package com.anilerc.salemicroservice.application.ports.in;

import com.anilerc.salemicroservice.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);
}
