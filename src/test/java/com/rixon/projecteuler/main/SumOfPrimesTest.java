package com.rixon.projecteuler.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class SumOfPrimesTest {

    private PrimeFinder primeFinder;

    @Before
    public void setup() {
        primeFinder = new PrimeFinder();
    }

    @Test
    public void testSumOfPrimes() {
        int numberUptilWhicSumIsRequired = 10;
        int expectedSum = 17;
        //int actualSum = primeFinder.findSumOfPrimesUptil(numberUptilWhicSumIsRequired);
        //assertEquals("Sum is not as expected",expectedSum,actualSum);
        numberUptilWhicSumIsRequired = 2000000;
        long actualSum = primeFinder.findSumOfPrimesUptil(numberUptilWhicSumIsRequired);
        System.out.println("actualSum = " + actualSum);
    }
}
