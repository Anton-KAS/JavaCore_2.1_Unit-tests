package ru.netology;

import ru.netology.taxType.TaxType;

import java.math.BigDecimal;

public class Bill {
    private BigDecimal amount;
    private TaxType taxType;
    private TaxService taxService;

    public Bill(BigDecimal amount, TaxType taxType, TaxService taxService) {
        this.amount = amount;
        this.taxType = taxType;
        this.taxService = taxService;
    }

    public BigDecimal payTaxes() {
        // TODO вместо 0.0 посчитать размер налога исходя из TaxType
        BigDecimal taxAmount = taxType.calculateTaxFor(amount);
        BigDecimal result = taxService.payOut(taxAmount);
        return result;
    }
}
