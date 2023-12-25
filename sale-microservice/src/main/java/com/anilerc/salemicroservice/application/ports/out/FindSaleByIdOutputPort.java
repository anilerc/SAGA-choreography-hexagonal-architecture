package com.anilerc.salemicroservice.application.ports.out;

import com.anilerc.salemicroservice.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {
    Optional<Sale> find(final Integer id);
}
