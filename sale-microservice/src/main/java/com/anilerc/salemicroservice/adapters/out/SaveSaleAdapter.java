package com.anilerc.salemicroservice.adapters.out;

import com.anilerc.salemicroservice.adapters.out.repository.SaleRepository;
import com.anilerc.salemicroservice.adapters.out.repository.mapper.SaleEntityMapper;
import com.anilerc.salemicroservice.application.core.domain.Sale;
import com.anilerc.salemicroservice.application.ports.out.SaveSaleOutputPort;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    public SaveSaleAdapter(SaleRepository saleRepository, SaleEntityMapper saleEntityMapper) {
        this.saleRepository = saleRepository;
        this.saleEntityMapper = saleEntityMapper;
    }

    @Override
    public Sale save(Sale sale) {
        var saleEntity = saleEntityMapper.toSaleEntity(sale);
        var saleEntityResponse = saleRepository.save(saleEntity);

        return saleEntityMapper.toSale(saleEntityResponse);
    }
}
