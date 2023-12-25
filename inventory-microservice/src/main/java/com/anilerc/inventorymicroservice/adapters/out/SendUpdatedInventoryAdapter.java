package com.anilerc.inventorymicroservice.adapters.out;

import com.anilerc.inventorymicroservice.adapters.out.message.SaleMessage;
import com.anilerc.inventorymicroservice.application.core.domain.Sale;
import com.anilerc.inventorymicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.inventorymicroservice.application.ports.out.SendUpdatedInventoryOutputPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendUpdatedInventoryAdapter implements SendUpdatedInventoryOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    public SendUpdatedInventoryAdapter(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
