package com.anilerc.paymentmicroservice.adapters.out.message;

import com.anilerc.paymentmicroservice.application.core.domain.Sale;
import com.anilerc.paymentmicroservice.application.core.domain.enums.SaleEvent;

public record SaleMessage(Sale sale, SaleEvent saleEvent) {
}
