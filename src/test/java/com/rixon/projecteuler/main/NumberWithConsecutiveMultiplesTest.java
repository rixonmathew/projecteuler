package com.rixon.projecteuler.main;

import org.apache.commons.math3.primes.Primes;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class NumberWithConsecutiveMultiplesTest {

    private NumberWithConsecutiveMultiplesFinder numberWithConsecutiveMultiplesFinder;

    @Before
    public void setup() {
        numberWithConsecutiveMultiplesFinder = new NumberWithConsecutiveMultiplesFinder();
    }

    @Test
    public void testNumberWithConsecutiveMultipleFinder() {
        int numberUptillWhichMultiple = 10;
        BigDecimal expectedNumber = BigDecimal.valueOf(2520l);
        BigDecimal smallestNumber = numberWithConsecutiveMultiplesFinder.find(numberUptillWhichMultiple);
        assertEquals("Number is not as per expectation",expectedNumber,smallestNumber);
        smallestNumber = numberWithConsecutiveMultiplesFinder.find(20);
        System.out.println("Smallest multiple for numbers upto 20 "+smallestNumber);

    }
}
