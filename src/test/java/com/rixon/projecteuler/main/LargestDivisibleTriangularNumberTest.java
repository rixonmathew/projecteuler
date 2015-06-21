package com.rixon.projecteuler.main;

import org.apache.commons.math3.primes.Primes;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by rixonmathew on 05/04/15.
 */
public class LargestDivisibleTriangularNumberTest {

    @Test
    public void testLargestTriangularNumber() {
        final Map<Long,Long> divisors = new HashMap<>();
        LongStream.rangeClosed(1, 12000).map(x -> {
            long returnValue = x * (x + 1) / 2;
            return returnValue;
        }).map(x -> {
            long countOfDivisors = 2;
            if (x == 1)
                return 1;
            for (int i = 2; i <= x / 2; i++) {
                if (x % i == 0) {
                    countOfDivisors++;
                }
            }
            divisors.put(countOfDivisors,x);
            return x;
        }).sum();
        Long maxDivisor = divisors.keySet().stream().max((o1, o2) -> o1.compareTo(o2)).get();
        System.out.println("number " + divisors.get(maxDivisor) + " with divisors " + maxDivisor);
    }

    @Test
    public void testFactorFinding(){
        //int number = 17907120;
        int number = 100;
        List<Integer> primeFactors = Primes.primeFactors(number);
        System.out.println("primeFactors = " + primeFactors);
    }

    private List<Integer> allFactorsFromPrime(List<Integer> primeFactors){
        //Map<Integer,Integer> countOfPrimes = primeFactors.stream().collect();
        return null;
    }

    @Test
    public void testCountOfWords() {
        Stream<String> words = Stream.of("Java", "Magazine", "is",
                "the", "best");

        Map<String, Long> letterToCount =
//                words.map(w -> w.split(""))
//                        .flatMap(Arrays::stream)
//                        .collect(groupingBy(identity(), counting()));
                words.map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .collect(groupingBy(identity(), counting()));

        System.out.println("letterToCount = " + letterToCount);
    }

}
