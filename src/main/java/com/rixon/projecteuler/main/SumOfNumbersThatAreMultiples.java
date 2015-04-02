package com.rixon.projecteuler.main;

import java.util.stream.LongStream;

/**
 * Created by rixonmathew on 03/01/15.
 * This class is used to compute the sum of multiples of two numbers less than a certain number
 * e.g. Find the sum of all the multiples of 3 or 5 below 1000
 */
public class SumOfNumbersThatAreMultiples {

    public long computeSum(int limit, int...numbers){

        return LongStream.range(1, Long.valueOf(limit)).filter(x -> {
            boolean multiple = false;
            for (int i=0;i<numbers.length;i++){
                if (x%numbers[i]==0){
                    multiple=true;
                    break;
                }
            }
            return multiple;
        }).sum();
    }
}
