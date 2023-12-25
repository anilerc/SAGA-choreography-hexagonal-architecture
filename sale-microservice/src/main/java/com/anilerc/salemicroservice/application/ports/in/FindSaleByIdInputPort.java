package com.anilerc.salemicroservice.application.ports.in;

import com.anilerc.salemicroservice.application.core.domain.Sale;

public interface FindSaleByIdInputPort {

    Sale find(final Integer id);
}
