package ru.netology.taxType;

import java.math.BigDecimal;

public class VATaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        taxAmount = BigDecimal.valueOf(18.0);
        return super.calculateTaxFor(amount);
    }
}

