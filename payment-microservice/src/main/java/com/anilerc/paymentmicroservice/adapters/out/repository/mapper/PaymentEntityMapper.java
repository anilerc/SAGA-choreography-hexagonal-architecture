package com.anilerc.paymentmicroservice.adapters.out.repository.mapper;

import com.anilerc.paymentmicroservice.adapters.out.repository.entity.PaymentEntity;
import com.anilerc.paymentmicroservice.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);
}
