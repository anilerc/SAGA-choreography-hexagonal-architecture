package com.anilerc.salemicroservice.adapters.out.repository;

import com.anilerc.salemicroservice.adapters.out.repository.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {
}
