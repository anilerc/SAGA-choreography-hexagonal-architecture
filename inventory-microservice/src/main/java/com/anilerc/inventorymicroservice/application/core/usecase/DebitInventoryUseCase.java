package com.anilerc.inventorymicroservice.application.core.usecase;

import com.anilerc.inventorymicroservice.application.core.domain.Sale;
import com.anilerc.inventorymicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.inventorymicroservice.application.ports.in.DebitInventoryInputPort;
import com.anilerc.inventorymicroservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.anilerc.inventorymicroservice.application.ports.out.SendUpdatedInventoryOutputPort;
import com.anilerc.inventorymicroservice.application.ports.out.UpdateInventoryOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort;

    public DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort, UpdateInventoryOutputPort updateInventoryOutputPort, SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdatedInventoryOutputPort = sendUpdatedInventoryOutputPort;
    }

    @Override
    public void debit(Sale sale) {

        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());

            // do we have enough stocks ?
            if (inventory.getQuantity() < sale.getQuantity()) {
                throw new RuntimeException("Insufficient stock for the product.");
            }

            inventory.debitQuantity(sale.getQuantity());

            updateInventoryOutputPort.update(inventory);

            sendUpdatedInventoryOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
        }
        catch (Exception e) {
            log.info("Failed to update inventory!");
            sendUpdatedInventoryOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
        }
    }
}

