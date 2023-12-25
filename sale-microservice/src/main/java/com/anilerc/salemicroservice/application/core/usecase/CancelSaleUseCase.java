package com.anilerc.salemicroservice.application.core.usecase;

import com.anilerc.salemicroservice.application.core.domain.Sale;
import com.anilerc.salemicroservice.application.core.domain.enums.SaleStatus;
import com.anilerc.salemicroservice.application.ports.in.CancelSaleInputPort;
import com.anilerc.salemicroservice.application.ports.in.FindSaleByIdInputPort;
import com.anilerc.salemicroservice.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort, SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    public void cancel(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.CANCELLED);
        saveSaleOutputPort.save(saleResponse);

    }
}
