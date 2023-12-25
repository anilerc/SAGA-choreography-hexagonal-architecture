package com.anilerc.salemicroservice.adapters.in.controller.mapper;

import com.anilerc.salemicroservice.adapters.in.controller.request.SaleRequest;
import com.anilerc.salemicroservice.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
