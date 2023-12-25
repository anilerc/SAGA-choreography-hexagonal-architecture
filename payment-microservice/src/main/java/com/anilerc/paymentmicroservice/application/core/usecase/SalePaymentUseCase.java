package com.anilerc.paymentmicroservice.application.core.usecase;

import com.anilerc.paymentmicroservice.application.core.domain.Payment;
import com.anilerc.paymentmicroservice.application.core.domain.Sale;
import com.anilerc.paymentmicroservice.application.core.domain.enums.SaleEvent;
import com.anilerc.paymentmicroservice.application.ports.in.FindCustomerByIdInputPort;
import com.anilerc.paymentmicroservice.application.ports.in.SalePaymentInputPort;
import com.anilerc.paymentmicroservice.application.ports.out.SavePaymentOutputPort;
import com.anilerc.paymentmicroservice.application.ports.out.SendEventOutputPort;
import com.anilerc.paymentmicroservice.application.ports.out.UpdateCustomerOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendEventOutputPort sendEventOutputPort;

    public SalePaymentUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, UpdateCustomerOutputPort updateCustomerOutputPort, SavePaymentOutputPort savePaymentOutputPort, SendEventOutputPort sendEventOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendEventOutputPort = sendEventOutputPort;
    }

    @Override
    public void processPayment(Sale sale) {

        try {
            var customer = findCustomerByIdInputPort.find(sale.getUserId());

            if (customer.getAccountBalance().compareTo(sale.getValue()) < 0) {
                throw new RuntimeException("Customer account funds are not sufficient!");
            }

            customer.debitBalance(sale.getValue());
            updateCustomerOutputPort.update(customer);

            var payment = buildPaymentFromSale(sale);

            savePaymentOutputPort.save(payment); // save payment to DB

            sendEventOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT); // send successful payment to Kafka queue
        } catch (Exception e) {
            log.info("Payment failed!");
            sendEventOutputPort.send(sale, SaleEvent.FAILED_PAYMENT); // send failed payment to Kafka queue
        }
    }

    public Payment buildPaymentFromSale(Sale sale) {
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }
}
