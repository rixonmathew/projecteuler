package com.rixon.projecteuler.main;

import org.apache.commons.math3.primes.Primes;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.LongStream;

import static org.junit.Assert.fail;

/**
 * Created by rixonmathew on 01/04/15.
 */
public class LargestPalindromeTest {

    private PalindromeFinder palindromeFinder;

    @Before
    public void setup(){
      palindromeFinder = new PalindromeFinder();
    }

    @Test
    public void testPalindrome() {
        assertIsPalindrome(BigDecimal.valueOf(9009l));
        assertIsNotPalindrome(BigDecimal.valueOf(123221l));
        assertIsPalindrome(BigDecimal.valueOf(554912219455l));
        assertIsNotPalindrome(BigDecimal.valueOf(554922219455l));
        assertIsNotPalindrome(BigDecimal.valueOf(100l));
        assertIsPalindrome(BigDecimal.valueOf(101l));
        assertIsPalindrome(BigDecimal.valueOf(11011l));
        assertIsPalindrome(BigDecimal.valueOf(1230321l));
        assertIsNotPalindrome(BigDecimal.valueOf(1230421l));
        assertIsNotPalindrome(BigDecimal.valueOf(12303212l));

    }

    private void assertIsNotPalindrome(BigDecimal numberToCheck) {
        if (palindromeFinder.isPalindrome(numberToCheck)){
            fail("Expected false for " + numberToCheck.toPlainString());
        }
    }

    private void assertIsPalindrome(BigDecimal numberToCheck) {
        if (!palindromeFinder.isPalindrome(numberToCheck)){
           fail("Expected true for " + numberToCheck.toPlainString());
        }
    }

    @Test
    public void testLargestSixDigitPalindrome() {

        BigDecimal palindrome = palindromeFinder.findLargestSixDigitPalindrome(x -> this.factorsAreThreeDigit(x));
        assertThatAllBiggerSixDigitAreNotPalindrome(palindrome);
    }

    private void assertThatAllBiggerSixDigitAreNotPalindrome(BigDecimal palindrome) {
        BigDecimal startNumber = palindrome;
        BigDecimal endNumber = BigDecimal.valueOf(1000000l);
        while (startNumber.compareTo(endNumber)<0){
            if (palindromeFinder.isPalindrome(startNumber)){
                fail("Bigger palindrome found "+startNumber);
            }
        }
    }

    public boolean factorsAreThreeDigit(BigDecimal number) {
        List<Integer> primeFactors = Primes.primeFactors(number.intValue());
        return false;
    }

    @Test
    public void testAllSixDigitPalindromeAndPrimeFactors(){
        BigDecimal startNumber = BigDecimal.valueOf(100_000l);
        BigDecimal endNumber = BigDecimal.valueOf(1_000_000l);
        while (startNumber.compareTo(endNumber)<0){
            if (palindromeFinder.isPalindrome(startNumber)){
                List<Integer> integers = Primes.primeFactors(startNumber.intValue());
                System.out.println("Palindrome "+startNumber);
                System.out.println("factors "+integers);
            }
            startNumber = startNumber.add(BigDecimal.ONE);
        }
    }

    @Test
    public void testFindLargestPalindrome() {
        /*
        Found 2147447412 with factors 99807 and 21516
        Found 906609 with factors 993 and 913
        Found 99000099 with factors 9999 and 9901
         */
        int palindrome = 0;
        int previousPalindrome = 0;
        int factor1 = 0;
        int factor2 = 0;

        for (int i=999;i>100;i--){
            for (int j=999;j>100;j--) {
                palindrome = i*j;
                if (palindromeFinder.isPalindrome(BigDecimal.valueOf(palindrome))){
                    if (palindrome>previousPalindrome){
                        previousPalindrome = palindrome;
                        factor1=i;
                        factor2=j;
                    }
                }
            }
        }

        //long sum = LongStream.rangeClosed(1, 100000).parallel().map(x -> LongStream.rangeClosed(1, x).map(y -> x*y).filter(z->palindromeFinder.isPalindrome(BigDecimal.valueOf(z))).max().orElse(0)).max().getAsLong();
        //LongStream.rangeClosed(100000000,999999999).parallel().filter(x->palindromeFinder.isPalindrome(BigDecimal.valueOf(x))).max().ifPresent(x->System.out.println(x));
        //System.out.println("sum = " + sum);
        System.out.println("Found " + previousPalindrome + " with factors " + factor1 + " and " + factor2);
    }
}


