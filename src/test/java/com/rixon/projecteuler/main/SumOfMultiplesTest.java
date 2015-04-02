package com.rixon.projecteuler.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rixonmathew on 04/01/15.
 */
public class SumOfMultiplesTest {

    private SumOfNumbersThatAreMultiples sumOfNumbersThatAreMultiples;
    private int limit =10;
    private int[] numbers;

    @Before
    public void setup() {
       sumOfNumbersThatAreMultiples = new SumOfNumbersThatAreMultiples();
       numbers = new int[]{3,5};
    }

    @After
    public void teardown() {
       sumOfNumbersThatAreMultiples = null;
    }

    @Test
    public void testComputeSum() {
        long sum = sumOfNumbersThatAreMultiples.computeSum(limit,numbers);
        assertTrue(sum==23);
        this.limit=1000;
        sum = sumOfNumbersThatAreMultiples.computeSum(limit,numbers);
        System.out.println(sum);
    }
}
