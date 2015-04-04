package com.rixon.projecteuler.main;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class TestPythagoreanTriplet {

    private PythagoreanTripletFinder pythagoreanTripletFinder;

    @Before
    public void setup() {
        pythagoreanTripletFinder = new PythagoreanTripletFinder();
    }

    @Test
    public void testFinder() {
        Triplet<Integer> triplet= pythagoreanTripletFinder.findTripletWhoseSumIsThousand();
        System.out.println("triplet = " + triplet);
    }

}
