package com.anilerc.salemicroservice.adapters.in.controller;

import com.anilerc.salemicroservice.adapters.in.controller.mapper.SaleRequestMapper;
import com.anilerc.salemicroservice.adapters.in.controller.request.SaleRequest;
import com.anilerc.salemicroservice.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    private final CreateSaleInputPort createSaleInputPort;
    private final SaleRequestMapper saleRequestMapper;

    public SaleController(CreateSaleInputPort createSaleInputPort, SaleRequestMapper saleRequestMapper) {
        this.createSaleInputPort = createSaleInputPort;
        this.saleRequestMapper = saleRequestMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Valid @RequestBody SaleRequest saleRequest) {
        log.info("CREATING NEW SALE.");
        createSaleInputPort.create(saleRequestMapper.toSale(saleRequest));

    }
}
