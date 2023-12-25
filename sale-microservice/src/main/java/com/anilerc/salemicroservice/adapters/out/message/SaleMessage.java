package com.anilerc.salemicroservice.adapters.out.message;

import com.anilerc.salemicroservice.application.core.domain.Sale;
import com.anilerc.salemicroservice.application.core.domain.enums.SaleEvent;

public record SaleMessage(Sale sale, SaleEvent saleEvent) { }
