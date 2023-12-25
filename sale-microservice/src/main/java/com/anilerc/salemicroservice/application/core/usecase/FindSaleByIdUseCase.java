package com.anilerc.salemicroservice.application.core.usecase;

import com.anilerc.salemicroservice.application.core.domain.Sale;
import com.anilerc.salemicroservice.application.ports.in.FindSaleByIdInputPort;
import com.anilerc.salemicroservice.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(final Integer id) {
        return findSaleByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("No such sale exists."));
    }

}
