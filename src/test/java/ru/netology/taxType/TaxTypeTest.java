package ru.netology.taxType;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxTypeTest {
    TaxType sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new TaxType();
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

    @Test
    public void testCalculateTaxFor() {
        //arrange
        BigDecimal a = BigDecimal.valueOf(100), expected = BigDecimal.valueOf(0.0).setScale(2);

        //act
        BigDecimal result = sut.calculateTaxFor(a);

        //assert
        assertEquals(expected, result);
    }
}
