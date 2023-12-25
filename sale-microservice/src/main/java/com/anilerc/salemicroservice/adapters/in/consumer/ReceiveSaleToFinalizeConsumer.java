package com.anilerc.salemicroservice.adapters.in.consumer;

import com.anilerc.salemicroservice.adapters.out.message.SaleMessage;
import com.anilerc.salemicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.salemicroservice.application.ports.in.FinalizeSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToFinalizeConsumer {

    private final KafkaTemplate<String, SaleEvent> kafkaTemplate;
    private final FinalizeSaleInputPort finalizeSaleInputPort;

    public ReceiveSaleToFinalizeConsumer(KafkaTemplate<String, SaleEvent> kafkaTemplate, FinalizeSaleInputPort finalizeSaleInputPort) {
        this.kafkaTemplate = kafkaTemplate;
        this.finalizeSaleInputPort = finalizeSaleInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "saga-finalize")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.VALIDATED_PAYMENT.equals(saleMessage.saleEvent())) {
            log.info("VALIDATED_PAYMENT received. Finalizing the sale.");
            finalizeSaleInputPort.finalize(saleMessage.sale());

        }
    }


}
