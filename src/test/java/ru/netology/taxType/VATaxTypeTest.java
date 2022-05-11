package ru.netology.taxType;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VATaxTypeTest {
    VATaxType sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new VATaxType();
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
    public void testCalculateTaxFor(Double doubleA, Double doubleExpected) {
        //arrange
        BigDecimal a = BigDecimal.valueOf(doubleA);
        BigDecimal expected = BigDecimal.valueOf(doubleExpected).setScale(2, RoundingMode.HALF_UP);

        //act
        BigDecimal result = sut.calculateTaxFor(a);

        //assert
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(0., 0.),
                Arguments.of(0.1, .018),
                Arguments.of(100., 18.),
                Arguments.of(100000., 18000.)
        );
    }
}
