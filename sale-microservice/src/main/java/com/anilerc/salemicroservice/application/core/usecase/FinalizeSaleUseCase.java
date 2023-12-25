package com.anilerc.salemicroservice.application.core.usecase;

import com.anilerc.salemicroservice.application.core.domain.Sale;
import com.anilerc.salemicroservice.application.core.domain.enums.SaleStatus;
import com.anilerc.salemicroservice.application.ports.in.FinalizeSaleInputPort;
import com.anilerc.salemicroservice.application.ports.in.FindSaleByIdInputPort;
import com.anilerc.salemicroservice.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public FinalizeSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort, SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void finalize(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());

        saleResponse.setStatus(SaleStatus.FINALIZED);

        saveSaleOutputPort.save(saleResponse);

    }
}
