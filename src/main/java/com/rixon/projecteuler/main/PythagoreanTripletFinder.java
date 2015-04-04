package com.rixon.projecteuler.main;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class PythagoreanTripletFinder {
    public Triplet<Integer> findTripletWhoseSumIsThousand() {
        for (int i=3;i<1000;i++){
            for (int j=i+1;j<1000;j++){
                for (int k=j+1;k<1000;k++){
                    if ((i*i+j*j==k*k) && (i+j+k==1000))
                        return new Triplet<>(i,j,k);
                }
            }
        }
    return null;
    }
}
