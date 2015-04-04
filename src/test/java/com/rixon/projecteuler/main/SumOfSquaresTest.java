package com.rixon.projecteuler.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class SumOfSquaresTest {

    @Test
    public void testSumOfSquares() {
        long numberOfTerms = 10;
        long expectedSum = 385;
        long actualSum = EulerMathHelper.sumOfSquares(numberOfTerms);
        assertEquals("Sum is not as expected", expectedSum, actualSum);
        long squareOfSums =  (long)Math.pow(numberOfTerms*(numberOfTerms+1)/2,2);
        System.out.println(" Difference (10 terms) "+(squareOfSums-actualSum));
        numberOfTerms = 100;
        actualSum = EulerMathHelper.sumOfSquares(numberOfTerms);
        squareOfSums = (long)Math.pow(numberOfTerms*(numberOfTerms+1)/2,2);

        System.out.println(" Difference (100 terms) "+(squareOfSums-actualSum));

    }
}
