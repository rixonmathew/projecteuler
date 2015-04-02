package com.rixon.projecteuler.main;

import org.apache.commons.math3.primes.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rixonmathew on 01/04/15.
 */
public class PrimeFactorFinder {
    public Set<Integer> find(long number) {
        Set<Integer> uniqueFactors = new HashSet<>();
        int suareRoot = (int)Math.sqrt(number);
        for (int n=2;n<=suareRoot;n++) {
            if (number%n==0 && Primes.isPrime(n)){
                uniqueFactors.add(n);
            }
        }
        return uniqueFactors;
    }
}
