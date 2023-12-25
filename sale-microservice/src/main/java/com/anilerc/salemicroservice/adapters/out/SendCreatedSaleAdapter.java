package com.anilerc.salemicroservice.adapters.out;

import com.anilerc.salemicroservice.adapters.out.message.SaleMessage;
import com.anilerc.salemicroservice.application.core.domain.Sale;
import com.anilerc.salemicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.salemicroservice.application.ports.out.SendCreatedSaleOutputPort;
import org.springframework.kafka.core.KafkaTemplate;

public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    public SendCreatedSaleAdapter(KafkaTemplate<String, SaleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
