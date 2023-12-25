package com.anilerc.inventorymicroservice.adapters.out.message;

import com.anilerc.inventorymicroservice.application.core.domain.Sale;
import com.anilerc.inventorymicroservice.application.core.domain.enums.SaleEvent;

public record SaleMessage(Sale sale, SaleEvent event) {}
