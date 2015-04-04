package com.rixon.projecteuler.main;

import org.apache.commons.math3.primes.Primes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class PrimeFinder {
    List<Long> primes = new ArrayList<>();
    public long findPrimerNumber(int termToFind) {
        if (primes.size()<termToFind){
            populatePrimes(termToFind);
        }
        return primes.get(termToFind-1);
    }

    private void populatePrimes(long termToFind) {
        int startValue = 3;
        if (primes.isEmpty()){
            primes.add(2l);
        } else {
            startValue = (int)primes.get(primes.size()-1).longValue()+2;
        }

        while (primes.size()<termToFind){
            if (Primes.isPrime(startValue)){
                primes.add((long)startValue);
            }
            startValue+=2;
        }
    }

    public long findSumOfPrimesUptil(int numberUptilWhicSumIsRequired) {
        return LongStream.rangeClosed(2, numberUptilWhicSumIsRequired).filter(x->Primes.isPrime((int)x)).peek(System.out::println).sum();
    }
}
