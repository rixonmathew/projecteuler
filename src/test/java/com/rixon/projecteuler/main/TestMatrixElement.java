package com.rixon.projecteuler.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class TestMatrixElement {

    private MatrixSolver matrixSolver;
    private String fileName = "target/test-classes/matrixData1.txt";

    @Before
    public void setup() {
        matrixSolver = new MatrixSolver();
    }

    @Test
    public void testProductsOfConsecutiveElements() {
        int numberOfConsecutiveElements = 6;
        long expectedProduct =1_788_696;
        long actualProduct = matrixSolver.productOfConsecutiveElements(fileName,numberOfConsecutiveElements);
        assertEquals("Products are not same",expectedProduct,actualProduct);

    }
}
