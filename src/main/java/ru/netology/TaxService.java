package ru.netology;

import java.math.BigDecimal;

public class TaxService {
    public BigDecimal payOut(BigDecimal taxAmount) {
        System.out.print("Уплачен налог в размере ");
        BigDecimal result = taxAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result);
        return result;
    }
}
