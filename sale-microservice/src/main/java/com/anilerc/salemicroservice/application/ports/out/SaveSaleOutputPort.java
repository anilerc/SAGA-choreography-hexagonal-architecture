package com.anilerc.salemicroservice.application.ports.out;

import com.anilerc.salemicroservice.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);
}
