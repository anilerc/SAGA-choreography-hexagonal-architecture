package com.anilerc.inventorymicroservice.adapters.in.consumer;

import com.anilerc.inventorymicroservice.adapters.out.message.SaleMessage;
import com.anilerc.inventorymicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.inventorymicroservice.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class ReceiveSaleToCreditInventoryConsumer {

    private final CreditInventoryInputPort creditInventoryInputPort;

    public ReceiveSaleToCreditInventoryConsumer(CreditInventoryInputPort creditInventoryInputPort) {
        this.creditInventoryInputPort = creditInventoryInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.FAILED_PAYMENT.equals(saleMessage.event())) {
            log.info("Payment failed. Applying rollback on inventory.");
            creditInventoryInputPort.credit(saleMessage.sale());
            log.info("Rollback applied on inventory after failed payment.");

        }
    }


}
