package com.anilerc.salemicroservice.adapters.in.controller.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SaleRequest(@NotNull Integer userId, @NotNull Integer productId, @NotNull Integer quantity, @NotNull BigDecimal value) {
}
