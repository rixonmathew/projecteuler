package com.rixon.projecteuler.common;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rixonmathew on 01/01/15.
 */
public class UtilsTest {

    @Test
    public void testMultiples() {
        BigDecimal number = new BigDecimal(1000);
        List<BigDecimal> multiples = new ArrayList<BigDecimal>();
        for (int i=2;i<number.intValue();i++){
            BigDecimal divide = number.remainder(BigDecimal.valueOf(i));
            System.out.println("divide = " + divide);
            if (divide.equals(BigDecimal.ZERO)){
                multiples.add(BigDecimal.valueOf(i));
            }
        }
        for (BigDecimal entry:multiples){
            System.out.println("number = " + entry);
        }

    }
}
