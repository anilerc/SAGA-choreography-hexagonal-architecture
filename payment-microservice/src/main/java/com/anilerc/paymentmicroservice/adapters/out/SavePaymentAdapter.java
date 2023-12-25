package com.anilerc.paymentmicroservice.adapters.out;

import com.anilerc.paymentmicroservice.adapters.out.repository.PaymentRepository;
import com.anilerc.paymentmicroservice.adapters.out.repository.mapper.PaymentEntityMapper;
import com.anilerc.paymentmicroservice.application.core.domain.Payment;
import com.anilerc.paymentmicroservice.application.ports.out.SavePaymentOutputPort;
import org.springframework.stereotype.Component;

@Component
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentRepository paymentRepository;
    private final PaymentEntityMapper paymentEntityMapper;

    public SavePaymentAdapter(PaymentRepository paymentRepository, PaymentEntityMapper paymentEntityMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentEntityMapper = paymentEntityMapper;
    }

    @Override
    public void save(Payment payment) {
        var paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }
}
