package com.arjun.learn.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4,5),
            "Regular multiplication should work");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    public void testMultiplyWithZero() {
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Linux"));

        assertEquals(0, calculator.multiply(0,5), "Multiple with zero should be zero");
        assertEquals(0, calculator.multiply(5,0), "Multiple with zero should be zero");
    }

    @Test
    @DisplayName("Exception Testing")
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.throwExceptionExample(63));
        assertEquals("Integer greater than 50", exception.getMessage());
    }

    @Test
    @DisplayName("Grouping Assertions")
    void groupedAssertions() {
        Address address = new Address("John", "Delhi Road");

        assertAll("address name",
            () -> assertEquals("John", address.getOwner()),
            () -> assertEquals("Delhi Road", address.getStreet())
        );
    }
}
