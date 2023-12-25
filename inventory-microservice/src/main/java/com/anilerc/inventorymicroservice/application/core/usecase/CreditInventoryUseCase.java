package com.anilerc.inventorymicroservice.application.core.usecase;

import com.anilerc.inventorymicroservice.application.core.domain.Sale;
import com.anilerc.inventorymicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.inventorymicroservice.application.ports.in.CreditInventoryInputPort;
import com.anilerc.inventorymicroservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.anilerc.inventorymicroservice.application.ports.out.SendUpdatedInventoryOutputPort;
import com.anilerc.inventorymicroservice.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort;

    public CreditInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort, UpdateInventoryOutputPort updateInventoryOutputPort, SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdatedInventoryOutputPort = sendUpdatedInventoryOutputPort;
    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);

        sendUpdatedInventoryOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
}
