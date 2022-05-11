package ru.netology.taxType;

import java.math.BigDecimal;

public class ProgressiveTaxType extends TaxType {
    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        taxAmount = new BigDecimal(amount.compareTo(new BigDecimal("100000.0")) > 0 ? "15.0" : "10.0");
        return super.calculateTaxFor(amount);
    }
}
