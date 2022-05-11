import ru.netology.Bill;
import ru.netology.TaxService;
import ru.netology.taxType.IncomeTaxType;
import ru.netology.taxType.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        Bill[] payments = new Bill[]{
                // TODO создать платежи с различным типами налогообложения
                new Bill(new BigDecimal("100000.0"), new IncomeTaxType(), taxService),
                new Bill(new BigDecimal("100000.0"), new VATaxType(), taxService),
                new Bill(new BigDecimal("100000.01"), new ProgressiveTaxType(), taxService),
                new Bill(new BigDecimal("100000.0"), new ProgressiveTaxType(), taxService)
        };
        for (Bill bill : payments) {
            bill.payTaxes();
        }
    }
}
