package ru.netology;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.taxType.IncomeTaxType;
import ru.netology.taxType.ProgressiveTaxType;
import ru.netology.taxType.TaxType;
import ru.netology.taxType.VATaxType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillTest {
    Bill sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testPayTaxes(Double doubleA, TaxType taxType, TaxService taxService, Double doubleExpected) {
        //arrange
        BigDecimal a = BigDecimal.valueOf(doubleA);
        sut = new Bill(a, taxType, taxService);
        BigDecimal expected = BigDecimal.valueOf(doubleExpected).setScale(2, RoundingMode.HALF_UP);

        //act
        BigDecimal result = sut.payTaxes();

        //assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        TaxService taxService = new TaxService();
        return Stream.of(
                Arguments.of(0., new IncomeTaxType(), taxService, 0.),
                Arguments.of(100., new IncomeTaxType(), taxService, 13.),
                Arguments.of(0., new VATaxType(), taxService, 0.),
                Arguments.of(100., new VATaxType(), taxService, 18.),
                Arguments.of(0., new ProgressiveTaxType(), taxService, 0.),
                Arguments.of(100., new ProgressiveTaxType(), taxService, 10.),
                Arguments.of(100001., new ProgressiveTaxType(), taxService, 15000.15)
        );
    }
}
