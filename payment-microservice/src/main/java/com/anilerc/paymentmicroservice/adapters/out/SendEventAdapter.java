package com.anilerc.paymentmicroservice.adapters.out;

import com.anilerc.paymentmicroservice.adapters.out.message.SaleMessage;
import com.anilerc.paymentmicroservice.application.core.domain.Sale;
import com.anilerc.paymentmicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.paymentmicroservice.application.ports.out.SendEventOutputPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendEventAdapter implements SendEventOutputPort {


    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    public SendEventAdapter(KafkaTemplate<String, SaleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
