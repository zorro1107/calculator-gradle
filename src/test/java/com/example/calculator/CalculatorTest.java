package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("adds positive numbers")
    void addsPositiveNumbers() {
        assertEquals(7.0, calculator.add(3.0, 4.0));
    }

    @Test
    @DisplayName("subtracts numbers")
    void subtractsNumbers() {
        assertEquals(6.0, calculator.subtract(10.0, 4.0));
    }

    @Test
    @DisplayName("multiplies decimal numbers")
    void multipliesDecimalNumbers() {
        assertEquals(10.0, calculator.multiply(2.5, 4.0));
    }

    @Test
    @DisplayName("divides numbers")
    void dividesNumbers() {
        assertEquals(2.5, calculator.divide(10.0, 4.0));
    }

    @Test
    @DisplayName("rejects division by zero")
    void rejectsDivisionByZero() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(5.0, 0.0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("dispatches named operations")
    void dispatchesNamedOperations() {
        assertEquals(42.0, calculator.calculate(6.0, "multiply", 7.0));
    }

    @Test
    @DisplayName("dispatches symbol operations")
    void dispatchesSymbolOperations() {
        assertEquals(9.0, calculator.calculate(4.0, "+", 5.0));
    }

    @Test
    @DisplayName("rejects unsupported operators")
    void rejectsUnsupportedOperators() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calculator.calculate(1.0, "%", 2.0)
        );
    }
}
