package com.rixon.projecteuler.main;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by rixonmathew on 01/04/15.
 */
public class PrimeFactorTest {

    private PrimeFactorFinder primeFactorFinder;

    @Before
    public void setup(){
        primeFactorFinder = new PrimeFactorFinder();
    }

    @Test
    public void testPrimeFactorFinder() {
        long number = 13195l;
        Set<Long> expectedFactors = new HashSet<>(Arrays.asList(5l,7l,13l,29l));
        Set<Integer> actualFactors = primeFactorFinder.find(600851475143l);
        actualFactors.stream().max((x,y)->Integer.max(x,y)).ifPresent(System.out::println);
        assertEquals("Factors are not as expected ", expectedFactors, actualFactors);
    }
}
