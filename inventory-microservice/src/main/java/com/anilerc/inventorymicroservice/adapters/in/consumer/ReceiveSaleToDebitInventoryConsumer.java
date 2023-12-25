package com.anilerc.inventorymicroservice.adapters.in.consumer;

import com.anilerc.inventorymicroservice.adapters.out.message.SaleMessage;
import com.anilerc.inventorymicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.inventorymicroservice.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

    private final DebitInventoryInputPort debitInventoryInputPort;

    public ReceiveSaleToDebitInventoryConsumer(DebitInventoryInputPort debitInventoryInputPort) {
        this.debitInventoryInputPort = debitInventoryInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.CREATED_SALE.equals(saleMessage.event())) {
            log.info("CREATED_SALE event received. Applying debit from the stock.");
            debitInventoryInputPort.debit(saleMessage.sale());
            log.info("Debit successfully applied to stock.");
        }
    }
}
