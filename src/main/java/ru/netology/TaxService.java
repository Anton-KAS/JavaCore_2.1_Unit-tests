package ru.netology;

import java.math.BigDecimal;

public class TaxService {
    public void payOut(BigDecimal taxAmount) {
        System.out.print("Уплачен налог в размере ");
        System.out.println(taxAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }
}
