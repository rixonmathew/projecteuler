package com.rixon.projecteuler.main;

import org.apache.commons.math3.util.Decimal64;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class EulerMathHelper {

    private static final String DELIMITER = " ";

    public static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    public static long sumOfSquares(long number) {
        return (number*(number+1)*(2*number+1))/6;
    }

    public static Decimal64[][] loadData(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        System.out.println(path.toAbsolutePath().toString());
        List<String> strings = Files.readAllLines(path);
        int records = strings.size();
        StringTokenizer stringTokenizer = new StringTokenizer(strings.get(0), DELIMITER);
        int columns = stringTokenizer.countTokens();
        Decimal64[][] data = new Decimal64[records][columns];
        for (int i=0;i<records;i++){
            String record = strings.get(i);
            stringTokenizer = new StringTokenizer(record, DELIMITER);
            for (int j=0;j<columns;j++){
                data[i][j] = new Decimal64(Double.valueOf(stringTokenizer.nextToken()));
            }
        }
        return data;

    }
}
