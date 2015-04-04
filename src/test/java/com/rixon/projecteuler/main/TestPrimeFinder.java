package com.rixon.projecteuler.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class TestPrimeFinder {

    private PrimeFinder primeFinder;

    @Before
    public void setup() {
        primeFinder = new PrimeFinder();
    }

    @Test
    public void testFindingPrime() {
        int termToFind = 6;
        long expectedAnser = 13;
        long actualAnswer = primeFinder.findPrimerNumber(termToFind);
        assertEquals("Prime number value is not same",expectedAnser,actualAnswer);
        actualAnswer = primeFinder.findPrimerNumber(10001);
        System.out.println("actualAnswer = " + actualAnswer);

    }


}
