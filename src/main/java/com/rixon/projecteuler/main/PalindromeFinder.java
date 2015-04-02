package com.rixon.projecteuler.main;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * Created by rixonmathew on 01/04/15.
 */
public class PalindromeFinder {
    public BigDecimal findLargestSixDigitPalindrome(Predicate<BigDecimal> condition) {
        BigDecimal palindrome = BigDecimal.valueOf(9009l);
        if (condition.test(palindrome)){
            return palindrome;
        }
        return BigDecimal.ZERO;
    }

    public boolean isPalindrome(BigDecimal startNumber) {
        boolean result = false;

        if (startNumber==null)
            return result;
        String string= startNumber.toPlainString();


        int lastIndex = string.length()-1;
        result = true;
        for (int i=0;i<=string.length()/2;i++) {
            if (string.charAt(i)!=string.charAt(lastIndex-i)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
