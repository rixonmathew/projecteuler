package com.rixon.projecteuler.main;

import org.apache.commons.math3.primes.Primes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class NumberWithConsecutiveMultiplesFinder {
    public BigDecimal find(int numberUptillWhichMultiple) {
        List<Integer> primes = new ArrayList<>();
        for (int i=2;i<=numberUptillWhichMultiple;i++){
            if (Primes.isPrime(i)) {
                primes.add(i);
            }
        }
        long productOfPrimes = primes.stream().reduce((integer, integer2) -> integer*integer2).get();
        for (int i=2;i<=numberUptillWhichMultiple;i++) {
            if (productOfPrimes%i!=0){
                for (int prime:primes){
                    if (prime<i && i%prime==0){
                        productOfPrimes=EulerMathHelper.lcm(productOfPrimes,i);
                        break;
                    }
                }
            }
        }
        return BigDecimal.valueOf(productOfPrimes);
    }
}
