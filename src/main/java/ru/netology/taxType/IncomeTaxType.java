package ru.netology.taxType;

import java.math.BigDecimal;

public class IncomeTaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        taxAmount = BigDecimal.valueOf(13.0);
        return super.calculateTaxFor(amount);
    }
}

