package com.anilerc.salemicroservice.adapters.out;

import com.anilerc.salemicroservice.adapters.out.repository.SaleRepository;
import com.anilerc.salemicroservice.adapters.out.repository.mapper.SaleEntityMapper;
import com.anilerc.salemicroservice.application.core.domain.Sale;
import com.anilerc.salemicroservice.application.ports.out.FindSaleByIdOutputPort;

import java.util.Optional;

public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    public FindSaleByIdAdapter(SaleRepository saleRepository, SaleEntityMapper saleEntityMapper) {
        this.saleRepository = saleRepository;
        this.saleEntityMapper = saleEntityMapper;
    }

    @Override
    public Optional<Sale> find(Integer id) {
        var saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::toSale);
    }
}
