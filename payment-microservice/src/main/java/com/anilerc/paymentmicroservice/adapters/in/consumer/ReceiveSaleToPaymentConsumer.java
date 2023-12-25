package com.anilerc.paymentmicroservice.adapters.in.consumer;

import com.anilerc.paymentmicroservice.adapters.out.message.SaleMessage;
import com.anilerc.paymentmicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.paymentmicroservice.application.ports.in.SalePaymentInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    public ReceiveSaleToPaymentConsumer(SalePaymentInputPort salePaymentInputPort) {
        this.salePaymentInputPort = salePaymentInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.UPDATED_INVENTORY.equals(saleMessage.saleEvent())){
            log.info("Sale received; processing the payment...");
            salePaymentInputPort.processPayment(saleMessage.sale());
            log.info("Payment processing completed.");
        }
    }

}
