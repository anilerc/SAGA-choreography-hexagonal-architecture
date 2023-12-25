package com.anilerc.paymentmicroservice.adapters.out.repository;

import com.anilerc.paymentmicroservice.adapters.out.repository.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

}
