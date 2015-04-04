package com.rixon.projecteuler.main;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class LargestProductFinder {

    private String numberToScan;

    public String getNumberToScan() {
        return numberToScan;
    }

    public void setNumberToScan(String numberToScan) {
        this.numberToScan = numberToScan;
    }

    public long findForConsecutiveDigits(int consecutiveDigitToCheck) {
        long largestNumber = 0;
        String consecutiveDigits = null;
        for (int i=0;i<numberToScan.length()-consecutiveDigitToCheck;i++) {
            String substring = numberToScan.substring(i, i + consecutiveDigitToCheck);
            long product = multiplyDigits(substring);
            if (product>largestNumber){
                largestNumber = product;
                consecutiveDigits = substring;
            }
        }
        System.out.println("consecutiveDigits = " + consecutiveDigits);
        return largestNumber;
    }

    private long multiplyDigits(String substring) {
        long product = 1;
        for (char ch:substring.toCharArray()){
            product*=Character.getNumericValue(ch);
        }
        return product;
    }
}
