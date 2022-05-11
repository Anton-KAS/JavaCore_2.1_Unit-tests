package ru.netology.taxType;

import java.math.BigDecimal;

public class TaxType {
    BigDecimal taxAmount = new BigDecimal("0.0");

    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return (amount.multiply(taxAmount)).multiply(new BigDecimal("0.01"));
    }
}
