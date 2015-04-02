package com.rixon.projecteuler.main;

import java.util.stream.LongStream;

/**
 * Created by rixonmathew on 01/04/15.
 */
public class FibbonaciSumComputer {

    public long sumOfFirstEvenTerms(long maxTermValue) {
        return LongStream.iterate(1, x -> x + 1).map(x->fibboTerm(x)).filter(x-> x % 2 == 0).limit(maxTermValue).peek(System.out::println).sum();
    }

    private long fibboTerm(long position) {
        if (position==1)
            return 1;
        if (position==2)
            return 2;
        else return fibboTerm(position-1)+fibboTerm(position-2);
    }
}
