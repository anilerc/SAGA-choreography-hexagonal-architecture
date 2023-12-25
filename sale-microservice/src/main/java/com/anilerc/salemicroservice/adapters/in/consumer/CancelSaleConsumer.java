package com.anilerc.salemicroservice.adapters.in.consumer;

import com.anilerc.salemicroservice.adapters.out.message.SaleMessage;
import com.anilerc.salemicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.salemicroservice.application.ports.in.CancelSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelSaleConsumer {

    private final CancelSaleInputPort cancelSaleInputPort;

    public CancelSaleConsumer(CancelSaleInputPort cancelSaleInputPort) {
        this.cancelSaleInputPort = cancelSaleInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.saleEvent())) {
            log.info("Received rollback message. Cancelling the sale!");
            cancelSaleInputPort.cancel(saleMessage.sale());

        }
    }

}
